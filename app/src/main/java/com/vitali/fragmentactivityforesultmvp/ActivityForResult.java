package com.vitali.fragmentactivityforesultmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
    }

    public void returnResultOk(View view) {
        Bundle extras = new Bundle();
        extras.putString(SelectSomeDataFragment.EXTRA_DATA, "Result From Activity");
        setResult(Activity.RESULT_OK, new Intent().putExtras(extras));
        finishAfterTransition();
    }
}
