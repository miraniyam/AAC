package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sungd on 2017-05-28.
 */

public class EmotionActivity extends Activity implements TextToSpeech.OnInitListener{
    TextView tv;
    TextToSpeech tts;
    String nar = null;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_emotion);
        setTitle("emotion");
        tts = new TextToSpeech(this, this);
        super.onCreate(savedInstanceState);



    }

    public void onangryClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("angry");
        nar = "화났어요";
        onInit(0);
    }
    public void onbashfulClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("bashful");
        nar = "부끄러워요";
        onInit(0);
    }
    public void onghostClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("ghost");
        nar = "오싹해요";
        onInit(0);
    }
    public void onhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("happy");
        nar = "행복해요";
        onInit(0);
    }
    public void onunhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unhappy");
        nar = "불행해요";
        onInit(0);
    }
    public void onloveClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("love");
        nar = "좋아해요";
        onInit(0);
    }
    public void onnumbClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("numb");
        nar = "망연자실해요";
        onInit(0);
    }
    public void onpleasedClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("pleased");
        nar = "즐거워요";
        onInit(0);
    }
    public void onsadClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("sad");
        nar = "우울해요";
        onInit(0);
    }
    public void onshockClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("shock");
        nar = "충격이에요";
        onInit(0);
    }
    public void onunsureClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unsure");
        nar = "자신이없어요";
        onInit(0);
    }
    public void onupsetClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("upset");
        nar = "속상해요";
        onInit(0);
    }

    @Override
    public void onInit(int i) {
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH, null);
    }
}

