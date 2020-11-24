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
<<<<<<< HEAD
=======
import android.widget.TextView;
import android.widget.Toast;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD

import com.example.booksmanagerdemo11.MainActivity;
import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.domain.Data;
import com.example.booksmanagerdemo11.ui.login.LoginActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

=======
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.booksmanagerdemo11.MainActivity;
import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.ui.login.LoginActivity;

>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
/**
 * 个人中心页面
 */
public class PersonalCenterFragment extends Fragment {
    private static final String TAG = "PersonalCenterFragment";
<<<<<<< HEAD

    // TODO 这个数组可以从后端获取
    private final String[] personal_setting = {"姓名","id", "性别", "学院", "专业", "班级", "电话", "退出登录"};
    private final String[] message = new String[7];
=======
    private String[] personal_setting = {"登录","sdasdad"};
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_center, container, false);
<<<<<<< HEAD

        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> map = new HashMap<>();
                map.put("account", Data.getId());

                try {
                    // 获取表单对象
                    RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new JSONObject(map).toString());

                    // 获取http链接对象
                    OkHttpClient client = new OkHttpClient();

                    /*
                     * 请求对象
                     * 链接中，如果用 localhost 或 127.0.0.1 无法连接到 tomcat。
                     * 因为 localhost 或 127.0.0.1 指向的是 Android 模拟器，
                     * 所以连接电脑的本地 tomcat 需要用电脑的 ip 地址
                     */
                    Request request = new Request.Builder()
                            .url("http://192.168.1.130:8080/android_library_management_system_war_exploded/homepage") // 设置url
                            .post(body) // 设置传递参数
                            .build(); // 创建请求对象

                    // 获取响应对象，用于接收后端的响应
                    Response response = client.newCall(request).execute();

                    // 获取响应体中的返回值
                    String responseDate = null;
                    if (response.body() != null) {
                        responseDate = response.body().string();
                        JSONObject jsonObject = new JSONObject(responseDate);
                        message[0] = jsonObject.getString("stuName");
                        message[1] = jsonObject.getString("stuId");
                        message[2] = jsonObject.getString("gender");
                        message[3] = jsonObject.getString("college");
                        message[4] = jsonObject.getString("major");
                        message[5] = jsonObject.getString("clazz");
                        message[6] = jsonObject.getString("stuTelephone");
                    }

                    ListView messageView = view.findViewById(R.id.lv_personal_center2);

                    ListAdapter adapterMessage = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, message);
                    messageView.setAdapter(adapterMessage);
                } catch (Exception e) {
                    e.getCause();
                }
            }
        }).start();
        // 获取ListView控件
        ListView lv_ps = view.findViewById(R.id.lv_personal_center);

        ListAdapter adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, personal_setting);
=======
        // 获取ListView控件
        ListView lv_ps = view.findViewById(R.id.lv_personal_center);

        ListAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, personal_setting);
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
        lv_ps.setAdapter(adapter);

        lv_ps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Log.e(TAG, String.valueOf(position));
                switch (position)
                {
<<<<<<< HEAD
                    case 7:
                        // TODO 清除登录的账号信息

                        intent.setClass(getActivity(), LoginActivity.class);
                        break;
=======
                    case 0:
                        intent.setClass(getActivity(), LoginActivity.class);
                        break;
                    case 1:
                        break;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
<<<<<<< HEAD
=======




>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
        return view;
    }
}