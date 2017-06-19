package com.example.miranlee.lifewithaac;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by miran lee on 2017-06-19.
 */

public class LevelThreeActivity extends Activity implements TextToSpeech.OnInitListener{

    TextView tv;
    TextToSpeech tts;
    String narr = null;
    String nar = null;
    int answer = -1;

    String lang;
    int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        setTitle("Level 3");

        tv = (TextView)findViewById(R.id.question);
        tts = new TextToSpeech(this, this);
        tts.setSpeechRate(0.8f);

        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        if(lang.equals("korean")) {
            type = 0;
            nar = "다음 소리를 귀 기울여 잘 듣고, 알맞은 숫자를 터치하세요. ";
            tv.setText("터치하여 숫자 듣기");
        }else if(lang.equals("english")) {
            type = 1;
            nar = "Listen carefully, and touch the right number. ";
            tv.setText("Touch to listen again");
        }
        answer = generateQ();
        nar = nar + narr;
        onInit(0);

        ImageButton one = (ImageButton)findViewById(R.id.one);
        one.setOnClickListener(oc);
        ImageButton two = (ImageButton)findViewById(R.id.two);
        two.setOnClickListener(oc);
        ImageButton three = (ImageButton)findViewById(R.id.three);
        three.setOnClickListener(oc);
        ImageButton four = (ImageButton)findViewById(R.id.four);
        four.setOnClickListener(oc);
        ImageButton five = (ImageButton)findViewById(R.id.five);
        five.setOnClickListener(oc);
        ImageButton six = (ImageButton)findViewById(R.id.six);
        six.setOnClickListener(oc);
        ImageButton seven = (ImageButton)findViewById(R.id.seven);
        seven.setOnClickListener(oc);
        ImageButton eight = (ImageButton)findViewById(R.id.eight);
        eight.setOnClickListener(oc);
        ImageButton nine = (ImageButton)findViewById(R.id.nine);
        nine.setOnClickListener(oc);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(narr, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }

    ImageButton.OnClickListener oc = new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.one:
                    if(answer == 1) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.two:
                    if(answer == 2) {
                        answer = generateQ();
                       correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.three:
                    if(answer == 3) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.four:
                    if(answer == 4) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.five:
                    if(answer == 5) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.six:
                    if(answer == 6) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.seven:
                    if(answer == 7) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.eight:
                    if(answer == 8) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
                case R.id.nine:
                    if(answer == 9) {
                        answer = generateQ();
                        correct();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        wrong();
                    }
                    break;
            }

        }
    };

    @Override
    public void onInit(int status) {
        if(type == 1) {
            tts.setLanguage(Locale.ENGLISH);
        }
        if(type == 0) {
            tts.setLanguage(Locale.KOREA);
        }
        tts.speak(nar, TextToSpeech.QUEUE_FLUSH,null);
    }

    public int generateQ() {
        int temp = (int)(Math.random()*9)+1;
        switch (temp) {
            case 1:
                if(type == 0) {
                    narr = "일";
                }else if(type == 1) {
                    narr = "one";
                }
                break;
            case 2:
                if(type == 0) {
                    narr = "이";
                }else if(type == 1) {
                    narr = "two";
                }
                break;
            case 3:
                if(type == 0) {
                    narr = "삼";
                }else if(type == 1) {
                    narr = "three";
                }
                break;
            case 4:
                if(type == 0) {
                    narr = "사";
                }else if(type == 1) {
                    narr = "four";
                }
                break;
            case 5:
                if(type == 0) {
                    narr = "오";
                }else if(type == 1) {
                    narr = "five";
                }
                break;
            case 6:
                if(type == 0) {
                    narr = "육";
                }else if(type == 1) {
                    narr = "six";
                }
                break;
            case 7:
                if(type == 0) {
                    narr = "칠";
                }else if(type == 1) {
                    narr = "seven";
                }
                break;
            case 8:
                if(type == 0) {
                    narr = "팔";
                }else if(type == 1) {
                    narr = "eight";
                }
                break;
            case 9:
                if(type == 0) {
                    narr = "구";
                } else if(type == 1) {
                    narr = "nine";
                }
                break;
        }
        return temp;
        // 1과 9 사이의 난수가 만들어 지고 그에 맞는 이미지 설정!
    }

    public void correct() {
        if(type == 0) {
            tts.speak("정답입니다! 다음 숫자도 맞춰보세요. " + narr, TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(getApplicationContext(), "정답입니다!", Toast.LENGTH_SHORT).show();
        }else if(type == 1) {
            tts.speak("Correct! Try another one. " + narr, TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        }
    }

    public void wrong() {
        if(type == 0) {
            tts.speak("오답입니다. 다시 풀어보세요", TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요", Toast.LENGTH_SHORT).show();
        }else if(type == 1) {
            tts.speak("Wrong. Try Again.",TextToSpeech.QUEUE_FLUSH,null);
            Toast.makeText(getApplicationContext(), "Wrong. Try again.",Toast.LENGTH_SHORT).show();
        }
    }
}
