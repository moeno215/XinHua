package com.example.maulana.xinhua.Network;

import com.example.maulana.xinhua.Modul.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("v2/top-headlines?sources=xinhua-net&apiKey=197af1a8301744ed9cfcfb669c464fd4")
    Call<ResponseNews> getNews();
}