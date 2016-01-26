package com.jay.tracker.BackgroundService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.jay.tracker.Model.TelephonyModel;

import java.util.List;

/**
 * Created by Jay on 25-01-2016.
 */
public class TelephonyService extends Service {

    TelephonyManager telephonyManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate() called",Toast.LENGTH_SHORT).show();
        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"onStartCommand() called",Toast.LENGTH_SHORT).show();
        //TelephonyModel.isSupportsDTMFTone = telephonyManager.canChangeDtmfToneLength();
        //List<CellInfo> cellInfoList = telephonyManager.getAllCellInfo();
        TelephonyModel.callState = telephonyManager.getCallState();
        TelephonyModel.cellLocation = telephonyManager.getCellLocation();
        TelephonyModel.getDataActivity = telephonyManager.getDataActivity();
        TelephonyModel.getDataState = telephonyManager.getDataState();
        TelephonyModel.getDeviceId = telephonyManager.getDeviceId();
        TelephonyModel.getDeviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
        //String getGroupdIdLevel1 = telephonyManager.getGroupIdLevel1();
        TelephonyModel.getLine1Number = telephonyManager.getLine1Number();
        //String getMmsUAProfUrl = telephonyManager.getMmsUAProfUrl();
        //String getMmsUserAgent = telephonyManager.getMmsUserAgent();
        TelephonyModel.neighboringCellInfoList = telephonyManager.getNeighboringCellInfo();
        TelephonyModel.getNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        TelephonyModel.getNetworkOperator = telephonyManager.getNetworkOperator();
        TelephonyModel.getNetworkOperatorName = telephonyManager.getNetworkOperatorName();
        TelephonyModel.getNetworkType = telephonyManager.getNetworkType();
        //int getPhoneCount = telephonyManager.getPhoneCount();
        TelephonyModel.getPhoneType = telephonyManager.getPhoneType();
        TelephonyModel.getSimCountryIso = telephonyManager.getSimCountryIso();
        TelephonyModel.getSimOperator = telephonyManager.getSimOperator();
        TelephonyModel.getSimOperatorName = telephonyManager.getSimOperatorName();
        TelephonyModel.getSimSerialNumber = telephonyManager.getSimSerialNumber();
        TelephonyModel.getSimState = telephonyManager.getSimState();
        TelephonyModel.getSubscriberId = telephonyManager.getSubscriberId();
        TelephonyModel.getVoiceMailAlphaTag = telephonyManager.getVoiceMailAlphaTag();
        TelephonyModel.getVoiceMailNumber = telephonyManager.getVoiceMailNumber();
        //boolean hasCarrierPrivileges = telephonyManager.hasCarrierPrivileges();
        TelephonyModel.hasIccCard = telephonyManager.hasIccCard();
        //boolean isHearingAidCompatibilitySupported = telephonyManager.isHearingAidCompatibilitySupported();
        TelephonyModel.isNetworkRoaming = telephonyManager.isNetworkRoaming();
        //boolean isSmsCapable = telephonyManager.isSmsCapable();
        //boolean isTtyModeSupported = telephonyManager.isTtyModeSupported();
        //boolean isVoiceCapable = telephonyManager.isVoiceCapable();
        //boolean isWorldPhone = telephonyManager.isWorldPhone();
        //boolean setPreferredNetworkTypeToGlobal = telephonyManager.setPreferredNetworkTypeToGlobal();
        Toast.makeText(this,"Cell Location : "+TelephonyModel.cellLocation.toString()+"\nDevice ID : "+TelephonyModel.getDeviceId,Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
