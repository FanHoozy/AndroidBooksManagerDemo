package com.example.booksmanagerdemo11.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.adapter.BooksAdapter;
import com.example.booksmanagerdemo11.domain.Book;
import com.example.booksmanagerdemo11.service.NetworkService;

import org.json.JSONArray;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @TODO
 * 看fragment_home里的瀑布流的rcl_item_books放了哪些text
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private Handler handler;
    private BooksAdapter booksAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        EditText etSearchBook = view.findViewById(R.id.et_search_name);
        etSearchBook.setHint("请输入需要查询的书名");

        // TODO 解析json对象的类

        ImageButton ibSearch = view.findViewById(R.id.ib_search);
        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SearchBook = etSearchBook.getText().toString().trim();
                // 添加地址
                String urlStr = "8080/android_library_management_system_war_exploded/searchBook";


                new Thread(){
                    @Override
                    public void run() {
                        try {
                        OkHttpClient client = new OkHttpClient();
                        RequestBody requestBody = new FormBody.Builder()
                                .add("bookName",SearchBook)
                                .build();

                        Request request = new Request.Builder()
                                .url(urlStr)
                                .post(requestBody)
                                .build();
                            Response response = client.newCall(request).execute();


                            String responseData = response.body().string();
                            // 解析json，并封装对象
                            List<Book> bookList =new HomeViewModel().parseJsonStringToBookObject(responseData);
                            // 回主线程设置数据，刷新页面
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 在主线程运行
                                    booksAdapter.setBookList(bookList);

                                }
                            });



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

                // 显示数据,主线程
                initView();

            }
        });

        return  view;
    }

    private void initView() {
        RecyclerView rclContent = getView().findViewById(R.id.rcl_content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rclContent.setLayoutManager(linearLayoutManager);

        // 适配器
        booksAdapter = new BooksAdapter(R.layout.rcl_item_books);
        // 设置适配器
        rclContent.setAdapter(booksAdapter);

    }

}