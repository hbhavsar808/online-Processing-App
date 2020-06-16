package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.utils.Modules;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {
    SQLiteDatabase myDatabase = null;
    SqlHelper obHelper = null;
    Context context = null;

    public Controller() {
    }

    String[] sugar = new String[5];

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertData(String Tablename, String insertvalues[], Context context1) {
        context = context1;
        ContentValues values = null;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                values = new ContentValues();
                if (Tablename.equals(DataBaseInfo.TABLENAME_User)) {
                    try {
                        values.put(DataBaseInfo.U_USERNAME, insertvalues[0]);
                        values.put(DataBaseInfo.U_PASSWORD, insertvalues[1]);
                        values.put(DataBaseInfo.U_SHOPCODE, insertvalues[2]);
                        Log.i("tag", "user data saved locally");
                    } catch (Exception e) {
                        Toast.makeText(context1, "Oops some thing went wrong : - " + e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.i("tag", "problem in the saving patient :" + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                } else if (Tablename.equals(DataBaseInfo.TABLENAME_shopcode)) {
                    try {
                        Log.i("tag", "in Diabeties if");
                        Modules modules = new Modules();
                        // Log.i("tag", "after module-->");
                        Log.i("tag", "time is direct module: - " + modules.gettime());
                        try {
                            values.put(DataBaseInfo.SC_NUMBER, insertvalues[0]);
                            values.put(DataBaseInfo.SC_NAME, insertvalues[1]);
                        } catch (Exception e) {
                            Log.i("tag", "problem in getting values from array : " + e.getMessage());
                        }
                        Log.i("tag", "after user");
                        Log.i("tag", "in diabeties value save ");
                    } catch (Exception e) {
                        Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                Log.i("tag", "after Tablename : *** " + Tablename);
                myDatabase = obHelper.getWritableDatabase();
                myDatabase.insert(Tablename, null, values);
                Toast.makeText(context, "Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertShopcodeData(Context context1) {
//    public void InsertData(String Tablename, String insertvalues[], String insertvaluesname[], Context context1) {
        context = context1;
        ContentValues values = null;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                values = new ContentValues();
                try {
                    Log.i("tag", "in Diabeties if");
                    Modules modules = new Modules();

                    String arraysavecode[] = new String[6];
                    String arraysavecodename[] = new String[6];
                    arraysavecode = new String[6];
                    arraysavecode[0] = "S06A";
                    arraysavecode[1] = "S018";
                    arraysavecode[2] = "S044";
                    arraysavecode[3] = "S016";

                    arraysavecodename = new String[6];
                    arraysavecodename[0] = "CUS";
                    arraysavecodename[1] = "AIR";
                    arraysavecodename[2] = "GLE";
                    arraysavecodename[3] = "BOT";
                    Log.i("tag", "time is direct module: - " + modules.gettime());
                    try {
                        for (int counter = 0; counter < arraysavecode.length; counter++) {
                            values.put(DataBaseInfo.SC_NUMBER, arraysavecode[counter]);
                            values.put(DataBaseInfo.SC_NAME, arraysavecodename[counter]);
                            Log.e("insert", "counter : " + counter);
                            myDatabase = obHelper.getWritableDatabase();
                            myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);
                        }


                    } catch (Exception e) {
                        Log.i("tag", "problem in getting values from array : " + e.getMessage());
                    }

                } catch (Exception e) {
                    Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                } finally {
                    //insertvalues = null;
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                // Log.i("tag", "after Tablename : *** " + Tablename);
               /* myDatabase = obHelper.getWritableDatabase();
//                myDatabase.insert(Tablename, null, values);
                myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);*/
                Toast.makeText(context, " SHOP CODE Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    public Cursor DisplayData(String Tablename) {
        Cursor cursor = null;
        return cursor;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getdate() {
        Log.i("tag", "in date1");
        GregorianCalendar now = new GregorianCalendar();
        Log.i("tag", "after ger");
        int year = now.get(Calendar.YEAR);
        Log.i("tag", "year");
        int month = now.get(Calendar.MONTH) + 1;
        Log.i("tag", "month");
        int day = now.get(Calendar.DATE);
        Log.i("tag", "date");
        String date = year + "-" + month + "-" + day;
//        Date = date;
        return date;
        // 2012-04-10%2010:22:40
    }

    //    @RequiresApi(api = Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    public String gettime() {
        GregorianCalendar now = new GregorianCalendar();
        int hour = now.get((Calendar.HOUR_OF_DAY) + 1);
        int minute = now.get((Calendar.MINUTE) + 1);
        int second = now.get((Calendar.SECOND) + 1);
        //        Date = date;
        String time = hour + ":" + minute + ":" + second;
        Log.i("tag", "direct time --------------------: " + time);
        return time;
        // 2012-04-10%2010:22:40
    }

    public Cursor getUserlist(Context context, String userid, String password) {
//    public int getUserlist(Context context, String userid, String password) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select username,password from " + DataBaseInfo.TABLENAME_User + " Where " + DataBaseInfo.U_USERNAME + "=" + userid + " and " + DataBaseInfo.U_PASSWORD + "=" + password, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(2);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }
//    return rec;
        return cur;
//        return count;
    }

    public String ShopcodeName(Context context, String shopcode) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        String sname = "";
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select " + DataBaseInfo.SC_NAME + " from " + DataBaseInfo.TABLENAME_shopcode + " Where " + DataBaseInfo.SC_NUMBER + "=" + shopcode, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            sname = cur.getString(0);

            Log.e("shopcode ", "shopcode : " + cur.getString(0));
            Log.e("count", "total row : " + cur.getCount());

        } catch (Exception e) {
        }
        return sname;
    }

    public void getshopcodelist(Context context,String snumber) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select shop_name from " + DataBaseInfo.TABLENAME_shopcode+" WHERE shopcode_number="+snumber, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                //rec[i] = cur.getString(2);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    //    public Cursor getflag(Context context,String serviceid,String sercatid) {
    public String[] getuser(Context context, String username, String password) {
        SQLiteDatabase myDatabase;
        String rec[] = new String[2];
        Cursor cur = null;
        String fullquery = "", flag = "";
        int count = 0;
        try {
//            fullquery = "SELECT " + DataBaseInfo.o_flag + " FROM " + DataBaseInfo.TABLENAME_OPEN_ORDER + " WHERE " + DataBaseInfo.o_serviceid + " = " + serviceid + " AND " + DataBaseInfo.o_subcategoryid + " = " + sercatid + " AND  " + DataBaseInfo.o_status + "=1";
            Log.i("select", "--------------------------------------------");
            fullquery = "SELECT " + DataBaseInfo.U_USERNAME+","+DataBaseInfo.U_PASSWORD + " from " + DataBaseInfo.TABLENAME_User+ " WHERE username = "+username+" AND password="+DataBaseInfo.U_PASSWORD;
            Log.i("select", "--------------------------------------------");
            Log.i("getflag()", "flag from db : " + fullquery);
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery(fullquery, null);
            cur.moveToFirst();
            count = cur.getCount();
            if (count >= 1) {
                Log.i("cur count ", "counter : " + cur.getCount());
                rec[0] = cur.getString(0);
                rec[1] = cur.getString(1);
                Log.i("getflag()", "flag from db : " + flag);
                flag = cur.getString(0);
                return rec;
            }


        } catch (Exception e) {
        }
        return rec;
//        return cur;
//        return flag;
    }
}
