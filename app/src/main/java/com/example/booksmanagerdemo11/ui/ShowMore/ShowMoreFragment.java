package com.example.booksmanagerdemo11.ui.ShowMore;

<<<<<<< HEAD
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
=======
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.booksmanagerdemo11.R;
<<<<<<< HEAD
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
        View view = inflater.inflate(R.layout.fragment_show_more, container, false);
        // 获取ListView控件
        ListView lv_ps = view.findViewById(R.id.lv_show_more);
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
        return view;
=======

public class ShowMoreFragment extends Fragment {

    private ShowMoreViewModel showMoreViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        showMoreViewModel =
                new ViewModelProvider(this).get(ShowMoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        showMoreViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
    }
}