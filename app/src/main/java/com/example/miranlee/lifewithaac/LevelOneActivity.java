package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

/**
 * Created by miran lee on 2017-06-19.
 */

public class LevelOneActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String lang;
    int type = -1;

    TextToSpeech tts;
    String nar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        setTitle("Level 1");

        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        if(lang.equals("korean")) {
            type = 0;
            nar = "숫자를 클릭해 보세요";
        }else if(lang.equals("english")) {
            type = 1;
            nar = "Touch any number";
        }

        tts = new TextToSpeech(this, this);
        onInit(0);
    }

    public void onClick1(View v) {
        if(type == 0) {
            nar = "일";
        }else if(type == 1) {
            nar = "one";
        }
        onInit(0);
    }

    public void onClick2(View v) {
        if(type ==0 ) {
            nar = "이";
        }else if(type == 1) {
            nar = "two";
        }
        onInit(0);
    }

    public void onClick3(View v) {
        if(type == 0) {
            nar = "삼";
        }else if(type == 1) {
            nar = "three";
        }
        onInit(0);
    }

    public void onClick4(View v) {
        if(type == 0) {
            nar = "사";
        }else if(type == 1) {
            nar = "four";
        }
        onInit(0);
    }

    public void onClick5(View v) {
        if(type == 0) {
            nar = "오";
        }else if(type == 1) {
            nar = "five";
        }
        onInit(0);
    }

    public void onClick6(View v) {
        if(type == 0) {
            nar = "육";
        }else if(type == 1) {
            nar = "six";
        }
        onInit(0);
    }

    public void onClick7(View v) {
        if(type == 0) {
            nar = "칠";
        }else if(type == 1) {
            nar = "seven";
        }
        onInit(0);
    }

    public void onClick8(View v) {
        if(type == 0) {
            nar = "팔";
        }else if(type == 1) {
            nar = "eight";
        }
        onInit(0);
    }

    public void onClick9(View v) {
        if(type == 0) {
            nar = "구";
        }else if(type == 1) {
            nar = "nine";
        }
        onInit(0);
    }

    @Override
    public void onInit(int status) {
        if(type == 1) {
            tts.setLanguage(Locale.ENGLISH);
        }
        if(type == 0) {
            tts.setLanguage(Locale.KOREA);
        }
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH,null);
    }
}
