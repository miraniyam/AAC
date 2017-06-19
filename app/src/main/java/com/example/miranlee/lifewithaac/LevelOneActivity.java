package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by miran lee on 2017-06-19.
 */

public class LevelOneActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    String nar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_level1);
        setTitle("Level 1");
        tts = new TextToSpeech(this, this);
        super.onCreate(savedInstanceState);
    }

    public void onClick1(View v) {
        nar = "일";
        onInit(0);
    }

    public void onClick2(View v) {
        nar = "이";
        onInit(0);
    }

    public void onClick3(View v) {
        nar = "삼";
        onInit(0);
    }

    public void onClick4(View v) {
        nar = "사";
        onInit(0);
    }

    public void onClick5(View v) {
        nar = "오";
        onInit(0);
    }

    public void onClick6(View v) {
        nar = "육";
        onInit(0);
    }

    public void onClick7(View v) {
        nar = "칠";
        onInit(0);
    }

    public void onClick8(View v) {
        nar = "팔";
        onInit(0);
    }

    public void onClick9(View v) {
        nar = "구";
        onInit(0);
    }

    @Override
    public void onInit(int status) {
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH,null);
    }
}
