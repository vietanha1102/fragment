package com.example.demofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment {
    EditText edtFrgSecond;
    Button btnUpdateData;
    IupdateDataFromSecondFrg mIupdateData;

    public interface IupdateDataFromSecondFrg{
        void updateData(String dataUpdate);
    }

    public SecondFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIupdateData = (IupdateDataFromSecondFrg) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtFrgSecond = view.findViewById(R.id.edtFrgSecond);
        btnUpdateData = view.findViewById(R.id.btnUpdateData);

        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataUpdate = edtFrgSecond.getText().toString().trim();
                upDateData(dataUpdate);
            }
        });
    }

    private void upDateData(String dataUpdate) {
        mIupdateData.updateData(dataUpdate);
    }

    public void receiveDataToFirstFrg(String dataRecive) {
        edtFrgSecond.setText(dataRecive);
    }
}