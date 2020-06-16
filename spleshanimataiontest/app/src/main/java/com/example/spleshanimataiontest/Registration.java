package com.example.spleshanimataiontest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;

public class Registration extends Activity implements View.OnClickListener {
    String arraysavelist[];
    String arraysavecode[];
    String arraysavecodename[];
    String shopcodetxt = "";
    Button register;
    TextView login_now, shopcode;
    EditText userid, password, passwordconf;//, shopcode;
    SharedPreferences sharedpreferences;
    public static final String SAVEDSHOPCODE = "shopcode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        register = findViewById(R.id.register);
        //  login_now = findViewById(R.id.login_now);
        userid = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        passwordconf = findViewById(R.id.txtpasswordconfirm);
        //shopcode = findViewById(R.id.txtshopcode);

        register.setOnClickListener(this);
//        login_now.setOnClickListener(this);
        sharedpreferences = getSharedPreferences(SAVEDSHOPCODE, Context.MODE_PRIVATE);
        shopcode = (TextView) findViewById(R.id.txtregistershopcode);
        shopcodetxt = getIntent().getStringExtra("shopcode");
        setTitle(shopcodetxt);
        shopcode.setText(shopcodetxt);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
          /*  case R.id.login_now:
                finish();
                break;*/
            case R.id.register:
                if (TextUtils.isEmpty(userid.getText().toString())) {
                    Toast.makeText(this, "plz enter valid userid", Toast.LENGTH_SHORT).show();
                    userid.setFocusable(true);
                } else {
                    if (checkvalidation()) {
                        try {
                            arraysavelist = new String[4];
                            arraysavelist[0] = userid.getText().toString().trim();
                            arraysavelist[1] = password.getText().toString().trim();
                            //  arraysavelist[2] = shopcode.getText().toString().trim();
                            arraysavelist[2] = "";
                            Controller controller = new Controller();
                            controller.InsertData(DataBaseInfo.TABLENAME_User, arraysavelist, getApplication()); // to save data in database

                          /*  arraysavecode = new String[4];
                            arraysavecode[0] = "S06A";
                            arraysavecode[1] = "S018";
                            arraysavecode[2] = "S044";
                            arraysavecode[3] = "S016";

                            arraysavecodename = new String[4];
                            arraysavecodename[0] = "CUS";
                            arraysavecodename[1] = "AIR";
                            arraysavecodename[2] = "GLE";
                            arraysavecodename[3] = "BOT";
                            //  Controller controller = new Controller();
                            controller.InsertData(DataBaseInfo.TABLENAME_shopcode, arraysavecode, arraysavecodename, getApplication()); // to save data in database
*/

                            SharedPreferences.Editor editor = sharedpreferences.edit(); // to save  data locally
                            editor.putString("shopcode", arraysavelist[2]);
                            editor.commit();

                            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Registration.this, NavigationActivity.class));
                        } catch (Exception e) {
                            Log.e("tag", "Problem in Registration  :" + e.getMessage());
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public Boolean checkvalidation() {

        if (TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(passwordconf.getText().toString())) {
            Toast.makeText(Registration.this, "Enter passeword", Toast.LENGTH_LONG).show();
        } else {
            if (password.getText().toString().trim().equals(passwordconf.getText().toString().trim())) {
                return true;
            } else {
                Toast.makeText(Registration.this, "Password does not match", Toast.LENGTH_LONG).show();
            }
            return false;
        }
        return false;
    }


}
