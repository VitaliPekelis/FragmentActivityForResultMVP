package com.vitali.fragmentactivityforesultmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.vitali.fragmentactivityforesultmvp.SelectSomeDataPresenter.EXTRA_DATA;

public class GetResultActivity extends AppCompatActivity implements GetResultAgreement.View {

    private GetResultAgreement.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new GetResultPresenter();
        presenter.setView((GetResultAgreement.View) this);
        setContentView(R.layout.activity_for_result);
    }

    public void returnResultOk(View view) {
        setResult(Activity.RESULT_OK, new Intent().putExtras(presenter.getResult()));
        finishAfterTransition();
    }
}
