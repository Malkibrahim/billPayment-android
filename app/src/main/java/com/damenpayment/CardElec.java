package com.damenpayment;

import android.widget.Toast;

import com.efinance.eppclib.cardHandlers.CardResponse;
import com.efinance.eppclib.cardHandlers.PrePaidCard;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
// import com.globaltronics.gtliba4.GTElectricityLib;
import java.io.*;
import java.util.*;

public class CardElec extends ReactContextBaseJavaModule {

  PrePaidCard prePaidCard = null;
  CardResponse cardResponse = null;

  public CardElec(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "CardElec";
  }

  private void init() throws Exception {
    prePaidCard = PrePaidCard.createCardObject();
    String message = prePaidCard.toString();
    Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void read(Callback success, Callback fail,Callback test ) {
    try {
      test.invoke("tests");
      init();
      WritableMap map = Arguments.createMap();
      if (prePaidCard != null) {
        cardResponse = prePaidCard.getVendorName();
        String vendorCode = cardResponse.responseData;

        cardResponse = prePaidCard.getMeterType();
        String meterType = cardResponse.responseData;

        cardResponse =prePaidCard.readCardDataUnified();
        String cardData = cardResponse.responseData;
//        if(vendorCode=="iskra"){
//           cardData= String.valueOf(new StringBuilder(cardData).append(meterType));
//
//         }
        cardResponse = prePaidCard.getCardID();
        String cardID = cardResponse.responseData;

        int result = cardResponse.responseCode;

        map.putString("vendorName", vendorCode);
        map.putString("cardData", cardData);
        map.putString("cardID", cardID);
        success.invoke(map);
      } else {
        fail.invoke("حدث خطأ ما");
      }
    } catch (Exception e) {
      fail.invoke(e.getMessage());
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void write(String charg, Callback success, Callback fail) {
    try {
      init();
      int cardRespons = prePaidCard.writeCardChargeUnified(charg);
      success.invoke(cardRespons);
    } catch (Exception e) {
      fail.invoke(e.getMessage());
    }
  }
}
