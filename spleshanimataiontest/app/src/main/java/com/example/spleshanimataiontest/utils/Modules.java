package com.example.spleshanimataiontest.utils;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.DataBaseConnectionNew.SqlHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Modules {

    static String[] entrydate = null;

    public String getdateandtime() {
        GregorianCalendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        String date = year + "-" + month + "-" + day;
        String time = " " + hour + ":" + minute + ":" + second;
        return date + time;
    }

    public String getdate() {

        GregorianCalendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);

        String date = year + "-" + month + "-" + day;

        return date;
    }

    public String gettime() {
        GregorianCalendar now = new GregorianCalendar();
        int hour = now.get((Calendar.HOUR));
//        int hour = now.get((Calendar.HOUR_OF_DAY));
        int minute = now.get((Calendar.MINUTE));
        int second = now.get(Calendar.SECOND);
        String time = " " + hour + ":" + minute + ":" + second;
//Log.i("tag","date from module//////////////*/******** : "+time);
        return time;
    }


    //    public Cursor getPatientlist(Context context) {
    public String[] getUserlist(Context context) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.query(DataBaseInfo.TABLENAME_User, null, null, null, null, null, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(1);
                // Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + " : " + cur.getString(4));
                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }
        return rec;
//        return cur;
    }


    public String[] getPatientArrayList(Context context) {
//    public String getPatientArrayList(Context context) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.query(DataBaseInfo.TABLENAME_shopcode, null, null, null, null, null, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(1);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3));
                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.U_SHOPCODE);
            }
        } catch (Exception e) {
        }
//        return rec[0].toString().trim();
        return rec;

    }

    //    public String getShopcode(Context context) {
    public Cursor getShopcode(Context context) {

        SQLiteDatabase myDatabase;
        String rec = "";
        Cursor cur = null;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.query(DataBaseInfo.TABLENAME_shopcode, null, null, null, null, null, null);
            cur.moveToFirst();
            Log.i("tag", "before calling queary");
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
//                rec[i] = cur.getString(2);

                Log.e("tag", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + cur.getString(4) + " : " + cur.getString(5) + " : " + cur.getString(6) + " : " + cur.getString(7));
                cur.moveToNext();
//                Log.i("tag ", "field name : " + DataBaseInfo.P_NAME);
            }
        } catch (Exception e) {
            Log.e("module","problem in cursor : "+e.getMessage());
        }
//        return rec[0].toString().trim();
//        return rec;
        return cur;
    }


    private FragmentManager supportFragmentManager;
    private DatePickerDialog.OnDateSetListener mDateSetListener = null;
    String dt = "";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String showDatePicker(Context context) {
//         DatePickerDialog.OnDateSetListener mDateSetListener=null;
        final String[] selectDate = {""};
//        String dt="";
        try {
            Log.i("tag", "in funtion date picker");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(context, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();


            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month = month + 1;
                    Log.d("tag", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                    String date = month + "/" + day + "/" + year;
//                    mDisplayDate.setText(date);

                    selectDate[0] = date.toString().trim();
                }
            };
        } catch (Exception e) {
            Log.i("tag", "error :  - " + e.getMessage());

        }
        return selectDate[0];

    }


}