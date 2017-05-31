package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

/**
 * Created by sungd on 2017-05-24.
 */

public class ClothActivity extends Activity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    String nar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_cloth);
        tts = new TextToSpeech(this,this);
        super.onCreate(savedInstanceState);
    }

    public void onTshirtClick(View v) {
        nar = "티셔츠";
        onInit(0);
    }

    public void onPantsClick(View v) {
        nar = "바지";
        onInit(0);
    }

    public void onSkirtClick(View v) {
        nar = "치마";
        onInit(0);
    }

    public void onShirtClick(View v) {
        nar = "셔츠";
        onInit(0);
    }

    public void onDressClick(View v) {
        nar = "원피스";
        onInit(0);
    }

    public void onUnderwearClick(View v) {
        nar = "속옷";
        onInit(0);
    }

    public void onSocksClick(View v) {
        nar = "양말";
        onInit(0);
    }

    @Override
    public void onInit(int status) {
        tts.speak(nar, TextToSpeech.QUEUE_FLUSH,null);
    }
}
