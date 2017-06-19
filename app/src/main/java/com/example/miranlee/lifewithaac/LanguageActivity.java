package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by sungd on 2017-05-28.
 */

public class LanguageActivity extends Activity {
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        super.onBackPressed();
    }

    String lang = null;
    String path = null;
    Button korean, english;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        setTitle("language");

        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        path = i.getStringExtra("path");

        korean = (Button)findViewById(R.id.korean);
        english = (Button)findViewById(R.id.english);

        if(lang.equals("korean")) {
            korean.setClickable(false);
            korean.setEnabled(false);
        }
        if(lang.equals("english")) {
            english.setClickable(false);
            english.setEnabled(false);
        }
    }

    public void onClickKorean(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(LanguageActivity.this);
        alert.setMessage("사용 언어를 한국어로 변환하시겠습니까?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                File file = new File(path);
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
                startActivity(new Intent(LanguageActivity.this, MainActivity.class));
                finish();
            }
        }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog a = alert.create();
        a.show();
    }

    public void onClickEnglish(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(LanguageActivity.this);
        alert.setMessage("Do you want to change your language to English?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                File file = new File(path);
                FileWriter fw = null;
                BufferedWriter buf = null;
                try {
                    fw = new FileWriter(file);
                    buf = new BufferedWriter(fw);
                    buf.write("english");
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
                startActivity(new Intent(LanguageActivity.this, MainActivity.class));
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog a = alert.create();
        a.show();
    }
}
