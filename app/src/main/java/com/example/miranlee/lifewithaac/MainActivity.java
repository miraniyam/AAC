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
        setTitle("Life");
    }

    public void onClothClick(View view) {
        Intent i = new Intent(this, ClothActivity.class);
        startActivity(i);
    }
}
