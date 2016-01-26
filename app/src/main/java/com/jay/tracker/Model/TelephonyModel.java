package com.jay.tracker.Model;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;

import java.util.List;

/**
 * Created by Jay on 25-01-2016.
 */
public class TelephonyModel {
    public static boolean isSupportsDTMFTone;
    public static List<CellInfo> cellInfoList;
    public static int callState;
    public static CellLocation cellLocation;
    public static int getDataActivity;
    public static int getDataState;
    public static String getDeviceId;
    public static String getDeviceSoftwareVersion;
    public static String getGroupdIdLevel1;
    public static String getLine1Number;
    public static String getMmsUAProfUrl;
    public static String getMmsUserAgent;
    public static List<NeighboringCellInfo> neighboringCellInfoList;
    public static String getNetworkCountryIso;
    public static String getNetworkOperator;
    public static String getNetworkOperatorName;
    public static int getNetworkType;
    public static int getPhoneCount;
    public static int getPhoneType;
    public static String getSimCountryIso;
    public static String getSimOperator;
    public static String getSimOperatorName;
    public static String getSimSerialNumber;
    public static int getSimState;
    public static String getSubscriberId;
    public static String getVoiceMailAlphaTag;
    public static String getVoiceMailNumber;
    public static boolean hasCarrierPrivileges;
    public static boolean hasIccCard;
    public static boolean isHearingAidCompatibilitySupported;
    public static boolean isNetworkRoaming;
    public static boolean isSmsCapable;
    public static boolean isTtyModeSupported;
    public static boolean isVoiceCapable;
    public static boolean isWorldPhone;
    public static boolean setPreferredNetworkTypeToGlobal;
}
