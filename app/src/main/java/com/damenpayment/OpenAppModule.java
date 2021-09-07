package com.damenpayment;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class OpenAppModule extends ReactContextBaseJavaModule {
    public OpenAppModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

    }

    ReactApplicationContext reactContext = null;
    Callback resultCallBack = null;
    BroadcastReceiver br;
    Boolean recieverReady = false;
    float amount = 0;

    @Override
    public String getName() {
        return "OpenAppModule";
    }

    @ReactMethod
    public void payAmount(float amount, String appName, Callback resultCallBack) {
        this.resultCallBack = resultCallBack;
        this.amount = amount;
        Boolean appIsFound = openApp(appName);
        if (appIsFound) {
            prepareBroadcastReceiver();
            // sendAmount(amount);
        } else
            resultCallBack.invoke("app not found");
    }

    private void prepareBroadcastReceiver() {
        if (!recieverReady) {
            BroadcastReceiver br = new MyBroadcastReceiver();
            reactContext.registerReceiver(br, new IntentFilter("my-custom-event"));
            recieverReady = true;
        }
    }

    private boolean openApp(String name) {
        PackageManager pm = reactContext.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(name);
        if (intent != null) {
            reactContext.startActivity(intent);
            return true;
        } else {
            Toast.makeText(getReactApplicationContext(), String.format("%s هذا التطبيق غير موجود", name),
                    Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private void sendAmount() {
        Intent intent = new Intent();
        intent.setAction("my-custom-event");
        intent.putExtra("sendAmount", String.valueOf(amount));
        reactContext.sendBroadcast(intent);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // StringBuilder sb = new StringBuilder();
            // sb.append("Action: " + intent.getAction() + "\n");
            // sb.append("message: " + intent.getExtras().getFloat("amount", 0) + "\n");

            String requestAmount = intent.getExtras().getString("requestAmount", "-1");
            String paymentResult = intent.getExtras().getString("paymentResult", "-1");
            if (requestAmount != "-1") {
                sendAmount();
            }

            if (paymentResult != "-1") {
                resultCallBack.invoke(paymentResult);
            }

            // String log = sb.toString();
            // resultCallBack.invoke(log);
            // reactContext.unregisterReceiver(br);
        }
    }

}