/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vfi.smartpos.deviceservice.aidl;
/**
 * \cn_
 * @brief 串口设备对象
 *
 * 实现串口数据收发功能。
 * \_en_
 * @brief the object of serial port for serial communication
 *
 * \en_e
 * \code{.java}
 * \endcode
 * @version
 * @see IDeviceService#getSerialPort
 *
 * @author: baoxl
 */
public interface ISerialPort extends android.os.IInterface
{
  /** Default implementation for ISerialPort. */
  public static class Default implements com.vfi.smartpos.deviceservice.aidl.ISerialPort
  {
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vfi.smartpos.deviceservice.aidl.ISerialPort
  {
    private static final java.lang.String DESCRIPTOR = "com.vfi.smartpos.deviceservice.aidl.ISerialPort";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vfi.smartpos.deviceservice.aidl.ISerialPort interface,
     * generating a proxy if needed.
     */
    public static com.vfi.smartpos.deviceservice.aidl.ISerialPort asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vfi.smartpos.deviceservice.aidl.ISerialPort))) {
        return ((com.vfi.smartpos.deviceservice.aidl.ISerialPort)iin);
      }
      return new com.vfi.smartpos.deviceservice.aidl.ISerialPort.Stub.Proxy(obj);
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
    private static class Proxy implements com.vfi.smartpos.deviceservice.aidl.ISerialPort
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
      public static com.vfi.smartpos.deviceservice.aidl.ISerialPort sDefaultImpl;
    }
    public static boolean setDefaultImpl(com.vfi.smartpos.deviceservice.aidl.ISerialPort impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.vfi.smartpos.deviceservice.aidl.ISerialPort getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
}
