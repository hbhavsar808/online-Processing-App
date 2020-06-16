package com.example.spleshanimataiontest.interfaces;

import com.example.spleshanimataiontest.datamodel.OrderModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("get_online_orders.php?synchronize={\"shop_code\":\"S044\",\"updated_at\":\"2019-12-05\"}")
    Call<OrderModel> getOrder();

}