/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vfi.smartpos.deviceservice.aidl;
/**
 * \cn_
 * @brief
 *
 * \_en_
 * @brief
 *
 * \en_e
 * \code{.java}
 * \endcode
 * @version
 * @see
 *
 * \cn_
 * @brief 密码键盘对象
 *
 * 实现金融交易过程中密钥管理、数据加密和PIN输入处理过程。
 * \_en_
 * @brief the object of PIN pad
 *
 * download keys, data encrypt, pin input
 * \en_e
 * \code{.java}
 * \endcode
 * @version
 * @see
 *
 * @author Kai.L@verifone.cn, Chao.L@verifone.cn
 */
public interface IPinpad extends android.os.IInterface
{
  /** Default implementation for IPinpad. */
  public static class Default implements com.vfi.smartpos.deviceservice.aidl.IPinpad
  {
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vfi.smartpos.deviceservice.aidl.IPinpad
  {
    private static final java.lang.String DESCRIPTOR = "com.vfi.smartpos.deviceservice.aidl.IPinpad";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vfi.smartpos.deviceservice.aidl.IPinpad interface,
     * generating a proxy if needed.
     */
    public static com.vfi.smartpos.deviceservice.aidl.IPinpad asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vfi.smartpos.deviceservice.aidl.IPinpad))) {
        return ((com.vfi.smartpos.deviceservice.aidl.IPinpad)iin);
      }
      return new com.vfi.smartpos.deviceservice.aidl.IPinpad.Stub.Proxy(obj);
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
    private static class Proxy implements com.vfi.smartpos.deviceservice.aidl.IPinpad
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
      public static com.vfi.smartpos.deviceservice.aidl.IPinpad sDefaultImpl;
    }
    public static boolean setDefaultImpl(com.vfi.smartpos.deviceservice.aidl.IPinpad impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.vfi.smartpos.deviceservice.aidl.IPinpad getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
}
