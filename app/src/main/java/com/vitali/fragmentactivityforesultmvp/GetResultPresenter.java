package com.vitali.fragmentactivityforesultmvp;

import android.os.Bundle;

import static com.vitali.fragmentactivityforesultmvp.SelectSomeDataPresenter.EXTRA_DATA;

class GetResultPresenter implements GetResultAgreement.Presenter {

    private GetResultAgreement.View view;

    @Override
    public void setView(GetResultAgreement.View view) {
        this.view = view;
    }

    @Override
    public Bundle getResult() {
        Bundle extras = new Bundle();
        extras.putString(EXTRA_DATA, "Result From Activity");
        return extras;
    }
}
