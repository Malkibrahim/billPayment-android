package com.damenpayment;

import android.Manifest;
// pax
// import com.pax.dal.IDAL;
// import com.pax.dal.IPrinter;
// import com.pax.dal.exceptions.PrinterDevException;
// import com.pax.gl.page.IPage;
// import com.pax.gl.page.PaxGLPage;
// import com.pax.neptunelite.api.NeptuneLiteUser;

//verifone
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
import com.vfi.smartpos.deviceservice.aidl.IDeviceService;
import com.vfi.smartpos.deviceservice.aidl.IPrinter;
import com.vfi.smartpos.deviceservice.aidl.PrinterConfig;
import com.vfi.smartpos.deviceservice.aidl.PrinterListener;
import java.io.*;

public class PrintModuleVerifone extends ReactContextBaseJavaModule {

  //pax
  // public static NeptuneLiteUser neptuneLiteUser;
  // public static IDAL dal;
  // public static PaxGLPage paxGLPage;
  // public static IPrinter printer;

  String serialNumber = "";

  Callback serialSuccessCallback = null;
  Callback serialFailCallback = null;

  Callback printSuccess = null;
  Callback printFail = null;

  //verifone
  private static final String TAG = "SEEGYPT_TAG";
  IDeviceService iDeviceService;
  IPrinter iPrinter;

  public PrintModuleVerifone(ReactApplicationContext reactContext) {
    super(reactContext); // required by React Native
    InitializeFontFiles();

    Intent intent = new Intent();
    intent.setAction("com.vfi.smartpos.device_service");
    intent.setPackage("com.vfi.smartpos.deviceservice");
    boolean iSuccess = getReactApplicationContext()
      .bindService(intent, connection, Context.BIND_AUTO_CREATE);
    // if(iSuccess){
    //     Toast.makeText(getReactApplicationContext(),"Device ready",Toast.LENGTH_LONG).show();
    // } else{
    //     // Toast.makeText(getReactApplicationContext(),"Device not ready",Toast.LENGTH_LONG).show();
    // }
  }

  protected void InitializeFontFiles() {
    PrinterFonts.initialize(getReactApplicationContext().getAssets());
  }

  public void onShowMessage(final String message) {
    Toast
      .makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG)
      .show();
  }

  @Override
  public String getName() {
    return "PrintVerifone";
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

  private ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      iDeviceService = IDeviceService.Stub.asInterface(service);

      try {
        iPrinter = iDeviceService.getPrinter();
      } catch (RemoteException e) {
        e.printStackTrace();
      }
      // Toast.makeText(getReactApplicationContext(),"bind service success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
      // Toast.makeText(getReactApplicationContext(),"bind service Disconnect",Toast.LENGTH_LONG).show();
    }
  };

  @ReactMethod
  public void PrintReceipt(
    ReadableArray receipts,
    Boolean oneLogo,
    ReadableArray textsAfterLogo,
    Callback printSuccess,
    Callback printFail
  ) {
    this.printSuccess = printSuccess;
    this.printFail = printFail;

    try {
      for (int i = 0; i < receipts.size(); i++) {
        ReadableArray receipt = receipts.getArray(i);
        if (i == 0 && oneLogo == true || oneLogo == false) {
          byte[] buffer = null;
          InputStream is = null;
          try {
            is = getReactApplicationContext().getAssets().open("logoDamen.jpg");
            // get the size
            int size = is.available();
            // crete the array of byte
            buffer = new byte[size];
            is.read(buffer);
            // close the stream
            is.close();
            Log.d(TAG, "image");
          } catch (IOException e) {
            Log.d(TAG, "image fail");
            e.printStackTrace();
          }
          if (null != buffer) {
            Bundle fmtImage = new Bundle();
            fmtImage.putInt("offset", (384 - 200) / 2);
            fmtImage.putInt("width", 250); // bigger then actual, will print the actual
            fmtImage.putInt("height", 128); // bigger then actual, will print the actual
            iPrinter.addImage(fmtImage, buffer);
          }
          iPrinter.feedLine(2);

          for (int j = 0; j < textsAfterLogo.size(); j++) {
            ReadableMap obj = textsAfterLogo.getMap(j);
            int size = obj.getInt("size");
            String align = obj.getString("align");
            String line = obj.getString("line");

            Bundle format = new Bundle();
            if (size <= 12) {
              format.putInt(
                PrinterConfig.addText.FontSize.BundleName,
                PrinterConfig.addText.FontSize.SMALL_16_16
              );
            } else if (size <= 24) {
              format.putInt(
                PrinterConfig.addText.FontSize.BundleName,
                PrinterConfig.addText.FontSize.NORMAL_24_24
              );
            } else {
              format.putInt(
                PrinterConfig.addText.FontSize.BundleName,
                PrinterConfig.addText.FontSize.LARGE_32_32
              );
            }

            // format.putInt(
            //   PrinterConfig.addText.Alignment.BundleName,
            //   align.equals("r")
            //     ? PrinterConfig.addText.Alignment.RIGHT
            //     : align.equals("m")
            //       ? PrinterConfig.addText.Alignment.CENTER
            //       : PrinterConfig.addText.Alignment.LEFT
            // );

            if (align.equals("r")) iPrinter.addTextInLine(
              format,
              "",
              "",
              line,
              0
            ); else if (align.equals("m")) iPrinter.addTextInLine(
              format,
              "",
              line,
              "",
              0
            ); else iPrinter.addTextInLine(format, line, "", "", 0);

            // iPrinter.addText(format, line);
            iPrinter.feedLine(1);
          }
        }
        for (int j = 0; j < receipt.size(); j++) {
          ReadableMap obj = receipt.getMap(j);
          int size = obj.getInt("size");
          String align = obj.getString("align");
          String line = obj.getString("line");

          Bundle format = new Bundle();
          if (size <= 12) {
            format.putInt(
              PrinterConfig.addText.FontSize.BundleName,
              PrinterConfig.addText.FontSize.SMALL_16_16
            );
          } else if (size <= 24) {
            format.putInt(
              PrinterConfig.addText.FontSize.BundleName,
              PrinterConfig.addText.FontSize.NORMAL_24_24
            );
          } else {
            format.putInt(
              PrinterConfig.addText.FontSize.BundleName,
              PrinterConfig.addText.FontSize.LARGE_32_32
            );
          }

          // format.putInt(
          //   PrinterConfig.addText.Alignment.BundleName,
          //   align.equals("r")
          //     ? PrinterConfig.addText.Alignment.RIGHT
          //     : align.equals("m")
          //       ? PrinterConfig.addText.Alignment.CENTER
          //       : PrinterConfig.addText.Alignment.LEFT
          // );
          if (align.equals("r")) iPrinter.addTextInLine(
            format,
            "",
            "",
            line,
            0
          ); else if (align.equals("m")) iPrinter.addTextInLine(
            format,
            "",
            line,
            "",
            0
          ); else iPrinter.addTextInLine(format, line, "", "", 0);
          //line

          iPrinter.feedLine(1);
        }
        iPrinter.feedLine(2);
      }
      iPrinter.feedLine(6);
      iPrinter.startPrint(new MyListener());
    } catch (Exception e) {
      onShowMessage("لا يمكن طباعة الايصال");
      printFail.invoke("Fail");
      e.printStackTrace();
      Log.d("getDal", e.toString());
    }
  }

  private class MyListener extends PrinterListener.Stub {

    @Override
    public void onFinish() throws RemoteException {
      printSuccess.invoke("Success");
      Log.d(TAG, "onFinish");
    }

    @Override
    public void onError(int error) throws RemoteException {
      printFail.invoke("fail");
      Log.d(TAG, "onError");
    }
  }
}
