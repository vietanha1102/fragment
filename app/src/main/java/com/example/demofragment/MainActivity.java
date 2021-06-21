package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FirstFragment.IsendDataFromFirstFrg, SecondFragment.IupdateDataFromSecondFrg {
    FrameLayout firstFrgLayout, secondFrgLayout;
    public static final String TAG = "ACTIVITY_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // nghich linh tinh

        firstFrgLayout = findViewById(R.id.firstFrLayout);
        secondFrgLayout = findViewById(R.id.secondFrLayout);

        addFragment(R.id.firstFrLayout, new FirstFragment());
        addFragment(R.id.secondFrLayout, new SecondFragment());

        Log.d(TAG,"OnCreateActivityMain");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"OnStartActivityMain");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResumeActivityMain");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPauseActivityMain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStopActivityMain");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"OnRestartActivityMain");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroyActivityMain");
    }

    private void addFragment(int frLayout, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(frLayout, fragment);
        transaction.commit();
    }

    @Override
    public void sendData(String data) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.secondFrLayout);
        if (secondFragment != null) {
            secondFragment.receiveDataToFirstFrg(data);
        }
    }

    @Override
    public void updateData(String dataUpdate) {
        FirstFragment firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.firstFrLayout);
        if (firstFragment != null) {
            firstFragment.receiveDataToSecondFrg(dataUpdate);
        }
    }

}
