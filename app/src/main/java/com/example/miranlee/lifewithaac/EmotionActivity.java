package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by sungd on 2017-05-28.
 */

public class EmotionActivity extends Activity implements TextToSpeech.OnInitListener{
    TextView tv;
    TextToSpeech tts;
    String nar = null;
    String emo = "";

    String lang;
    int type = -1;
    Button speak;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);
        setTitle("emotion");
        tts = new TextToSpeech(this, this);
        tv = (TextView)findViewById(R.id.see);
        speak = (Button)findViewById(R.id.speak);

        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        if(lang.equals("korean")) {
            speak.setText("말하기");
            type = 0;
        }else if(lang.equals("english")) {
            speak.setText("Speak");
            type = 1;
        }
    }

    public void onangryClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("angry");
        if(type == 0) {
            emo = "화났어요";
        }else if(type == 1) {
            emo = "angry";
        }
        nar = emo;
        onInit(0);
    }
    public void onbashfulClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("bashful");
        if(type == 0) {
            emo = "부끄러워요";
        }else if(type == 1) {
            emo = "blushing";
        }
        nar = emo;
        onInit(0);
    }
    public void onghostClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("ghost");
        if(type == 0) {
            emo = "오싹해요";
        }else if(type == 1) {
            emo = "feeling creepy";
        }
        nar = emo;
        onInit(0);
    }
    public void onhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("happy");
        if(type == 0) {
            emo = "행복해요";
        }else if(type == 1) {
            emo = "happy";
        }
        nar = emo;
        onInit(0);
    }
    public void onunhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unhappy");
        if(type == 0) {
            emo = "불행해요";
        }else if(type == 1) {
            emo = "not happy";
        }
        nar = emo;
        onInit(0);
    }
    public void onloveClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("love");
        if(type == 0) {
            emo = "좋아해요";
        } else if(type == 1) {
            emo = "loving you";
        }
        nar = emo;
        onInit(0);
    }
    public void onnumbClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("numb");
        if(type == 0) {
            emo = "망연자실해요";
        }else if(type == 1) {
            emo = "disappointed";
        }
        nar = emo;
        onInit(0);
    }
    public void onpleasedClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("pleased");
        if(type == 0) {
            emo = "즐거워요";
        }else if(type == 1) {
            emo = "pleased";
        }
        nar = emo;
        onInit(0);
    }
    public void onsadClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("sad");
        if(type == 0) {
            emo = "우울해요";
        } else if(type == 1) {
            emo = "sad";
        }
        nar = emo;
        onInit(0);
    }
    public void onshockClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("shock");
        if(type == 0) {
            emo = "충격이에요";
        } else if(type == 1) {
            emo = "shocked";
        }
        nar = emo;
        onInit(0);
    }
    public void onunsureClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unsure");
        if(type == 0) {
            emo = "자신이없어요";
        }else if(type == 1) {
            emo = "not sure";
        }
        nar = emo;
        onInit(0);
    }
    public void onupsetClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("upset");
        if(type == 0) {
            emo = "속상해요";
        }else if(type == 1) {
            emo = "upset";
        }
        nar = emo;
        onInit(0);
    }
    public String setString() {
        String s = emo;
        if(emo!="") {
            if(type == 0) {
                s = "저는 지금 " + s;
            }else if(type == 1) {
                s = "I am "+s;
            }
        }
        else
        {   if(type == 0) {
                s = "이미지를 선택하여 문장을 생성하세요.";
            }else if(type == 1) {
                s = "Touch image to create sentence.";
            }
        }
        return s;
    }

    public void onSpeakClick(View view){
        nar = setString();
            onInit(0);
    }

    @Override
    public void onInit(int i) {
        if(type == 1) {
            tts.setLanguage(Locale.ENGLISH);
        }
        if(type == 0) {
            tts.setLanguage(Locale.KOREA);
        }
        tv.setText(nar);
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH, null);
    }
}

