package com.iknow.android.videooperation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import iknow.android.video.view.VideoTrimmerView;

import iknow.android.video.interfaces.OnTrimVideoListener;

/**
 * Author：J.Chou
 * Date：  2016.07.01 11:08.
 * Email： who_know_me@163.com
 * Describe:
 */
public class VideoTrimmerActivity extends AppCompatActivity implements OnTrimVideoListener {

    private VideoTrimmerView mVideoTrimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trimmer_layout);

        Intent extraIntent = getIntent();
        String path = "";

        if (extraIntent != null) {
            path = extraIntent.getStringExtra("EXTRA_VIDEO_PATH");
        }


        mVideoTrimmer = ((VideoTrimmerView) findViewById(R.id.timeLine));
        if (mVideoTrimmer != null) {
            mVideoTrimmer.setMaxDuration(10);
            mVideoTrimmer.setOnTrimVideoListener(this);
            //mVideoTrimmer.setDestinationPath("/storage/emulated/0/DCIM/CameraCustom/");
            mVideoTrimmer.setVideoURI(Uri.parse(path));
        }
    }

    @Override
    public void getResult(Uri uri) {

    }

    @Override
    public void cancelAction() {

    }
}
