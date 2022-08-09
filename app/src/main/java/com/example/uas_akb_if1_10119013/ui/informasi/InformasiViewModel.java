package com.example.uas_akb_if1_10119013.ui.informasi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformasiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InformasiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}