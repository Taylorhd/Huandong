package com.ecut.huandong.ui.discover;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Cora
 */
public class DiscoversViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DiscoversViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is discovery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}