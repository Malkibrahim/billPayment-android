/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vfi.smartpos.deviceservice.aidl;
/**
 * 打印结果监听器 | listener of printer
 * @author: baoxl
 */
public interface PrinterListener extends android.os.IInterface
{
  /** Default implementation for PrinterListener. */
  public static class Default implements com.vfi.smartpos.deviceservice.aidl.PrinterListener
  {
    /**
    	 * 打印成功回调 | on print finished
    	 */
    @Override public void onFinish() throws android.os.RemoteException
    {
    }
    /**
    	 * 打印失败回调 | on error occur
    	 * @param error - 错误码 | the error code
    	 */
    @Override public void onError(int error) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vfi.smartpos.deviceservice.aidl.PrinterListener
  {
    private static final java.lang.String DESCRIPTOR = "com.vfi.smartpos.deviceservice.aidl.PrinterListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vfi.smartpos.deviceservice.aidl.PrinterListener interface,
     * generating a proxy if needed.
     */
    public static com.vfi.smartpos.deviceservice.aidl.PrinterListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vfi.smartpos.deviceservice.aidl.PrinterListener))) {
        return ((com.vfi.smartpos.deviceservice.aidl.PrinterListener)iin);
      }
      return new com.vfi.smartpos.deviceservice.aidl.PrinterListener.Stub.Proxy(obj);
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
        case TRANSACTION_onFinish:
        {
          data.enforceInterface(descriptor);
          this.onFinish();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_onError:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.onError(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.vfi.smartpos.deviceservice.aidl.PrinterListener
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
      /**
      	 * 打印成功回调 | on print finished
      	 */
      @Override public void onFinish() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onFinish, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onFinish();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /**
      	 * 打印失败回调 | on error occur
      	 * @param error - 错误码 | the error code
      	 */
      @Override public void onError(int error) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(error);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onError, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onError(error);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static com.vfi.smartpos.deviceservice.aidl.PrinterListener sDefaultImpl;
    }
    static final int TRANSACTION_onFinish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(com.vfi.smartpos.deviceservice.aidl.PrinterListener impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.vfi.smartpos.deviceservice.aidl.PrinterListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
  	 * 打印成功回调 | on print finished
  	 */
  public void onFinish() throws android.os.RemoteException;
  /**
  	 * 打印失败回调 | on error occur
  	 * @param error - 错误码 | the error code
  	 */
  public void onError(int error) throws android.os.RemoteException;
}
