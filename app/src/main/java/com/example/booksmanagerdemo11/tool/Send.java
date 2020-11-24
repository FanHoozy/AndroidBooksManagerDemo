package com.example.booksmanagerdemo11.tool;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Send {
    //get请求
    public String SendJson(String strUrl, String id){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FormBody.Builder params = new FormBody.Builder();

                    // 添加键值对
                    params.add("account", id);
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder()
                            .url(strUrl)
                            .post(params.build())
                            .build();
                    Response response=client.newCall(request).execute();
                   String sb=response.body().string();

                   // return response.body().string();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
       return null;
    }


















}
