package com.example.dabuff.objectdetectionadvanced.voicedetect.voicedemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.iflytek.sunflower.FlowerCollector;

import com.example.dabuff.objectdetectionadvanced.appdemo.R;

public class VoiceDetect extends Fragment{

    //private Toast mToast;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.main,container,false);
        requestPermissions();
        //mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);

        Button buttonIse = rootview.findViewById(R.id.buttonIse);
        buttonIse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),IseDemo.class);
                startActivity(intent);
            }
        });

        Button buttonIat = rootview.findViewById(R.id.buttonIat);
        buttonIat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),VoiceInteraction.class);
                startActivity(intent);
            }
        });
        return rootview;
    }


    @Override
    public void onResume() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onResume(getActivity());
        FlowerCollector.onPageStart("");
        super.onResume();
    }

    @Override
    public void onPause() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onPageEnd("");
        FlowerCollector.onPause(getActivity());
        super.onPause();
    }

    private void requestPermissions(){
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int permission = ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permission!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),new String[]
                            {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.LOCATION_HARDWARE,Manifest.permission.READ_PHONE_STATE,
                                    Manifest.permission.WRITE_SETTINGS,Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_CONTACTS},0x0010);
                }

                if(permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),new String[] {
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},0x0010);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
