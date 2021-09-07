package com.damenpayment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.pax.neptunelite.api.NeptuneLiteUser;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class MyDeviceInfoModule extends ReactContextBaseJavaModule {
    public MyDeviceInfoModule(ReactApplicationContext reactContext) {
        super(reactContext); // required by React Native
    }

    @Override
    // getName is required to define the name of the module represented in
    // JavaScript
    public String getName() {
        return "MyDeviceInfoModule";
    }

    @ReactMethod
    public void getSerialNumber(Callback success, Callback fail) {

        if (Build.VERSION.SDK_INT <= 25) {
            success.invoke(Build.SERIAL);
        } else {
            success.invoke(Build.getSerial().toString());
        }

    }
      @ReactMethod
  public boolean addAPNs(byte[] data){
    try {
      Activity currentActivity = getCurrentActivity();
      return NeptuneLiteUser.getInstance().getDal(currentActivity).getCommManager().addApns(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
  @ReactMethod
  public boolean readAPN() {
    byte[] fileBytes;
    try {
      Context ctx = getReactApplicationContext();
      AssetManager mngr = ctx.getAssets();
      InputStream is = mngr.open("apn.xml");
      fileBytes = new byte[is.available()];
      is.read(fileBytes);
      is.close();
      return  addAPNs(fileBytes);
      //  return fileBytes;

    } catch (IOException e) {
      e.printStackTrace();
        return false;
    }
  }
}