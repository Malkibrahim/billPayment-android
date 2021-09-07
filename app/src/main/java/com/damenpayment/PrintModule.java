package com.damenpayment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.pax.dal.IDAL;
import com.pax.dal.IPrinter;
import com.pax.dal.exceptions.PrinterDevException;
import com.pax.gl.page.IPage;
import com.pax.gl.page.PaxGLPage;
import com.pax.neptunelite.api.NeptuneLiteUser;
//import org.json.JSONException;
//import org.json.JSONObject;
import java.io.*;
import java.io.FileInputStream;
//import org.apache.commons;

//import java.util.Iterator;
// import org.json.*;
// import org.json.JSONArray;
// import org.json.JSONException;
// import org.json.JSONObject;
// import org.json.JSONString;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

public class PrintModule extends ReactContextBaseJavaModule {
//  static {
//    System.loadLibrary("DeviceConfig");
//  }

  // private Handler handler = new Handler();
  public static NeptuneLiteUser neptuneLiteUser;
  public static IDAL dal;
  public static PaxGLPage paxGLPage;
  public static IPrinter printer;
  EditText input;
  String name = "";
  String number = "";
  String fromMonth = "";
  String toMonth = "";
  String totalBillMount = "";
  String totalBill = "";
  String tafgeet = "";
  String zoneName = "";
  String collectDate = "";
  String collectorName = "";
  String transactionID = "";
  Boolean RePrint = false;

  String serialNumber = "";

  Callback serialSuccessCallback = null;
  Callback serialFailCallback = null;

  Callback printSuccess = null;
  Callback printFail = null;

  public PrintModule(ReactApplicationContext reactContext) {
    super(reactContext); // required by React Native
  }

  public void onShowMessage(final String message) {
    // handler.post(new Runnable() {
    // @Override
    // public void run() {
    // Toast.makeText(getReactApplicationContext(), message,
    // Toast.LENGTH_LONG).show();
    // }
    // });

    Toast
      .makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG)
      .show();
  }

  @Override
  // getName is required to define the name of the module represented in
  // JavaScript
  public String getName() {
    return "PrintPax";
  }

  @ReactMethod
  public void getSerialNumber(Callback success, Callback fail) {
    serialFailCallback = fail;
    serialSuccessCallback = success;
    if (Build.VERSION.SDK_INT <= 25) {
      serialNumber = Build.SERIAL;
      success.invoke(serialNumber);
    } else if (Build.VERSION.SDK_INT == 26) {
      int permissionCheck = ContextCompat.checkSelfPermission(
        getReactApplicationContext(),
        Manifest.permission.READ_PHONE_STATE
      );

      if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(
          getCurrentActivity(),
          new String[] { Manifest.permission.READ_PHONE_STATE },
          10
        );
      } else {
        serialNumber = Build.getSerial().toString();

        success.invoke(serialNumber);
      }
    }
  }
   @ReactMethod
   public int setAPNs(Callback success){
    try {
      Activity currentActivity = getCurrentActivity();
      success.invoke(NeptuneLiteUser.getInstance().getDal(currentActivity).getCommManager().switchAPN("Apn",
              "damen-s-pc",
              "",
              "",
              0));
//      return NeptuneLiteUser.getInstance().getDal(currentActivity).getCommManager().switchAPN("EtisalatApn",
//              "damenpos",
//              "",
//              "",
//              0);
   } catch (Exception e) {
      e.printStackTrace();
    }
     return 0;
   }
//   @ReactMethod
//   public boolean readAPN(Callback success) {
//     byte[] fileBytes;
//     try {
//       Context ctx = getReactApplicationContext();
//       AssetManager mngr = ctx.getAssets();
//      InputStream is = mngr.open("apn.xml");
//
//       fileBytes = new byte[is.available()];
//       System.out.println("Input Stream" + (char) is.read());
//
//       is.read(fileBytes);
//       is.close();
//
//      return  addAPNs(fileBytes,success);
//       //  return fileBytes;
//     } catch (IOException e) {
//     e.printStackTrace();
//         return false;
//    }
//   }
  @ReactMethod
  public void helloWorld(Callback success) {
    success.invoke("serialNumber");
  }

  public void onRequestPermissionsResult(
    int requestCode,
    String permissions[],
    int[] grantResults
  ) {
    switch (requestCode) {
      case 10:
        if (
          (grantResults.length > 0) &&
          (grantResults[0] == PackageManager.PERMISSION_GRANTED)
        ) {
          serialNumber = Build.getSerial().toString();
          serialSuccessCallback.invoke(serialNumber);
        } else {
          serialFailCallback.invoke("Fail");
        }
        break;
      default:
        break;
    }
  }

  @ReactMethod
  public void PrintReceipt(
    ReadableArray receipts,
    Boolean oneLogo,
    ReadableArray textsAfterLogo,
    Callback printSuccess,
    Callback printFail
  ) {


    // public void PrintReceipt2(ReadableArray receipts,String powerdBy ,Boolean
    // oneLogo, Callback printSuccess, Callback printFail) {
    // Get the entity of printer.
    neptuneLiteUser = NeptuneLiteUser.getInstance();
    try {
      dal = neptuneLiteUser.getDal(this.getReactApplicationContext());
      paxGLPage = PaxGLPage.getInstance(this.getReactApplicationContext());
      printer = dal.getPrinter();
      this.printSuccess = printSuccess;
      this.printFail = printFail;

      printBitmap(generate(receipts, oneLogo, textsAfterLogo));
      // printBitmap(generate2(receipts, oneLogo ,powerdBy ));
    } catch (Exception e) {
      onShowMessage("لا يمكن طباعة الايصال");
      printFail.invoke("Fail");
      e.printStackTrace();
      Log.d("getDal", e.toString());
    }
  }

  private Bitmap generate(
    ReadableArray receipts,
    Boolean oneLogo,
    ReadableArray textsAfterLogo
  ) {
    // private Bitmap generate2(ReadableArray receipts, Boolean oneLogo , String
    // powerdBy ) {

    IPage page = paxGLPage.createPage();

    for (int i = 0; i < receipts.size(); i++) {
      ReadableArray receipt = receipts.getArray(i);
      if (i == 0 && oneLogo == true || oneLogo == false) {
        page
          .addLine()
          .addUnit(
            BitmapFactory.decodeResource(
              getCurrentActivity().getResources(),
              R.mipmap.damenicon
            ),
            IPage.EAlign.CENTER
          );

        for (int j = 0; j < textsAfterLogo.size(); j++) {
          ReadableMap obj = textsAfterLogo.getMap(j);
          int size = obj.getInt("size");
          String align = obj.getString("align");
          String line = obj.getString("line");
          page
            .addLine()
            .addUnit(
              line,
              size,
              align.equals("r")
                ? IPage.EAlign.LEFT
                : align.equals("m") ? IPage.EAlign.CENTER : IPage.EAlign.RIGHT
            );
        }
      }

      for (int j = 0; j < receipt.size(); j++) {
        ReadableMap obj = receipt.getMap(j);
        int size = obj.getInt("size");
        String align = obj.getString("align");
        String line = obj.getString("line");
        page
          .addLine()
          .addUnit(
            line,
            size,
            align.equals("r")
              ? IPage.EAlign.LEFT
              : align.equals("m") ? IPage.EAlign.CENTER : IPage.EAlign.RIGHT
          );
      }
      page.addLine().addUnit("\n\n\n", 30);
    }
    return paxGLPage.pageToBitmap(page, 385);
  }

  public void init() {
    try {
      printer.init();
    } catch (PrinterDevException e) {
      e.printStackTrace();
      Log.d("init", e.toString());
    }
  }

  protected void printBitmap(Bitmap bitmap) {
    init();
    try {
      printer.printBitmap(bitmap);
    } catch (PrinterDevException e) {
      printFail.invoke("Fail");
      e.printStackTrace();
      Log.d("printBitmap", e.toString());
    }
    start(printer);
  }

  private int start(IPrinter printer) {
    try {
      int ret = printer.start();
      // printer is busy, please wait
      if (ret == 1) {
        onShowMessage("برجاء الانتظار ......");
      } else if (ret == 2) {
        onShowMessage("لا يوجد ورق لطباعة الايصال");
        printFail.invoke("Fail");
        return -1;
      } else if (ret == 8) {
        onShowMessage("برجاء اغلاق الماكينة قليلا ثم اعادة فتحها مرة اخرى");
        return -1;
      } else if (ret == 9) {
        onShowMessage("برجاء شحن الماكينة");
        printFail.invoke("Fail");
        return -1;
      } else if (ret != 0) {
        return -1;
      }

      onShowMessage("تم طباعة الايصال بنجاح");
      printSuccess.invoke("Success");
      return 0;
    } catch (Exception ex) {
      return 0;
    }
  }
}
