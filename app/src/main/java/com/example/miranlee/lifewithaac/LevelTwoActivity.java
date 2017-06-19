package com.example.miranlee.lifewithaac;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by miran lee on 2017-06-19.
 */

public class LevelTwoActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    ImageView im;
    String nar = null;
    int answer = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(this, this);
        setTitle("Level 2");
        setContentView(R.layout.activity_level2);

        nar = "고양이는 몇 마리 인가요? 아래의 숫자를 선택해 보세요.";
        onInit(0);

        im = (ImageView)findViewById(R.id.RandomImage);

        answer = generateQ();

        ImageButton.OnClickListener oc = new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.one:
                        if(answer == 1) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.two:
                        if(answer == 2) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.three:
                        if(answer == 3) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.four:
                        if(answer == 4) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.five:
                        if(answer == 5) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.six:
                        if(answer == 6) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.seven:
                        if(answer == 7) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.eight:
                        if(answer == 8) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nine:
                        if(answer == 9) {
                            tts.speak("정답입니다! 다른 문제도 맞춰보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                            answer = generateQ();
                            // 정답
                        }else {
                            // 오답 - 다시 풀기
                            tts.speak("오답입니다. 다시 풀어보세요.",TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        };

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
    }

    public int generateQ() {
        int temp = (int)(Math.random()*9)+1;
        switch (temp) {
            case 1:
                im.setImageResource(R.drawable.q1);
                break;
            case 2:
                im.setImageResource(R.drawable.q2);
                break;
            case 3:
                im.setImageResource(R.drawable.q3);
                break;
            case 4:
                im.setImageResource(R.drawable.q4);
                break;
            case 5:
                im.setImageResource(R.drawable.q5);
                break;
            case 6:
                im.setImageResource(R.drawable.q6);
                break;
            case 7:
                im.setImageResource(R.drawable.q7);
                break;
            case 8:
                im.setImageResource(R.drawable.q8);
                break;
            case 9:
                im.setImageResource(R.drawable.q9);
                break;
        }
        return temp;
        // 1과 9 사이의 난수가 만들어 지고 그에 맞는 이미지 설정!
    }

    @Override
    public void onInit(int status) {
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH,null);
    }
}
