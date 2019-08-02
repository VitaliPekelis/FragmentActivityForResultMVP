package com.vitali.fragmentactivityforesultmvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SelectSomeDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectSomeDataFragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_CODE = 123;
    public static final String EXTRA_DATA = "123";

    private MutableLiveData<DataModel> localLiveData;

    public LiveData<DataModel> getLiveData() {
        return liveData;
    }

    private LiveData<DataModel> liveData;


    public SelectSomeDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectSomeDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectSomeDataFragment newInstance(String param1, String param2) {
        SelectSomeDataFragment fragment = new SelectSomeDataFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localLiveData = new MutableLiveData<DataModel>();
        liveData = localLiveData;

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
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

    }

    @Override
    public void onDetach() {
        super.onDetach();
       /* mListener = null;*/
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CODE && isAdded() && data != null){
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

    @Override
    public void onClick(View view) {
        startActivityForResult(new Intent(getContext(), ActivityForResult.class) ,REQUEST_CODE);
    }
}
