package com.example.maulana.xinhua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.maulana.xinhua.Adapter.MyAdapter;
import com.example.maulana.xinhua.Modul.ArticlesItem;
import com.example.maulana.xinhua.Modul.ResponseNews;
import com.example.maulana.xinhua.Network.ApiClient;
import com.example.maulana.xinhua.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView Recy;
    MyAdapter adapter;
    ApiInterface mApiInterface = ApiClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recy = findViewById(R.id.recy);
        getData();
    }

    private void getData() {
        Call<ResponseNews> petugasCall = mApiInterface.getNews();
        petugasCall.enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                String status = response.body().getStatus();
                if (status.equals("ok")) {
                    Recy.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    List<ArticlesItem> petugasList = response.body().getArticles();
                    Log.d("Retrofit Get", "Jumlah Pegawai Pemadam Kebakaran: " + String.valueOf(petugasList.size()));
                    adapter = new MyAdapter(petugasList, MainActivity.this);
                    Recy.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }
}
