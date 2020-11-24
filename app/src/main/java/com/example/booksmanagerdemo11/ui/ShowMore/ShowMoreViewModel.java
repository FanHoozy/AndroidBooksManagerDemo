package com.example.booksmanagerdemo11.ui.ShowMore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShowMoreViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShowMoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}