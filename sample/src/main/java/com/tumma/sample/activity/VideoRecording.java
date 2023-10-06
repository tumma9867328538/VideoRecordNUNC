package com.tumma.sample.activity;

import android.os.Bundle;

import com.tumma.sample.R;


public class VideoRecording extends BaseCameraActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);
        onCreateActivity();
        videoWidth = 720;
        videoHeight = 1280;
        cameraWidth = 1280;
        cameraHeight = 720;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
