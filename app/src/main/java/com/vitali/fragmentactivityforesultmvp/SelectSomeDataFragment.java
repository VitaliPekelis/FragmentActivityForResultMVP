package com.vitali.fragmentactivityforesultmvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SelectSomeDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectSomeDataFragment extends Fragment implements View.OnClickListener,
                                                                SelectSomeDataAgreement.View {
    private static final int REQUEST_CODE = 123;

    private SelectSomeDataAgreement.Presenter presenter;

    public LiveData<DataModel> getLiveData() {
        return presenter.getLiveData();
    }


    public SelectSomeDataFragment() {
        // Required empty public constructor
    }

    public static SelectSomeDataFragment newInstance() {
        return new SelectSomeDataFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_some_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.start_activity_for_result_btn).setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new SelectSomeDataPresenter();
        presenter.setView((SelectSomeDataAgreement.View) this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
       /* mListener = null;*/
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == REQUEST_CODE && isAdded()){
                presenter.onActivityResultOk( data);
            }

        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.start_activity_for_result_btn)
            startActivityForResult(new Intent(getContext(), GetResultActivity.class) ,REQUEST_CODE);
    }
}
