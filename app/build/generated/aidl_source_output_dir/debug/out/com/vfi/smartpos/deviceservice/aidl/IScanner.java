/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vfi.smartpos.deviceservice.aidl;
/**
 * \cn_
 * @brief 扫码器对象
 *
 * 实现设备对二维码扫码功能。
 * \_en_
 * @brief the object of scanner
 *
 * for scanning the bar-code or QR-code
 * \en_e
 * \code{.java}
 * \endcode
 * @version
 * @see
 *
 * @author: baoxl
 */
public interface IScanner extends android.os.IInterface
{
  /** Default implementation for IScanner. */
  public static class Default implements com.vfi.smartpos.deviceservice.aidl.IScanner
  {
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vfi.smartpos.deviceservice.aidl.IScanner
  {
    private static final java.lang.String DESCRIPTOR = "com.vfi.smartpos.deviceservice.aidl.IScanner";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vfi.smartpos.deviceservice.aidl.IScanner interface,
     * generating a proxy if needed.
     */
    public static com.vfi.smartpos.deviceservice.aidl.IScanner asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vfi.smartpos.deviceservice.aidl.IScanner))) {
        return ((com.vfi.smartpos.deviceservice.aidl.IScanner)iin);
      }
      return new com.vfi.smartpos.deviceservice.aidl.IScanner.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.vfi.smartpos.deviceservice.aidl.IScanner
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      public static com.vfi.smartpos.deviceservice.aidl.IScanner sDefaultImpl;
    }
    public static boolean setDefaultImpl(com.vfi.smartpos.deviceservice.aidl.IScanner impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.vfi.smartpos.deviceservice.aidl.IScanner getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
}
