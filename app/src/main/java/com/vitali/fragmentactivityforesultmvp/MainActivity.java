package com.vitali.fragmentactivityforesultmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Fragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = MainFragment.newInstance();
    }


    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager()
                .beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, mainFragment)
                .commit();
    }


    public void toggleVisibility(View view) {
        if(mainFragment.isHidden()){
            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .show(mainFragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .hide(mainFragment)
                    .commit();
        }
    }
}
