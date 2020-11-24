package com.example.booksmanagerdemo11.ui.BookManager;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.domain.Data;
=======

import android.os.Bundle;

import com.example.booksmanagerdemo11.R;
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72

/**
 * @TODO 图书管理界面制作
 */
public class BooksManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_manage);
<<<<<<< HEAD
        TextView textView=findViewById(R.id.tv_3);
        textView.setText("图书管理");
        Button btnAddBook = this.findViewById(R.id.btn_add_book);
        Button btnRemoveBook = this.findViewById(R.id.btn_remove_book);
        Button btnModifyBook = this.findViewById(R.id.btn_modify_book);

        String[] strings = {"a", "b"};
        RecyclerView recyclerView = findViewById(R.id.rcl_book_manage);
//        ListAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, strings);

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


=======
>>>>>>> ebed69abb19d460f857b96fd5bf1ef8a750a1f72
    }
}