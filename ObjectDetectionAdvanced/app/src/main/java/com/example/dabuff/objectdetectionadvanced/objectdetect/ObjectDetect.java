package com.example.dabuff.objectdetectionadvanced.objectdetect;

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

import com.example.dabuff.objectdetectionadvanced.appdemo.R;
import com.iflytek.sunflower.FlowerCollector;

public class ObjectDetect extends Fragment {
    private Button btnSingleStart;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.objectdetect,container,false);
        requestPermissions();
        btnSingleStart = rootview.findViewById(R.id.btnsinglestart);
        btnSingleStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),OpenCameraActivity.class);
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
                        Manifest.permission.CAMERA);
                if(permission!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),new String[]
                            {Manifest.permission.CAMERA,},1);
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
