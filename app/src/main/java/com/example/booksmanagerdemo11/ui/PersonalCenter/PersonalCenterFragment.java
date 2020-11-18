package com.example.booksmanagerdemo11.ui.PersonalCenter;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.booksmanagerdemo11.MainActivity;
import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.ui.login.LoginActivity;

/**
 * 个人中心页面
 */
public class PersonalCenterFragment extends Fragment {
    private static final String TAG = "PersonalCenterFragment";
    private String[] personal_setting = {"登录","sdasdad"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_center, container, false);
        // 获取ListView控件
        ListView lv_ps = view.findViewById(R.id.lv_personal_center);

        ListAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, personal_setting);
        lv_ps.setAdapter(adapter);

        lv_ps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Log.e(TAG, String.valueOf(position));
                switch (position)
                {
                    case 0:
                        intent.setClass(getActivity(), LoginActivity.class);
                        break;
                    case 1:
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });




        return view;
    }
}