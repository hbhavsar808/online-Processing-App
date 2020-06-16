package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
//    public SqlHelper(Context context ) {
//        //super(context, name, null, version);
//    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase CallDataBase) {

        String sqlStringUser;
        sqlStringUser = " Create Table " + DataBaseInfo.TABLENAME_User;
        sqlStringUser += " ( " + com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_ID + " Integer Primary Key Autoincrement,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_USERNAME + " Text,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_PASSWORD + " Text,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_SHOPCODE + " Text)";
        CallDataBase.execSQL(sqlStringUser);

        String sqlStringShopcode;
        sqlStringShopcode = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_shopcode;
        sqlStringShopcode += " ( " + DataBaseInfo.SC_ID + " Integer Primary Key Autoincrement,";
        sqlStringShopcode += DataBaseInfo.SC_NUMBER + " Text,";
        sqlStringShopcode += DataBaseInfo.SC_NAME + " Text)";
        CallDataBase.execSQL(sqlStringShopcode);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
