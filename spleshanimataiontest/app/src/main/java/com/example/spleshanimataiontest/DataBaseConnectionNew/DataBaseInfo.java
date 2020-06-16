package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.content.Context;

/**
 * Created by admin on 11/7/2016.
 */

public class DataBaseInfo {

    //add new database name
    public static String DataBaseName = "foodorder.db";

    // Table Names
    public static String TABLENAME_shopcode = "shopcodemaster";
    public static String TABLENAME_User = "usernaster";


    // Fields of NewRegistration arraysavelist[0] = userfullname.getText().toString().trim();
    public static String U_ID = "_id";
    public static String U_USERNAME = "username";
    public static String U_PASSWORD = "password";
    public static String U_SHOPCODE = "shopcode";


    //Field of Shopcode
    public static String SC_ID = "_id";
    public static String SC_NUMBER = "shopcode_number";
    public static String SC_NAME = "shop_name";


    public DataBaseInfo(Context baseContext, String tablename_notifactionmaster, Object o, int i) {
    }


}
