package com.vitali.fragmentactivityforesultmvp;


import android.content.Intent;

import androidx.lifecycle.LiveData;

public interface SelectSomeDataAgreement {

    interface View {

    }

    interface Presenter {
        void setView(SelectSomeDataAgreement.View view);
        LiveData<DataModel> getLiveData();
        void onActivityResultOk(Intent data);
    }
}
