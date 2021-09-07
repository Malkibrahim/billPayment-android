/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vfi.smartpos.deviceservice.aidl;
/**
 * \cn_
 * @brief 设备服务对象，提供范围终端各外设对象的服务接口
 *
 * \_en_
 * @brief Device service, get each interface (object) in this interface
 *
 * \en_e
 * \code{.java}
 * \endcode
 * @author: baoxl
 */
public interface IDeviceService extends android.os.IInterface
{
  /** Default implementation for IDeviceService. */
  public static class Default implements com.vfi.smartpos.deviceservice.aidl.IDeviceService
  {
    /**
         * \cn_
         * @brief 获取蜂鸣器操作对象
         *
         * @return IBeeper对象，参见IBeeper.aidl类 | @return object IBeeper, please refer IBeeper.aidl
         * \_en_
         * @brief get the IBeeper for beeper
         *
         * @return object IBeeper, please refer IBeeper.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IBeeper
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IBeeper getBeeper() throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取LED灯操作对象
         *
         * @return ILed对象，参见ILed.aidl类 | @return object ILed, please refer ILed.aidl
         * \_en_
         * @brief get the ILed for led
         *
         * @return object ILed, please refer ILed.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see ILed
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.ILed getLed() throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取串口操作对象
         *
         * @param deviceType - 串口连接线种类 | String rs232 or usb-rs232
         * @return ISerialPort对象，参见ISerialPort.aidl类 | @return object ISerialPort, please refer ISerialPort.aidl
         * \_en_
         * @brief get the ISerialPort for serial
         *
         * @param deviceType <BR>
         *     String "rs232" means the port via build in serial chip micro USB cable (one side is micro USB connect to terminal, another side is 9 pin interface connect to COM port in PC.)<BR>
         *     "usb-rs232" means the port via micro USB cable<BR>
         * @return object ISerialPort, please refer ISerialPort.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see ISerialPort
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.ISerialPort getSerialPort(java.lang.String deviceType) throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取扫码器操作对象
         *
         * @param cameraId - 1-前置扫码器，0-后置扫码器 | 1 for front, 0 for rear
         * @return IScanner对象，参见IScanner.aidl类 | @return object IScanner, please refer IScanner.aidl
         * \_en_
         * @brief get the IScanner for scanner
         *
         * @param cameraId 1 for front, 0 for rear
         * @return object IScanner, please refer IScanner.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IScanner
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IScanner getScanner(int cameraId) throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取磁卡操作句柄
         *
         * @return IMagCardReader对象，参见IMagCardReader.aidl类 | @return IMagCardReader, please refer IMagCardReader.aidl
         * \_en_
         * @brief get the IMagCardReader for magnetic card reader
         *
         * @return IMagCardReader, please refer IMagCardReader.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IMagCardReader
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IMagCardReader getMagCardReader() throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取IC卡操作对象
         *
         * 0 IC卡 1 SAM1卡 2 SAM2卡 | 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
         * @return IC卡操作对象，参见IInsertCardReader.aidl类 | @return IInertCardReader, please refer IInsertCardReader.aidl
         * \_en_
         * @brief get the IInsertCardReader for smart card and PSAM card
         *
         * @param slotNo 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
         * @return IInertCardReader, please refer IInsertCardReader.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IInertCardReader
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IInsertCardReader getInsertCardReader(int slotNo) throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取RF卡操作对象
         *
         * @return RF卡操作对象，参见IRFCardReader.aidl类| @ return IRFCardReader, please refer IRFCardReader.aidl
         * \_en_
         * @brief get the IRFCardReader for CTLS card
         *
         * @return IRFCardReader, please refer IRFCardReader.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IRFCardReader
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IRFCardReader getRFCardReader() throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取密码键盘操作对象
         *
         * @param kapId  密码键盘kapId索引，每个kapId对一个逻辑密码键盘 | kapId, the index refer the key set
         * @return IPinpad对象，参见IPinpad.aidl类 | @return IPinpad, please refer IPinpad.aidl
         * \_en_
         * @brief get IPinpad for Pinpad
         *
         * @param kapId  the index refer the keys set
         * @return IPinpad, please refer IPinpad.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IPinpad
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IPinpad getPinpad(int kapId) throws android.os.RemoteException
    {
      return null;
    }
    /**
         * \cn_
         * @brief 获取打印机操作对象
         *
         * @return IPrinter对象，参见IPrinter.aidl类 | @return IPrinter, please refer IPrinter.aidl
         * \_en_
         * @brief get IPrinter for printer
         *
         * @return IPrinter, please refer IPrinter.aidl
         * \en_e
         * \code{.java}
         * \endcode
         * @version
         * @see IPrinter
         */
    @Override public com.vfi.smartpos.deviceservice.aidl.IPrinter getPrinter() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vfi.smartpos.deviceservice.aidl.IDeviceService
  {
    private static final java.lang.String DESCRIPTOR = "com.vfi.smartpos.deviceservice.aidl.IDeviceService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vfi.smartpos.deviceservice.aidl.IDeviceService interface,
     * generating a proxy if needed.
     */
    public static com.vfi.smartpos.deviceservice.aidl.IDeviceService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vfi.smartpos.deviceservice.aidl.IDeviceService))) {
        return ((com.vfi.smartpos.deviceservice.aidl.IDeviceService)iin);
      }
      return new com.vfi.smartpos.deviceservice.aidl.IDeviceService.Stub.Proxy(obj);
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
        case TRANSACTION_getBeeper:
        {
          data.enforceInterface(descriptor);
          com.vfi.smartpos.deviceservice.aidl.IBeeper _result = this.getBeeper();
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getLed:
        {
          data.enforceInterface(descriptor);
          com.vfi.smartpos.deviceservice.aidl.ILed _result = this.getLed();
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getSerialPort:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          com.vfi.smartpos.deviceservice.aidl.ISerialPort _result = this.getSerialPort(_arg0);
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getScanner:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          com.vfi.smartpos.deviceservice.aidl.IScanner _result = this.getScanner(_arg0);
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getMagCardReader:
        {
          data.enforceInterface(descriptor);
          com.vfi.smartpos.deviceservice.aidl.IMagCardReader _result = this.getMagCardReader();
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getInsertCardReader:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          com.vfi.smartpos.deviceservice.aidl.IInsertCardReader _result = this.getInsertCardReader(_arg0);
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getRFCardReader:
        {
          data.enforceInterface(descriptor);
          com.vfi.smartpos.deviceservice.aidl.IRFCardReader _result = this.getRFCardReader();
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getPinpad:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          com.vfi.smartpos.deviceservice.aidl.IPinpad _result = this.getPinpad(_arg0);
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        case TRANSACTION_getPrinter:
        {
          data.enforceInterface(descriptor);
          com.vfi.smartpos.deviceservice.aidl.IPrinter _result = this.getPrinter();
          reply.writeNoException();
          reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.vfi.smartpos.deviceservice.aidl.IDeviceService
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
           * \cn_
           * @brief 获取蜂鸣器操作对象
           *
           * @return IBeeper对象，参见IBeeper.aidl类 | @return object IBeeper, please refer IBeeper.aidl
           * \_en_
           * @brief get the IBeeper for beeper
           *
           * @return object IBeeper, please refer IBeeper.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IBeeper
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IBeeper getBeeper() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IBeeper _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getBeeper, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getBeeper();
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IBeeper.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取LED灯操作对象
           *
           * @return ILed对象，参见ILed.aidl类 | @return object ILed, please refer ILed.aidl
           * \_en_
           * @brief get the ILed for led
           *
           * @return object ILed, please refer ILed.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see ILed
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.ILed getLed() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.ILed _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getLed, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getLed();
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.ILed.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取串口操作对象
           *
           * @param deviceType - 串口连接线种类 | String rs232 or usb-rs232
           * @return ISerialPort对象，参见ISerialPort.aidl类 | @return object ISerialPort, please refer ISerialPort.aidl
           * \_en_
           * @brief get the ISerialPort for serial
           *
           * @param deviceType <BR>
           *     String "rs232" means the port via build in serial chip micro USB cable (one side is micro USB connect to terminal, another side is 9 pin interface connect to COM port in PC.)<BR>
           *     "usb-rs232" means the port via micro USB cable<BR>
           * @return object ISerialPort, please refer ISerialPort.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see ISerialPort
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.ISerialPort getSerialPort(java.lang.String deviceType) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.ISerialPort _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(deviceType);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getSerialPort, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getSerialPort(deviceType);
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.ISerialPort.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取扫码器操作对象
           *
           * @param cameraId - 1-前置扫码器，0-后置扫码器 | 1 for front, 0 for rear
           * @return IScanner对象，参见IScanner.aidl类 | @return object IScanner, please refer IScanner.aidl
           * \_en_
           * @brief get the IScanner for scanner
           *
           * @param cameraId 1 for front, 0 for rear
           * @return object IScanner, please refer IScanner.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IScanner
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IScanner getScanner(int cameraId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IScanner _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(cameraId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getScanner, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getScanner(cameraId);
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IScanner.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取磁卡操作句柄
           *
           * @return IMagCardReader对象，参见IMagCardReader.aidl类 | @return IMagCardReader, please refer IMagCardReader.aidl
           * \_en_
           * @brief get the IMagCardReader for magnetic card reader
           *
           * @return IMagCardReader, please refer IMagCardReader.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IMagCardReader
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IMagCardReader getMagCardReader() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IMagCardReader _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getMagCardReader, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getMagCardReader();
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IMagCardReader.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取IC卡操作对象
           *
           * 0 IC卡 1 SAM1卡 2 SAM2卡 | 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
           * @return IC卡操作对象，参见IInsertCardReader.aidl类 | @return IInertCardReader, please refer IInsertCardReader.aidl
           * \_en_
           * @brief get the IInsertCardReader for smart card and PSAM card
           *
           * @param slotNo 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
           * @return IInertCardReader, please refer IInsertCardReader.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IInertCardReader
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IInsertCardReader getInsertCardReader(int slotNo) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IInsertCardReader _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(slotNo);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getInsertCardReader, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getInsertCardReader(slotNo);
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IInsertCardReader.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取RF卡操作对象
           *
           * @return RF卡操作对象，参见IRFCardReader.aidl类| @ return IRFCardReader, please refer IRFCardReader.aidl
           * \_en_
           * @brief get the IRFCardReader for CTLS card
           *
           * @return IRFCardReader, please refer IRFCardReader.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IRFCardReader
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IRFCardReader getRFCardReader() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IRFCardReader _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getRFCardReader, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getRFCardReader();
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IRFCardReader.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取密码键盘操作对象
           *
           * @param kapId  密码键盘kapId索引，每个kapId对一个逻辑密码键盘 | kapId, the index refer the key set
           * @return IPinpad对象，参见IPinpad.aidl类 | @return IPinpad, please refer IPinpad.aidl
           * \_en_
           * @brief get IPinpad for Pinpad
           *
           * @param kapId  the index refer the keys set
           * @return IPinpad, please refer IPinpad.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IPinpad
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IPinpad getPinpad(int kapId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IPinpad _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(kapId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getPinpad, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getPinpad(kapId);
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IPinpad.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * \cn_
           * @brief 获取打印机操作对象
           *
           * @return IPrinter对象，参见IPrinter.aidl类 | @return IPrinter, please refer IPrinter.aidl
           * \_en_
           * @brief get IPrinter for printer
           *
           * @return IPrinter, please refer IPrinter.aidl
           * \en_e
           * \code{.java}
           * \endcode
           * @version
           * @see IPrinter
           */
      @Override public com.vfi.smartpos.deviceservice.aidl.IPrinter getPrinter() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.vfi.smartpos.deviceservice.aidl.IPrinter _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getPrinter, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getPrinter();
          }
          _reply.readException();
          _result = com.vfi.smartpos.deviceservice.aidl.IPrinter.Stub.asInterface(_reply.readStrongBinder());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.vfi.smartpos.deviceservice.aidl.IDeviceService sDefaultImpl;
    }
    static final int TRANSACTION_getBeeper = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getLed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getSerialPort = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_getScanner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getMagCardReader = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_getInsertCardReader = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_getRFCardReader = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_getPinpad = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_getPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    public static boolean setDefaultImpl(com.vfi.smartpos.deviceservice.aidl.IDeviceService impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.vfi.smartpos.deviceservice.aidl.IDeviceService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * \cn_
       * @brief 获取蜂鸣器操作对象
       *
       * @return IBeeper对象，参见IBeeper.aidl类 | @return object IBeeper, please refer IBeeper.aidl
       * \_en_
       * @brief get the IBeeper for beeper
       *
       * @return object IBeeper, please refer IBeeper.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IBeeper
       */
  public com.vfi.smartpos.deviceservice.aidl.IBeeper getBeeper() throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取LED灯操作对象
       *
       * @return ILed对象，参见ILed.aidl类 | @return object ILed, please refer ILed.aidl
       * \_en_
       * @brief get the ILed for led
       *
       * @return object ILed, please refer ILed.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see ILed
       */
  public com.vfi.smartpos.deviceservice.aidl.ILed getLed() throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取串口操作对象
       *
       * @param deviceType - 串口连接线种类 | String rs232 or usb-rs232
       * @return ISerialPort对象，参见ISerialPort.aidl类 | @return object ISerialPort, please refer ISerialPort.aidl
       * \_en_
       * @brief get the ISerialPort for serial
       *
       * @param deviceType <BR>
       *     String "rs232" means the port via build in serial chip micro USB cable (one side is micro USB connect to terminal, another side is 9 pin interface connect to COM port in PC.)<BR>
       *     "usb-rs232" means the port via micro USB cable<BR>
       * @return object ISerialPort, please refer ISerialPort.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see ISerialPort
       */
  public com.vfi.smartpos.deviceservice.aidl.ISerialPort getSerialPort(java.lang.String deviceType) throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取扫码器操作对象
       *
       * @param cameraId - 1-前置扫码器，0-后置扫码器 | 1 for front, 0 for rear
       * @return IScanner对象，参见IScanner.aidl类 | @return object IScanner, please refer IScanner.aidl
       * \_en_
       * @brief get the IScanner for scanner
       *
       * @param cameraId 1 for front, 0 for rear
       * @return object IScanner, please refer IScanner.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IScanner
       */
  public com.vfi.smartpos.deviceservice.aidl.IScanner getScanner(int cameraId) throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取磁卡操作句柄
       *
       * @return IMagCardReader对象，参见IMagCardReader.aidl类 | @return IMagCardReader, please refer IMagCardReader.aidl
       * \_en_
       * @brief get the IMagCardReader for magnetic card reader
       *
       * @return IMagCardReader, please refer IMagCardReader.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IMagCardReader
       */
  public com.vfi.smartpos.deviceservice.aidl.IMagCardReader getMagCardReader() throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取IC卡操作对象
       *
       * 0 IC卡 1 SAM1卡 2 SAM2卡 | 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
       * @return IC卡操作对象，参见IInsertCardReader.aidl类 | @return IInertCardReader, please refer IInsertCardReader.aidl
       * \_en_
       * @brief get the IInsertCardReader for smart card and PSAM card
       *
       * @param slotNo 0 for IC card slot, 1 for SAM1 card slot, 2 for SAM2 card slot
       * @return IInertCardReader, please refer IInsertCardReader.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IInertCardReader
       */
  public com.vfi.smartpos.deviceservice.aidl.IInsertCardReader getInsertCardReader(int slotNo) throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取RF卡操作对象
       *
       * @return RF卡操作对象，参见IRFCardReader.aidl类| @ return IRFCardReader, please refer IRFCardReader.aidl
       * \_en_
       * @brief get the IRFCardReader for CTLS card
       *
       * @return IRFCardReader, please refer IRFCardReader.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IRFCardReader
       */
  public com.vfi.smartpos.deviceservice.aidl.IRFCardReader getRFCardReader() throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取密码键盘操作对象
       *
       * @param kapId  密码键盘kapId索引，每个kapId对一个逻辑密码键盘 | kapId, the index refer the key set
       * @return IPinpad对象，参见IPinpad.aidl类 | @return IPinpad, please refer IPinpad.aidl
       * \_en_
       * @brief get IPinpad for Pinpad
       *
       * @param kapId  the index refer the keys set
       * @return IPinpad, please refer IPinpad.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IPinpad
       */
  public com.vfi.smartpos.deviceservice.aidl.IPinpad getPinpad(int kapId) throws android.os.RemoteException;
  /**
       * \cn_
       * @brief 获取打印机操作对象
       *
       * @return IPrinter对象，参见IPrinter.aidl类 | @return IPrinter, please refer IPrinter.aidl
       * \_en_
       * @brief get IPrinter for printer
       *
       * @return IPrinter, please refer IPrinter.aidl
       * \en_e
       * \code{.java}
       * \endcode
       * @version
       * @see IPrinter
       */
  public com.vfi.smartpos.deviceservice.aidl.IPrinter getPrinter() throws android.os.RemoteException;
}
