package com.example.demofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;


public class FirstFragment extends Fragment {
    Button btnSendData;
    EditText edtFrgFirst;
    IsendDataFromFirstFrg mIsendDta;
    public static final String TAG = "FIRST_FRAG_LOG";

    public interface IsendDataFromFirstFrg {
        void sendData(String data);
    }

    public FirstFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIsendDta = (IsendDataFromFirstFrg) getActivity();
        Log.d(TAG,"onAttachFragmentFirst");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreateFragmentFirst");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateViewFragmentFirst");
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSendData = view.findViewById(R.id.btnSendData);
        edtFrgFirst = view.findViewById(R.id.edtFrgFirst);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mData = edtFrgFirst.getText().toString().trim();
                mIsendDta.sendData(mData);
            }
        });
        Log.d(TAG,"onViewCreatedFragmentFirst");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreatedFragmentFirst");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStartFragmentFirst");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResumeFragmentFirst");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPauseFragmentFirst");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStopFragmentFirst");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyViewFragmentFirst");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroyFragmentFirst");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDettachFragmentFirst");
    }

    public void receiveDataToSecondFrg(String updateData){
        edtFrgFirst.setText(updateData);
    }


}