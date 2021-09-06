package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    private Switch btSwitch, wifiSwitch, locSwitch,mdSwitch;
    BluetoothAdapter myBtAdapter;
    private TextView btTextView, wifiTextView, locTextView, mdTextView;
    final int CODE=200;
    String[] perms = {"android.permission", "android.permission.CHANGE_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Switches
        btSwitch = findViewById(R.id.btSwith);

        wifiSwitch = findViewById(R.id.wifiSwitch);
        locSwitch = findViewById(R.id.locSwitch);
        mdSwitch = findViewById(R.id.mdSwitch);

        //Text views
        btTextView = findViewById(R.id.btTextView);
        wifiTextView = findViewById(R.id.wifiTextView);
        locTextView = findViewById(R.id.locTextView);
        mdTextView = findViewById(R.id.mdTextview);

        myBtAdapter =  BluetoothAdapter.getDefaultAdapter();
        btSwitch.setChecked(myBtAdapter.isEnabled());

        btSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                myBtAdapter =  BluetoothAdapter.getDefaultAdapter();


                if (isChecked){
                    if(!myBtAdapter.isEnabled()) myBtAdapter.enable();
                    btTextView.setText("Blutooth enabled");


                }else{
                    if(myBtAdapter.isEnabled()){
                        myBtAdapter.disable();
                    }
                    btTextView.setText("Bt Off");
                }
            }
        });


    }




}