package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sungd on 2017-05-28.
 */

public class GameActivity extends Activity {

    String lang;
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setTitle("Game");

        Intent i = getIntent();
        lang = i.getStringExtra("lang");

        tv = (TextView)findViewById(R.id.question);
        if(lang.equals("korean")) {
            tv.setText("게임 레벨을 선택하세요!");
        }else if(lang.equals("english")) {
            tv.setText("Choose your game level!");
        }
    }

    public void onClickLevel1(View v) {
        Intent i = new Intent(this, LevelOneActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }

    public void onClickLevel2(View v) {
        Intent i = new Intent(this, LevelThreeActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }
    // 제가... 음.. 레벨 삼을 레벨 투에 만들었어요.. 제송함다..!>_<

    public void onClickLevel3(View v) {
        Intent i = new Intent(this, LevelTwoActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }
}
