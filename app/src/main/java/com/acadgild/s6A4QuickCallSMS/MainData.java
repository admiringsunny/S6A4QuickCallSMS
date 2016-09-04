package com.acadgild.s6A4QuickCallSMS;

/**
 * Created by sunny on 9/3/16.
 */
public class MainData {

    static String[] names = {"AMAR SINGH", "AKHBAR ALI", "ANTHONY GUNSALVIS", "SEETA", "GEETA", "REETA", "CHULBUL PANDEY"};
    static String[] phoneNumbers = {"9900199001", "9900199002", "9900199003", "9900199004", "9900199005", "9900199006", "9900199007"};

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        MainData.names = names;
    }

    public static String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public static void setPhoneNumbers(String[] phoneNumbers) {
        MainData.phoneNumbers = phoneNumbers;
    }
}
