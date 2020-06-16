package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.OrderModel;

import java.util.List;

public class AdapterOngoingSubOrder extends RecyclerView.Adapter<AdapterOngoingSubOrder.ViewHolder> {
    List<OrderModel.OrderHdr.OrderDtl> data;
    Context mContext;

    public AdapterOngoingSubOrder(Context activity, List<OrderModel.OrderHdr.OrderDtl> data) {
        this.data = data;
        this.mContext = activity;
    }

    @Override
    public AdapterOngoingSubOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_sub_ongoing_order, parent, false);
        final AdapterOngoingSubOrder.ViewHolder mViewHolder = new AdapterOngoingSubOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterOngoingSubOrder.ViewHolder holder, final int position) {
        holder.txtname.setText(data.get(position).getName());
        holder.txtqty.setText("Qty : " + data.get(position).getQty());
        holder.txtprice.setText("$ " + data.get(position).getTax1Amount());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtname;
        public TextView txtqty;
        public TextView txtprice;

        ViewHolder(View v) {
            super(v);
            txtname = v.findViewById(R.id.txtname);
            txtqty = v.findViewById(R.id.txtqty);
            txtprice = v.findViewById(R.id.txtprice);
        }
    }
}