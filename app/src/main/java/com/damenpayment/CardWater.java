package com.damenpayment;

// import com.globaltronics.gtliba4.GTElectricityLib;
import com.efinance.eppclibwater.cardHandlers.CardResponse;
import com.efinance.eppclibwater.cardHandlers.PrePaidCard;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import java.io.*;
import java.util.*;

public class CardWater extends ReactContextBaseJavaModule {

  PrePaidCard prePaidCard = null;
  CardResponse cardResponse = null;

  // GTElectricityLib GT;
  // StringBuffer identifier;
  // StringBuffer electrictyCompany;
  // StringBuffer meterFeedBack;
  // String vendor;

  // throws Exception
  public CardWater(ReactApplicationContext reactContext) {
    super(reactContext);
    // prePaidCard = PrePaidCard.createCardObject();

    // GT = new GTElectricityLib();
    // identifier = new StringBuffer("");
    // electrictyCompany = new StringBuffer("");
    // meterFeedBack = new StringBuffer("");
    // vendor = "";
  }

  @Override
  public String getName() {
    return "CardWater";
  }


  private void init () throws Exception {
    prePaidCard = PrePaidCard.createCardObject();
    cardResponse =  prePaidCard.checkCardExists();
  }


  @ReactMethod
  public void read(Callback success, Callback fail)  {
    try {
      init();
      WritableMap map = Arguments.createMap();
//
//      map.putString("vendorCode", "vendorCode");
//      map.putString("cardData", "cardData");
//      map.putString("cardID", "cardID");


          if (cardResponse.responseCode == 0) {

            cardResponse = prePaidCard.getVendorName();
            String vendorCode = cardResponse.responseData;

            cardResponse = prePaidCard.readCardData();
            String  cardData = cardResponse.responseData;

            cardResponse = prePaidCard.getCardID();
            String cardID = cardResponse.responseData;

            int result = cardResponse.responseCode;

            map.putString("vendorName", vendorCode);
            map.putString("cardData", cardData);
            map.putString("cardID", cardID);
            success.invoke(map);
          }
          else
          {
            fail.invoke("حدث خطأ ما");

          }
    } catch (Exception e) {
      fail.invoke(e.getMessage());
      e.printStackTrace();
    }

    //
    //    CardResponse cardResponse =  prePaidCard.checkCardExists();
    //
    //    if (cardResponse.responseCode == 0) {
    //
    //      cardResponse = prePaidCard.getVendorName();
    //      String vendorCode = cardResponse.responseData;
    //
    //      cardResponse = prePaidCard.readCardData();
    //      String  cardData = cardResponse.responseData;
    //
    //      cardResponse = prePaidCard.getCardID();
    //      String cardID = cardResponse.responseData;
    //
    //      int result = cardResponse.responseCode;
    //      WritableMap map = Arguments.createMap();
    //
    //      map.putString("vendorCode", vendorCode);
    //      map.putString("cardData", cardData);
    //      map.putString("cardID", cardID);
    //      success.invoke(map);
    //    }
    //    else
    //    {
    //      fail.invoke("حدث خطأ ما");
    //
    //    }
  }

  @ReactMethod
  public void write(String charg, Callback success, Callback fail) {
    try {
      init();
      int cardRespons = prePaidCard.writeCardCharge(charg);
      success.invoke(cardRespons);
    } catch (Exception e) {
      fail.invoke(e.getMessage());
    }
  }
}
// try {
//   int identifierStatus = GT.ReadIdentifier(identifier);
//   int electrictyCompanyStatus = GT.ReadElectrictyCompany(electrictyCompany);
//   int meterFeedBackStatus = GT.ReadMeterFeedBack(meterFeedBack);
//   vendor = GT.readVendor();
//   System.out.println("Constructor called");
//   // Map map = new HashMap();
//   // //Adding elements to map
//   // map.put("identifier", identifier);
//   // map.put("electrictyCompany", electrictyCompany);
//   // map.put("meterFeedBack", meterFeedBack);
//   // map.put("vendor", vendor);
//   if (
//     identifierStatus == 0 &&
//     electrictyCompanyStatus == 0 &&
//     meterFeedBackStatus == 0
//   ) cb.invoke("ok"); else cb.invoke("no");
//   // cb.invoke("yes");
// } catch (Exception e) {
//   System.out.println(e);
//   cb.invoke(e);
// }
// GTElectricityLib GT = new GTElectricityLib();
// System.out.println("Constructor called");
// GT.PowerDown();
// StringBuffer s = new StringBuffer();
// int identifierStatus = GT.ReadIdentifier(s);
// cb.invoke(s);
