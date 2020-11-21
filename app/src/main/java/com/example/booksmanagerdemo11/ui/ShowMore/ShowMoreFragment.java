package com.example.booksmanagerdemo11.ui.ShowMore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.ui.BookManager.BooksManageActivity;
import com.example.booksmanagerdemo11.ui.BookManager.LendManagerActivity;
import com.example.booksmanagerdemo11.ui.BookManager.ShowLendedBookActivity;
import com.example.booksmanagerdemo11.ui.login.LoginActivity;

public class ShowMoreFragment extends Fragment {
    private static final String TAG = "ShowMoreFragment";
    private String[] contents = {"图书管理", "借阅管理", "查询已借"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: 9191919");
        View view = inflater.inflate(R.layout.fragment_show_more, container, false);
        // 获取ListView控件
        ListView lv_ps = view.findViewById(R.id.lv_show_more);
        Log.e(TAG, "onCreateView: 51515");
        ListAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, contents);
        lv_ps.setAdapter(adapter);

        lv_ps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position)
                {
                    case 0:
                        intent.setClass(getActivity(), BooksManageActivity.class);
                        break;
                    case 1:
                        intent.setClass(getActivity(), LendManagerActivity.class);
                        break;
                    case 2:
                        intent.setClass(getActivity(), ShowLendedBookActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
        Log.e(TAG, "onCreateView: 12313123");
        return view;
    }
}