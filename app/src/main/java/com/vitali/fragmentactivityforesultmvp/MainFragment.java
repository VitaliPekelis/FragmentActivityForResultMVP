package com.vitali.fragmentactivityforesultmvp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    ViewGroup resultViewGroup;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resultViewGroup = view.findViewById(R.id.main_frg_result_container_lil);

        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.some_select_frg);
        if(fragment instanceof SelectSomeDataFragment){
            ((SelectSomeDataFragment)fragment).getLiveData().observe(getViewLifecycleOwner(), new Observer<DataModel>() {
                @Override
                public void onChanged(DataModel dataModel) {
                    TextView textView = new TextView(getContext());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    textView.setText(dataModel.getDataString());
                    resultViewGroup.addView(textView);
                }
            });
        }
    }
}
