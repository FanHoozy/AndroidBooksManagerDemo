package com.example.booksmanagerdemo11.ui.BookManager;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.adapter.BooksAdapter;
import com.example.booksmanagerdemo11.domain.Borrows;
import com.example.booksmanagerdemo11.domain.Data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @TODO 借阅管理界面制作
 * 已经有一个瀑布流在其中和借阅查询是相同的方法，会其一就好，
 * 应该就展示的东西不一样，到时候根据情况是否新建rcl_item_~~~~
 */
public class LendManagerActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_manager);
        RecyclerView recyclerView = findViewById(R.id.rcl_lend_manage);


        // TODO 在创建时直接新建线程获取并展示

        //回传id
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Map<String, String> map = new HashMap<>();
                    map.put("stuId", Data.getId());

                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new JSONObject(map).toString());
                    Request request = new Request.Builder()
                            .url("http://192.168.1.130:8080/android_library_management_system_war_exploded/searchBorrows?stuId="+Data.getId()) // 设置url
                            .post(body)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseDate;
                    if (response.body() != null) {
                        responseDate = response.body().string();
                        parseJSONWithJSONObject(responseDate);
                    }else {
                        Toast.makeText(LendManagerActivity.this, "获取失败", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();


    }
    private void  parseJSONWithJSONObject(String jsonData){
        try {
            List<Borrows> list = new ArrayList<>();
            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Borrows borrows = new Borrows();
                borrows.setBorrowsBookId(jsonObject.getString("borrowsBookId"));
                borrows.setBorrowsBookName(jsonObject.getString("borrowsBookName"));
                borrows.setBorrowsStuId(jsonObject.getString("borrowsStuId"));
                borrows.setBorrowsTime(jsonObject.getString("borrowsTime"));
                list.add(borrows);
            }
            new BooksAdapter(list);
        }catch (Exception e){
            e.printStackTrace();
        }
=======

import android.os.Bundle;

import com.example.booksmanagerdemo11.R;

/**
 * @TODO 借阅管理界面制作
 */
public class LendManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_manager);
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
    }
}