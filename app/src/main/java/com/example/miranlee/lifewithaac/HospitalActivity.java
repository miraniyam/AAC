package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by sungd on 2017-05-28.
 */

public class HospitalActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hospital);
        setTitle("Game");
        super.onCreate(savedInstanceState);
    }

    public void onClickLevel1(View v) {
        startActivity(new Intent(this, LevelOneActivity.class));
    }

    public void onClickLevel2(View v) {
        startActivity(new Intent(this, LevelTwoActivity.class));
    }

    public void onClickLevel3(View v) {
        startActivity(new Intent(this, LevelThreeActivity.class));
    }
}
