package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends Activity {

    String lang = "";
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File files = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/LifeWithAAC");
        boolean f = files.mkdirs();
        File file = new File(files.getAbsolutePath()+"/lang.txt");
        path = file.getAbsolutePath();

        if(!file.exists()) {
            FileWriter fw = null;
            BufferedWriter buf = null;
            try {
                // 기본은 한국어로 설정.
                fw = new FileWriter(file);
                buf = new BufferedWriter(fw);
                buf.write("korean");
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if(buf != null) {
                    buf.close();
                }
                if(fw != null) {
                    fw.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            char ch;
            int data;
            FileReader fr = null;
            try {
                fr = new FileReader(file);
                while((data = fr.read()) != -1) {
                    ch = (char)data;
                    lang = lang+ch;
                }
                fr.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void onClothClick(View view) {
        Intent i = new Intent(this, ClothActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }
    public void onEmotionClick(View view) {
        Intent i = new Intent(this, EmotionActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }
    public void onHospitalClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }

    public void onLanguageClick(View view) {
        Intent i = new Intent(this, LanguageActivity.class);
        i.putExtra("lang",lang);
        i.putExtra("path",path);
        startActivityForResult(i,0);
    }
    public void onRestaurantClick(View view) {
        Intent i = new Intent(this, CustomActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }
    public void onSosClick(View view) {
        Intent i = new Intent(this, SosActivity.class);
        i.putExtra("lang",lang);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
