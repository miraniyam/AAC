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
    String emo = "";

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_emotion);
        setTitle("emotion");
        tts = new TextToSpeech(this, this);
        tv = (TextView)findViewById(R.id.see);
        super.onCreate(savedInstanceState);



    }

    public void onangryClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("angry");
        emo = "화났어요";
        nar = emo;
        onInit(0);
    }
    public void onbashfulClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("bashful");
        emo = "부끄러워요";
        nar = emo;
        onInit(0);
    }
    public void onghostClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("ghost");
        emo = "오싹해요";
        nar = emo;
        onInit(0);
    }
    public void onhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("happy");
        emo = "행복해요";
        nar = emo;
        onInit(0);
    }
    public void onunhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unhappy");
        emo = "불행해요";
        nar = emo;
        onInit(0);
    }
    public void onloveClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("love");
        emo = "좋아해요";
        nar = emo;
        onInit(0);
    }
    public void onnumbClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("numb");
        emo = "망연자실해요";
        nar = emo;
        onInit(0);
    }
    public void onpleasedClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("pleased");
        emo = "즐거워요";
        nar = emo;
        onInit(0);
    }
    public void onsadClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("sad");
        emo = "우울해요";
        nar = emo;
        onInit(0);
    }
    public void onshockClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("shock");
        emo = "충격이에요";
        nar = emo;
        onInit(0);
    }
    public void onunsureClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unsure");
        emo = "자신이없어요";
        nar = emo;
        onInit(0);
    }
    public void onupsetClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("upset");
        emo = "속상해요";
        nar = emo;
        onInit(0);
    }
    public String setString() {
        String s = emo;
        if(emo!="") {
            s = "저는 지금 " + s;
        }
        else
        {   s= "이미지를 선택하여 문장을 생성하세요.";
        }
        return s;
    }

    public void onSpeakClick(View view){
        nar = setString();
            onInit(0);
    }

    @Override
    public void onInit(int i) {
        tv.setText(nar);
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH, null);
    }
}

