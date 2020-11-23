package com.example.booksmanagerdemo11.ui.BookManager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @TODO 借阅查询页面
 * 已经有一个瀑布流在其中和借阅管理是相同的方法，会其一就好，
 * 应该就展示的东西不一样，到时候根据情况是否新建rcl_item_~~~~
 */
public class ShowLendedBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lended_book);

        // TODO 用来解析json的对象


        // TODO 在创建时直接新建线程获取并展示
//        final String urlStr = "https://api.douban.com/v2/music/search?count=20&q=";
//
//        // 开启子线程
//        new Thread(){
//            @Override
//            public void run() {
//
//            }
//        }.start();





    }

}