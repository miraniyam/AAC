package com.example.miranlee.lifewithaac;


import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by miran lee on 2017-06-19.
 */

public class LevelThreeActivity extends Activity implements TextToSpeech.OnInitListener{

    TextView tv;
    TextToSpeech tts;
    String narr = null;
    String nar = null;
    int answer = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        setTitle("Level 3");

        tv = (TextView)findViewById(R.id.question);
        tts = new TextToSpeech(this, this);
        tts.setSpeechRate(0.8f);

        nar = "다음 소리를 귀 기울여 잘 듣고, 알맞은 숫자를 터치하세요.";

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
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.two:
                    if(answer == 2) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.three:
                    if(answer == 3) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.four:
                    if(answer == 4) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.five:
                    if(answer == 5) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.six:
                    if(answer == 6) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.seven:
                    if(answer == 7) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.eight:
                    if(answer == 8) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.nine:
                    if(answer == 9) {
                        answer = generateQ();
                        tts.speak("정답입니다! 다음 숫자도 맞춰보세요."+narr,TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "정답입니다!",Toast.LENGTH_SHORT).show();
                        // 정답
                    }else {
                        // 오답 - 다시 풀기
                        tts.speak("오답입니다. 다시 풀어보세요",TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(getApplicationContext(), "오답입니다. 다시 풀어보세요",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

        }
    };

    @Override
    public void onInit(int status) {
        tts.speak(nar, TextToSpeech.QUEUE_FLUSH,null);
    }

    public int generateQ() {
        int temp = (int)(Math.random()*9)+1;
        switch (temp) {
            case 1:
                narr = "일";
                break;
            case 2:
                narr = "이";
                break;
            case 3:
                narr = "삼";
                break;
            case 4:
                narr = "사";
                break;
            case 5:
                narr = "오";
                break;
            case 6:
                narr = "육";
                break;
            case 7:
                narr = "칠";
                break;
            case 8:
                narr = "팔";
                break;
            case 9:
                narr = "구";
                break;
        }
        return temp;
        // 1과 9 사이의 난수가 만들어 지고 그에 맞는 이미지 설정!
    }
}
