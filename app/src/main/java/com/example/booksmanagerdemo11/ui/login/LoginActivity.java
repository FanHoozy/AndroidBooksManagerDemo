package com.example.booksmanagerdemo11.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booksmanagerdemo11.MainActivity;
import com.example.booksmanagerdemo11.R;

/**
 *  登录页面
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "SeventhActivity";
    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_login_permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 获取EditText
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_login_permission = (CheckBox) findViewById(R.id.cb_login_permission);
        // 获取按键登录
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                // 是否管理员登录（是否勾选）
                cb_login_permission.isChecked();
                /*
                * @TODO 和后端交互确认
                *
                * */
                if (username.equals("admin") && password.equals("123456")) {
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 获取按键取消
        Button btnCancel = findViewById(R.id.btn_cancel_login);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回主界面
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}