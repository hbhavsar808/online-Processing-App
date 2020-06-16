package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.utils.PrrintBill;

import java.util.List;

public class AdapterNewOrder extends RecyclerView.Adapter<AdapterNewOrder.ViewHolder> {
    List<OrderModel.OrderHdr> data;
    Context mContext;

    ClickListner clickListner;
PrrintBill prrintBill=new PrrintBill();
String [] headerdetails=new String[6];
String [] itemdetails=new String[100];

    SharedPreferences sharedpreferences;
    String saveshopcode = "";

    public AdapterNewOrder(Context activity, List<OrderModel.OrderHdr> data, ClickListner clickListner1) {
        this.data = data;
        this.mContext = activity;
        clickListner = clickListner1;
    }

    public interface ClickListner {
        void onClick(List<OrderModel.OrderHdr> sheetname,int position);
    }

    @Override
    public AdapterNewOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_new_order, parent, false);
        final AdapterNewOrder.ViewHolder mViewHolder = new AdapterNewOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterNewOrder.ViewHolder holder, final int position) {

        holder.txtcustomername.setText(data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName());
        holder.txt_booking_date.setText(data.get(position).getOrderTime());
        holder.txt_booking_id.setText("OrderId : " + data.get(position).getOrderId());
        holder.txt_total.setText("Total : " + data.get(position).getOrderPayments().get(0).getPaidAmount());

        headerdetails[0]=data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName();
        headerdetails[1]=data.get(position).getOrderTime();
        headerdetails[2]= data.get(position).getOrderId();
        headerdetails[3]="Total : " + data.get(position).getOrderPayments().get(0).getPaidAmount();

        holder.recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 1);
        holder.recyclerView.setLayoutManager(mLayoutManager);

        AdapterNewSubOrder adapter = new AdapterNewSubOrder(mContext, data.get(position).getOrderDtls());
        holder.recyclerView.setAdapter(adapter);
        adapter.getitemlist();
        holder.rl_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onClick(data,position);
            }
        });


        holder.rl_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    prrintBill.printData(headerdetails, itemdetails);
                }catch ( Exception e){
                    Log.i("tag","problem in the print option : "+e.getMessage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtcustomername;
        public TextView txt_booking_date;
        public TextView txt_booking_id;
        public TextView txt_total;

        RecyclerView recyclerView;

        RelativeLayout rl_detail;
        RelativeLayout rl_print;

        ViewHolder(View v) {
            super(v);
            txt_booking_id = v.findViewById(R.id.txt_booking_id);
            txt_booking_date = v.findViewById(R.id.txt_booking_date);
            txtcustomername = v.findViewById(R.id.txtcustomername);
            txt_total = v.findViewById(R.id.txt_total);
            recyclerView = v.findViewById(R.id.recycler_view);
            rl_detail = v.findViewById(R.id.rl_detail);
            rl_print = v.findViewById(R.id.rl_print);
        }
    }
}