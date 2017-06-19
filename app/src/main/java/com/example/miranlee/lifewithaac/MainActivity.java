package com.example.miranlee.lifewithaac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClothClick(View view) {
        Intent i = new Intent(this, ClothActivity.class);
        startActivity(i);
    }
    public void onEmotionClick(View view) {
        Intent i = new Intent(this, EmotionActivity.class);
        startActivity(i);
    }
    public void onHospitalClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
    public void onLanguageClick(View view) {
        Intent i = new Intent(this, LanguageActivity.class);
        startActivity(i);
    }
    public void onRestaurantClick(View view) {
        Intent i = new Intent(this, CustomActivity.class);
        startActivity(i);
    }
    public void onSosClick(View view) {
        Intent i = new Intent(this, SosActivity.class);
        startActivity(i);
    }
}
