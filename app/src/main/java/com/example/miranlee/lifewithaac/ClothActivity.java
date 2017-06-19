package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

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

    String lang = null;
    int type = 0; // 0 : korean, 1 : english
    boolean isPlural = true;

    Button extraSmall, small, medium, big, extraBig, speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);
        tts = new TextToSpeech(this,this);
        tv = (TextView)findViewById(R.id.ClothTextView);

        extraSmall = (Button)findViewById(R.id.extraSmall);
        small = (Button)findViewById(R.id.small);
        medium = (Button)findViewById(R.id.medium);
        big = (Button)findViewById(R.id.big);
        extraBig = (Button)findViewById(R.id.extraBig);
        speak = (Button)findViewById(R.id.speak);

        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        if(lang.equals("korean")) {
            type = 0;

            extraSmall.setText("제일 작은");
            small.setText("작은");
            medium.setText("중간");
            big.setText("큰");
            extraBig.setText("제일 큰");
            speak.setText("말하기");
        }
        if(lang.equals("english")) {
            type = 1;

            extraSmall.setText("Extra Small");
            small.setText("Small");
            medium.setText("Medium");
            big.setText("Large");
            extraBig.setText("Extra Large");
            speak.setText("Speak");
        }
    }

    public String setString() {
        String s = "";
        if(type == 0) {
            s = color + " " + cloth + " " + num + " ";
            // 빨간색 바지 두개 스몰로 주세요.
            if (size != "") {
                s = s + size + "로 주세요.";
            } else {
                s = s + "주세요";
            }

            if (color == "" && cloth == "" && num == "" && size == "") {
                s = "옷, 색상, 숫자, 사이즈 버튼을 클릭하여 문장을 생성하세요.";
            }
            return s;
        } else if(type == 1) {
            // I want two small red trousers
            if(size != "") {
                s = "I want " + num + " " + size + " " + color + " " + cloth;
            } else {
                s = "I want " + num + " " + color + " " + cloth;
            }
            return s;
        }
        return s;
    }

    public void onTshirtClick(View v) {
        if(type == 0) {
            cloth = "티셔츠";
        }else if(type == 1) {
            cloth = "t-shirts";
        }
        nar = cloth;
        onInit(0);
    }

    public void onPantsClick(View v) {
        if(type == 0) {
            cloth = "바지";
        }else if(type == 1) {
            cloth = "trousers";
        }
        nar = cloth;
        onInit(0);
    }

    public void onSkirtClick(View v) {
        if(type == 0) {
            cloth = "치마";
        }else if(type == 1) {
            cloth = "skirt";
        }
        nar = cloth;
        onInit(0);
    }

    public void onShirtClick(View v) {
        if(type == 0) {
            cloth = "셔츠";
        }else if(type == 1) {
            cloth = "shirts";
        }
        nar = cloth;
        onInit(0);
    }

    public void onDressClick(View v) {
        if(type == 0) {
            cloth = "원피스";
        }else if(type == 1) {
            cloth = "dress";
        }
        nar = cloth;
        onInit(0);
    }

    public void onUnderwearClick(View v) {
        if(type == 0) {
            cloth = "속옷";
        }else if(type == 1) {
            cloth = "underwear";
        }
        nar = cloth;
        onInit(0);
    }

    public void onSocksClick(View v) {
        if(type == 0) {
            cloth = "양말";
        }else if(type == 1) {
            cloth = "socks";
        }
        nar = cloth;
        onInit(0);
    }

    public void onRedClick(View v) {
        if(type == 0) {
            color = "빨간색";
        }else if(type == 1) {
            color = "red";
        }
        nar = color;
        onInit(0);
    }

    public void onOrangeClick(View v) {
        if(type == 0) {
            color = "주황색";
        } else if(type == 1) {
            color = "orange";
        }
        nar = color;
        onInit(0);
    }

    public void onYellowClick(View v) {
        if(type == 0) {
            color = "노란색";
        }else if(type == 1) {
            color = "yellow";
        }
        nar = color;
        onInit(0);
    }

    public void onGreenClick(View v) {
        if(type == 0) {
            color = "초록색";
        } else if(type == 1) {
            color = "green";
        }
        nar = color;
        onInit(0);
    }

    public void onBlueClick(View v) {
        if(type == 0) {
            color = "파란색";
        } else if(type == 1) {
            color = "blue";
        }
        nar = color;
        onInit(0);
    }

    public void onOneClick(View v) {
        if(type == 0) {
            num = "한 개";
        }else if(type == 1) {
            num = "one";
            isPlural = false;
        }
        nar = num;
        onInit(0);
    }

    public void onTwoClick(View v) {
        if(type == 0) {
            num = "두 개";
        }else if(type == 1) {
            num = "two";
            isPlural = true;
        }
        nar = num;
        onInit(0);
    }

    public void onThreeClick(View v) {
        if(type == 0) {
            num = "세 개";
        }else if(type == 1) {
            num = "three";
            isPlural = true;
        }
        nar = num;
        onInit(0);
    }

    public void onFourClick(View v) {
        if(type == 0) {
            num = "네 개";
        }else if(type == 1) {
            num = "four";
            isPlural = true;
        }
        nar = num;
        onInit(0);
    }

    public void onFiveClick(View v) {
        if(type == 0) {
            num = "다섯 개";
        }else if(type == 1) {
            num = "five";
            isPlural = true;
        }
        nar = num;
        onInit(0);
    }

    public void onXSClick(View v) {
        if(type == 0) {
            size = "제일 작은 사이즈";
        }else if(type == 1) {
            size = "extra small";
        }
        nar = size;
        onInit(0);
    }

    public void onSClick(View v) {
        if(type == 0) {
            size = "작은 사이즈";
        }else if(type == 1) {
            size = "small";
        }
        nar = size;
        onInit(0);
    }

    public void onMClick(View v) {
        if(type == 0) {
            size = "중간 사이즈";
        }else if(type == 1) {
            size = "medium";
        }
        nar = size;
        onInit(0);
    }

    public void onLClick(View v) {
        if(type == 0) {
            size = "큰 사이즈";
        }else if(type == 1) {
            size = "large";
        }
        nar = size;
        onInit(0);
    }
    public void onXLClick(View v) {
        if(type == 0) {
            size = "제일 큰 사이즈";
        } else if(type == 1) {
            size = "extra large";
        }
        nar = size;
        onInit(0);
    }

    public void onSpeakClick(View v) {
        nar = setString();
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
        tv.setText(nar);
        tts.speak(nar, TextToSpeech.QUEUE_FLUSH,null);
    }
}
