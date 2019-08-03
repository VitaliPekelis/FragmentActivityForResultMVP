package com.vitali.fragmentactivityforesultmvp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

class SelectSomeDataPresenter implements SelectSomeDataAgreement.Presenter {

    public static final String EXTRA_DATA = "123";
    SelectSomeDataAgreement.View view;

    private MutableLiveData<DataModel> localLiveData;
    private LiveData<DataModel> liveData;

    SelectSomeDataPresenter() {
        localLiveData = new MutableLiveData<>();
        liveData = localLiveData;
    }

    @Override
    public void setView(SelectSomeDataAgreement.View view) {
        this.view = view;
    }

    @Override
    public LiveData<DataModel> getLiveData() {
        return liveData;
    }

    @Override
    public void onActivityResultOk(Intent data) {
        if(data != null){
            Bundle extras = data.getExtras();
            if (extras != null) {
                String result = extras.getString(EXTRA_DATA);
                localLiveData.postValue(new DataModel().setDataString(result));
                new Handler().postDelayed(()-> localLiveData.postValue(new DataModel().setDataString("------1------")), 300);
                new Handler().postDelayed(()-> localLiveData.postValue(new DataModel().setDataString("------2------")), 350);
                new Handler().postDelayed(()-> localLiveData.postValue(new DataModel().setDataString("------3------")), 450);
                new Handler().postDelayed(()-> localLiveData.postValue(new DataModel().setDataString("------4------")), 500);
                new Handler().postDelayed(()-> localLiveData.postValue(new DataModel().setDataString("------5------")), 550);

            }
        }
    }
}
