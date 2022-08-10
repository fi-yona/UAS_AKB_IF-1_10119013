package com.example.uas_akb_if1_10119013.ui.catatanharian;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CatatanHarianViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CatatanHarianViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}