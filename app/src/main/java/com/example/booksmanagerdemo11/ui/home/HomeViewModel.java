package com.example.booksmanagerdemo11.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.booksmanagerdemo11.domain.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel{
    /**
     * 解析json字符串，并封装成book集合对象
     * @param jsonStr
     * @return
     */

    public List<Book> parseJsonStringToBookObject(String jsonStr) {
       List<Book> bookList = new ArrayList<>();
       try {
           JSONObject jsonObject = new JSONObject(jsonStr);
           Book book = new Book();
           book.setBook_id(jsonObject.getString("book_id"));
           book.setAuthor(jsonObject.getString("author"));
           book.setBook_name(jsonObject.getString("book_name"));
           book.setClassifying(jsonObject.getString("classifying"));
           book.setSize(jsonObject.getInt("size"));




       } catch (JSONException e) {
           e.printStackTrace();
       }

       return  bookList;
    }


}