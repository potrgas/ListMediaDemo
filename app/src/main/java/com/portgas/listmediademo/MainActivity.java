package com.portgas.listmediademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<Entity> {

    private RecyclerView recyclerView;
    private VideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        adapter = new VideoAdapter(this, new ArrayList<Entity.ItemsEntity>());

        recyclerView.setAdapter(adapter);

        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpUtils.Service service = build.create(HttpUtils.Service.class);


        Call<Entity> call = service.getVideo(1);
        call.enqueue(this);


    }

    @Override
    public void onResponse(Response<Entity> response, Retrofit retrofit) {
        List<Entity.ItemsEntity> items = response.body().getItems();
        if (items != null)
            adapter.addAll(items);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }
}
