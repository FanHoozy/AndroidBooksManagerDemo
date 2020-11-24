package com.example.booksmanagerdemo11.ui.login;

<<<<<<< HEAD
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
=======
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booksmanagerdemo11.MainActivity;
import com.example.booksmanagerdemo11.R;
<<<<<<< HEAD
import com.example.booksmanagerdemo11.domain.Data;

import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
=======
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72

/**
 *  登录页面
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "SeventhActivity";
    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_login_permission;
<<<<<<< HEAD
    private CheckBox cb_remember;
    private SharedPreferences perf;
    private SharedPreferences.Editor editor;
=======

>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD
        perf= PreferenceManager.getDefaultSharedPreferences(this);

        // 获取EditText
        cb_remember=findViewById(R.id.cb_remember);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_login_permission = (CheckBox) findViewById(R.id.cb_login_permission);


        boolean isRemember=perf.getBoolean("remember_password",false);
        if (isRemember){
            String account=perf.getString("account","");
            String password=perf.getString("password","");
            et_username.setText(account);
            et_password.setText(password);
            cb_remember.setChecked(true);
        }

=======
        // 获取EditText
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_login_permission = (CheckBox) findViewById(R.id.cb_login_permission);
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
        // 获取按键登录
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
<<<<<<< HEAD
                String power;

                // TODO 是否管理员登录（是否勾选）下面方法的返回值是boolean
                if (cb_login_permission.isChecked()) {
                    power = "管理员";
                } else {
                    power = "学生";
                }
=======

                // 是否管理员登录（是否勾选）
                cb_login_permission.isChecked();
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
                /*
                * @TODO 和后端交互确认
                *
                * */
<<<<<<< HEAD
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String, String> map = new HashMap<>();
                        map.put("account", username);
                        map.put("password", password);
                        map.put("power", power);
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
                                    .url("http://192.168.1.130:8080/android_library_management_system_war_exploded/login") // 设置url
                                    .post(body) // 设置传递参数
                                    .build(); // 创建请求对象

                            // 获取响应对象，用于接收后端的响应
                            Response response = client.newCall(request).execute();

                            // 获取响应体中的返回值
                            String responseDate = response.body().string();

                            //测试用 123
                            System.out.println("true".equals(responseDate));
                            if ("true".equals(responseDate)) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("id",username);
                                intent.putExtras(bundle);
                                Data.setId(username);
                                startActivity(intent);
                                finish();
                            } else {

                            }

                        } catch (Exception e) {
                            e.getCause();
                        }
                    }
                }).start();
            }
        });

=======
                if (username.equals("admin") && password.equals("123456")) {
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
        // 获取按键取消
        Button btnCancel = findViewById(R.id.btn_cancel_login);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回主界面
<<<<<<< HEAD
                android.os.Process.killProcess(android.os.Process.myPid());
=======
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
            }
        });

    }
}