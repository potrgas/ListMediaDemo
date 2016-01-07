package com.portgas.listmediademo;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Administrator on 2016/1/7 0007.
 */
public class HttpUtils {
    public interface Service {

        @GET("/article/list/video")
        public Call<Entity> getVideo(@Query("page") int page);
    }
}
