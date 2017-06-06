package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by sungd on 2017-05-24.
 */

public class ClothActivity extends Activity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    String nar = null;
    String cloth = "";
    String color = "";
    String num = "";
    String size = "";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_cloth);
        tts = new TextToSpeech(this,this);
        tv = (TextView)findViewById(R.id.ClothTextView);
        super.onCreate(savedInstanceState);
    }

    public String setString() {
        // 빨간색 바지 두개 스몰로 주세요.
        String s = color + " "+ cloth + " "+num+" ";
        if(size != "") {
            s = s+size+"로 주세요.";
        }else {
            s = s + "주세요";
        }

        if(color == "" && cloth == "" && num == "" && size == "") {
            s = "옷, 색상, 숫자, 사이즈 버튼을 클릭하여 문장을 생성하세요.";
        }
        return s;
    }

    public void onTshirtClick(View v) {
        cloth = "티셔츠";
        nar = cloth;
        onInit(0);
    }

    public void onPantsClick(View v) {
        cloth = "바지";
        nar = cloth;
        onInit(0);
    }

    public void onSkirtClick(View v) {
        cloth = "치마";
        nar = cloth;
        onInit(0);
    }

    public void onShirtClick(View v) {
        cloth = "셔츠";
        nar = cloth;
        onInit(0);
    }

    public void onDressClick(View v) {
        cloth = "원피스";
        nar = cloth;
        onInit(0);
    }

    public void onUnderwearClick(View v) {
        cloth = "속옷";
        nar = cloth;
        onInit(0);
    }

    public void onSocksClick(View v) {
        cloth = "양말";
        nar = cloth;
        onInit(0);
    }

    public void onRedClick(View v) {
        color = "빨간색";
        nar = color;
        onInit(0);
    }

    public void onOrangeClick(View v) {
        color = "주황색";
        nar = color;
        onInit(0);
    }

    public void onYellowClick(View v) {
        color = "노란색";
        nar = color;
        onInit(0);
    }

    public void onGreenClick(View v) {
        color = "초록색";
        nar = color;
        onInit(0);
    }

    public void onBlueClick(View v) {
        color = "파란색";
        nar = color;
        onInit(0);
    }

    public void onOneClick(View v) {
        num = "한 개";
        nar = num;
        onInit(0);
    }

    public void onTwoClick(View v) {
        num = "두 개";
        nar = num;
        onInit(0);
    }

    public void onThreeClick(View v) {
        num = "세 개";
        nar = num;
        onInit(0);
    }

    public void onFourClick(View v) {
        num = "네 개";
        nar = num;
        onInit(0);
    }

    public void onFiveClick(View v) {
        num = "다섯 개";
        nar = num;
        onInit(0);
    }

    public void onXSClick(View v) {
        size = "제일 작은 사이즈";
        nar = size;
        onInit(0);
    }

    public void onSClick(View v) {
        size = "작은 사이즈";
        nar = size;
        onInit(0);
    }

    public void onMClick(View v) {
        size = "중간 사이즈";
        nar = size;
        onInit(0);
    }

    public void onLClick(View v) {
        size = "큰 사이즈";
        nar = size;
        onInit(0);
    }
    public void onXLClick(View v) {
        size = "제일 큰 사이즈";
        nar = size;
        onInit(0);
    }

    public void onSpeakClick(View v) {
        nar = setString();
        onInit(0);
    }

    @Override
    public void onInit(int status) {
        tv.setText(nar);
        tts.speak(nar, TextToSpeech.QUEUE_FLUSH,null);
    }
}
