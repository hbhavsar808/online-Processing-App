package com.example.spleshanimataiontest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import androidx.appcompat.app.AppCompatActivity;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;

//import android.support.v7.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {


    //    boolean flag = true;
    TextView register_now, forgot_pass, shopcode;
    Button login;
    HomeActivity homeActivity;
    EditText userid, password, passwordconf;//, shopcode;
    String saveuserid = "", savepassword = "", shopcodetxt = "", shopname = "";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//setTitle();
        register_now = findViewById(R.id.register_now);
        forgot_pass = findViewById(R.id.forgot_pass);
        login = findViewById(R.id.login_proceed);


        register_now.setOnClickListener(this);
        forgot_pass.setOnClickListener(this);
        login.setOnClickListener(this);
        userid = findViewById(R.id.txtuserid);
        password = findViewById(R.id.txtpassword);
        shopcode = (TextView) findViewById(R.id.txtshopcode);
        shopcodetxt = getIntent().getStringExtra("shopcode");
        Log.e("***************", "shop code : " + shopcodetxt);
        if (shopcodetxt.equals("S063A")) {
            setTitle("CUS");
            shopname="CUS";
        } else if (shopcodetxt.equals("S018")) {
            setTitle("AIR");
            shopname="AIR";
        } else if (shopcodetxt.equals("S044")) {
            setTitle("GLE");
            shopname="GLE";
        } else if (shopcodetxt.equals("S016")) {
            setTitle("BOT");
            shopname="BOT";
        }

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("shopname",shopname);
        editor.commit();
        // shopcode.setText(shopcodetxt);
        /*Controller controller = new Controller();                                 // to  get shopname user this 2 line
        controller.getshopcodelist(Login.this,shopcodetxt);*/
//        shopname = controller.ShopcodeName(Login.this, shopcodetxt);

//        setTitle(shopname);
//        shopcode.setText(shopname);
//        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    public void proceed(View view) {
        Toast.makeText(this, "Proceed Clicked", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_now:

                Intent registerInter = new Intent(this, Registration.class);
                registerInter.putExtra("shopcode", shopname.toString());
                startActivity(registerInter);
                //   startActivity(new Intent(this, Registration.class));
                break;
            case R.id.forgot_pass:
                Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_proceed:

//                homeActivity = new HomeActivity();
/*
                adapter = new ViewPagerAdapter(getSupportFragmentManager());
                HomeFragment homeFragment = new HomeFragment();
                adapter.addFragment(homeFragment, "New order");
*/
                if (checkvalidation()) {
                    Intent navInter = new Intent(this, NavigationActivity.class);
                    navInter.putExtra("shopcode", shopname.toString());
                    startActivity(navInter);
                }
//                Toast.makeText(this, "order list ", Toast.LENGTH_LONG).show();

            default:
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean checkvalidation() {
        String txtuserid = "", txtpassword = "";
        if (TextUtils.isEmpty(userid.getText().toString())) {
            Toast.makeText(Login.this, "Enter User id", Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(Login.this, "Enter  Password", Toast.LENGTH_LONG).show();
            } else {
                Cursor cursor = null;
                Controller controller = new Controller();
               /* int count= controller.getUserlist(Login.this,userid.getText().toString().trim(),password.getText().toString().trim());
                if (count==1){
                    return true;
                }else{
                    return false;
                }*/

                String details[] = new String[4];
                txtuserid = userid.getText().toString().trim();
                txtpassword = password.getText().toString().trim();
                details = controller.getuser(Login.this, txtuserid, txtpassword);
                if (details.length >= 1) {
                    return true;
                } else {
                    return false;
                }

                /////////
              /* cursor = controller.getUserlist(Login.this,userid.getText().toString().trim(),password.getText().toString().trim());
                saveuserid = cursor.getString(0);
                savepassword = cursor.getString(1);
//                Log.e("userid ","text userid : "+);
//                Log.e("password ","text password: "+);
                txtuserid=userid.getText().toString().trim();
                txtpassword=password.getText().toString().trim();
                if (saveuserid.equals(txtuserid)) {
                    if (savepassword.equals(txtpassword)) {
                        Log.e("userid ","userid : "+saveuserid);
                        Log.e("password ","password: "+savepassword);
                        return true;
                    } else {
                        Toast.makeText(Login.this, "Invalide user id  password",Toast.LENGTH_LONG).show();
                       // return false;
                    }
                }else{
                    Toast.makeText(Login.this,"Invalide user id password",Toast.LENGTH_LONG).show();
                }*/
            }
        }
        return false;
    }
}
