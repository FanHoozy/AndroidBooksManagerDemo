package com.example.booksmanagerdemo11.ui.BookManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.booksmanagerdemo11.R;

/**
 * @TODO 图书管理界面制作
 */
public class BooksManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_manage);

        Button btnAddBook = this.findViewById(R.id.btn_add_book);
        Button btnRemoveBook = this.findViewById(R.id.btn_remove_book);
        Button btnModifyBook = this.findViewById(R.id.btn_modify_book);

        // TODO 添加书籍
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // TODO 移除书籍
        btnRemoveBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // TODO 修改书籍
        btnModifyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}