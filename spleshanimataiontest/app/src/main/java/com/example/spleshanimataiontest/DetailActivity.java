package com.example.spleshanimataiontest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.adapter.AdapterDetail;
import com.example.spleshanimataiontest.datamodel.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    String order;
    int position;
    List<OrderModel.OrderHdr> myList;

    TextView txtcustomername;
    TextView txt_booking_date;
    TextView txt_booking_id;

    TextView txt_call;
    TextView txt_email;
    TextView txt_location;

    TextView txt_subtotal;
    TextView txt_delivery_fee;
    TextView txt_service_tax;
    TextView txt_discount;
    TextView txt_grand_total;

    RelativeLayout rl_call;
    RelativeLayout rl_email;
    RelativeLayout rl_location;
    RelativeLayout rl_print;

    RecyclerView recycler_view;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myList = (ArrayList<OrderModel.OrderHdr>) getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position",0);
        order = getIntent().getStringExtra("order");

        if (order.matches("new")) {
            setTitle("New Order");
        } else if (order.matches("ongoing")) {
            setTitle("Ongoing Order");
        } else if (order.matches("complete")) {
            setTitle("Completed Order");
        }

        txt_subtotal = findViewById(R.id.txt_subtotal);
        txt_delivery_fee = findViewById(R.id.txt_delivery_fee);
        txt_service_tax = findViewById(R.id.txt_service_tax);
        txt_discount = findViewById(R.id.txt_discount);
        txt_grand_total = findViewById(R.id.txt_grand_total);

        rl_call = findViewById(R.id.rl_call);
        rl_email = findViewById(R.id.rl_email);
        rl_location = findViewById(R.id.rl_location);
        rl_print = findViewById(R.id.rl_print);

        txtcustomername = findViewById(R.id.txtcustomername);
        txt_booking_date = findViewById(R.id.txt_booking_date);
        txt_booking_id = findViewById(R.id.txt_booking_id);

        txt_call = findViewById(R.id.txt_call);
        txt_email = findViewById(R.id.txt_email);
        txt_location = findViewById(R.id.txt_location);

        recycler_view = findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 1);
        recycler_view.setLayoutManager(mLayoutManager);

        AdapterDetail adapter = new AdapterDetail(context, myList.get(position).getOrderDtls());
        recycler_view.setAdapter(adapter);

        txtcustomername.setText(myList.get(position).getOrderCustomer().getFirstName() + " " + myList.get(position).getOrderCustomer().getLastName());
        txt_booking_date.setText(myList.get(position).getOrderTime());
        txt_booking_id.setText("OrderId : " + myList.get(position).getOrderId());

        txt_call.setText(myList.get(position).getOrderCustomer().getPhoneNumber());
        txt_email.setText(myList.get(position).getOrderCustomer().getEmail());
        txt_location.setText(myList.get(position).getOrderCustomer().getAddress());

        txt_subtotal.setText("Subtotal : " + myList.get(position).getDetailTotal());
        txt_delivery_fee.setText("Delivery Fee : " + myList.get(position).getTotalPrintCount());
        txt_service_tax.setText("+ Service tax (20%) : " + myList.get(position).getBillLessTaxAmount());
        txt_discount.setText("+ Discount (20%) : " + myList.get(position).getBillDiscountAmount());
        txt_grand_total.setText("Total : " + myList.get(position).getOrderPayments().get(0).getPaidAmount());

        rl_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+myList.get(position).getOrderCustomer().getPhoneNumber()));
                startActivity(intent);
            }
        });
        rl_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try {
    Intent intent=new Intent(Intent.ACTION_SEND);
    String[] recipients={myList.get(position).getOrderCustomer().getEmail()};
    intent.putExtra(Intent.EXTRA_EMAIL, recipients);
    intent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
    intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
    //intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
    intent.setType("text/html");
    intent.setPackage("com.google.android.gm");
    startActivity(Intent.createChooser(intent, "Send mail"));
}catch (Exception e){

}
            }
        });
        rl_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rl_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}