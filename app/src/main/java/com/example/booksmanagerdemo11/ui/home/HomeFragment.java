package com.example.booksmanagerdemo11.ui.home;

import android.os.Bundle;
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
import com.example.booksmanagerdemo11.service.NetworkService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @TODO
 * 看fragment_home里的瀑布流的rcl_item_books放了哪些text
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

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
                String book = etSearchBook.getText().toString().trim();
                if (book.isEmpty()) {
                    Toast.makeText(getContext(), "请输入书本的名字", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    book = URLEncoder.encode(book, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                // TODO 添加地址
                String urlStr = "" + book;
                new Thread(){
                    @Override
                    public void run() {
                        // 获取json字符串
                        String jsonString = NetworkService.getJsonString(urlStr);
                        Log.e(TAG, "run: " + jsonString );
                        // TODO 解析json，并封装对象 还需要创建一个对象
//                        final List<Music> musicList = music.parseJsonStringToMusicObject(jsonString);
//                        Log.e(TAG, "run: musicList" + musicList);
//                        // 回主线程设置数据，刷新页面
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                // 这里在主线程中运行
//                                musicAdapter.setMusicList(musicList);
//                            }
//                        });



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

        // 设置适配器

    }

}