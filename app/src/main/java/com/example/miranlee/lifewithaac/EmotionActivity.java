package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sungd on 2017-05-28.
 */

public class EmotionActivity extends Activity{
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_emotion);
        setTitle("emotion");
        super.onCreate(savedInstanceState);



    }

    public void onangryClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("angry");
    }
    public void onbashfulClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("bashful");
    }
    public void onghostClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("ghost");
    }
    public void onhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("happy");
    }
    public void onunhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unhappy");
    }
    public void onloveClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("love");
    }
    public void onnumbClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("numb");
    }
    public void onpleasedClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("pleased");
    }
    public void onsadClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("sad");
    }
    public void onshockClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("shock");
    }
    public void onunsureClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unsure");
    }
    public void onupsetClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("upset");
    }

}

