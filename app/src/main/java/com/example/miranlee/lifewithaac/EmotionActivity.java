package com.example.miranlee.lifewithaac;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sungd on 2017-05-28.
 */

public class EmotionActivity extends Activity implements TextToSpeech.OnInitListener,LocationListener{
    TextView tv;
    TextToSpeech tts;
    String nar = null;
    String emo = "";

    String lang;
    int type = -1;
    Button speak;

    int warning=0;    //8번 눌리면 메세지 전송 화나요& 불행해요
    Geocoder geoCoder;
    double lat;
    double lon;
    String add;
    SQLiteDatabase db;
    long starttime;
    long endtime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);
        setTitle("emotion");
        tts = new TextToSpeech(this, this);
        tv = (TextView)findViewById(R.id.see);
        speak = (Button)findViewById(R.id.speak);

        //
        //
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
        geoCoder = new Geocoder(this,Locale.KOREAN);
//

        //
        Intent i = getIntent();
        lang = i.getStringExtra("lang");
        if(lang.equals("korean")) {
            speak.setText("말하기");
            type = 0;
        }else if(lang.equals("english")) {
            speak.setText("Speak");
            type = 1;
        }
    }

    public void onangryClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("angry");
        //
        if(warning==0){
            starttime = System.currentTimeMillis();
            warning++;
        }else{
            endtime = System.currentTimeMillis();
            if(((endtime-starttime)/1000)>10){ //10초 초과 지났으면
                warning =0;
            }else{
                warning++;
                if(warning==8){
                    sns();
                }
            }
        }
        //
        if(type == 0) {
            emo = "화났어요";
        }else if(type == 1) {
            emo = "angry";
        }
        nar = emo;
        onInit(0);
    }
    public void onbashfulClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("bashful");
        if(type == 0) {
            emo = "부끄러워요";
        }else if(type == 1) {
            emo = "blushing";
        }
        nar = emo;
        onInit(0);
    }
    public void onghostClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("ghost");
        if(type == 0) {
            emo = "오싹해요";
        }else if(type == 1) {
            emo = "feeling creepy";
        }
        nar = emo;
        onInit(0);
    }
    public void onhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("happy");
        if(type == 0) {
            emo = "행복해요";
        }else if(type == 1) {
            emo = "happy";
        }
        nar = emo;
        onInit(0);
    }
    public void onunhappyClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unhappy");
        //
        if(warning==0){
            starttime = System.currentTimeMillis();
            warning++;
        }else{
            endtime = System.currentTimeMillis();
            if(((endtime-starttime)/1000)>10){ //10초 초과 지났으면
                warning =0;
            }else{
                warning++;
                if(warning==8){
                    sns();
                }
            }
        }
        //
        if(type == 0) {
            emo = "불행해요";
        }else if(type == 1) {
            emo = "not happy";
        }
        nar = emo;
        onInit(0);
    }
    public void onloveClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("love");
        if(type == 0) {
            emo = "좋아해요";
        } else if(type == 1) {
            emo = "loving you";
        }
        nar = emo;
        onInit(0);
    }
    public void onnumbClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("numb");
        if(type == 0) {
            emo = "망연자실해요";
        }else if(type == 1) {
            emo = "disappointed";
        }
        nar = emo;
        onInit(0);
    }
    public void onpleasedClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("pleased");
        if(type == 0) {
            emo = "즐거워요";
        }else if(type == 1) {
            emo = "pleased";
        }
        nar = emo;
        onInit(0);
    }
    public void onsadClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("sad");
        if(type == 0) {
            emo = "우울해요";
        } else if(type == 1) {
            emo = "sad";
        }
        nar = emo;
        onInit(0);
    }
    public void onshockClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("shock");
        if(type == 0) {
            emo = "충격이에요";
        } else if(type == 1) {
            emo = "shocked";
        }
        nar = emo;
        onInit(0);
    }
    public void onunsureClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("unsure");
        if(type == 0) {
            emo = "자신이없어요";
        }else if(type == 1) {
            emo = "not sure";
        }
        nar = emo;
        onInit(0);
    }
    public void onupsetClick(View view) {
        tv=(TextView)findViewById(R.id.see);
        tv.setText("upset");
        if(type == 0) {
            emo = "속상해요";
        }else if(type == 1) {
            emo = "upset";
        }
        nar = emo;
        onInit(0);
    }
    public String setString() {
        String s = emo;
        if(emo!="") {
            if(type == 0) {
                s = "저는 지금 " + s;
            }else if(type == 1) {
                s = "I am "+s;
            }
        }
        else
        {   if(type == 0) {
                s = "이미지를 선택하여 문장을 생성하세요.";
            }else if(type == 1) {
                s = "Touch image to create sentence.";
            }
        }
        return s;
    }

    public void onSpeakClick(View view){
        nar = setString();
            onInit(0);
    }

    @Override
    public void onInit(int i) {
        if(type == 1) {
            tts.setLanguage(Locale.ENGLISH);
        }
        if(type == 0) {
            tts.setLanguage(Locale.KOREA);
        }
        tv.setText(nar);
        tts.speak(nar,TextToSpeech.QUEUE_FLUSH, null);
    }

    public void sns(){
        try {
            //37.5407625,127.0793428
//                          List<Address> addresses = geoCoder.getFromLocation(lat,lon,1);
            List<Address> addresses = geoCoder.getFromLocation(37.5407625, 127.0793428, 1);
            //                         List<Address> addresses = geoCoder.getFromLocation(lat,lon,1);
            // List<Address> addresses = geoCoder.getFromLocation(37.5407625,127.0793428,1);

            StringBuilder sb = new StringBuilder();
            Address address = addresses.get(0);
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                sb.append(address.getAddressLine(i)).append("\n");
            }

            sb.append(address.getCountryName()).append(" ");//나라
            sb.append(address.getAdminArea()).append(" ");
            sb.append(address.getLocality()).append(" ");//시
            sb.append(address.getThoroughfare()).append(" ");   //동
            sb.append(address.getFeatureName()).append(" ");    // 번지

            add = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //리스트 첫번째에 있는사람
        String nnumber=null;
        WarningDB warningDB = new WarningDB(this);
        db = warningDB.getReadableDatabase();
        warningDB.onCreate(db);
        Cursor cursor2 = db.rawQuery("SELECT * FROM Warning",null);
        //int count = cursor.getCount();
        while(cursor2.moveToNext()){
           // String nname = cursor2.getString(0); //name
            nnumber = cursor2.getString(1);//number
            break;
        }
        cursor2.close();
        //
        if(nnumber==null){
            Toast.makeText(getApplicationContext(),"등록된 번호가 없습니다",Toast.LENGTH_SHORT).show();
        }else {
            String contents = "주소: " + add + "\n 도와주세요!";
            Messenger messenger = new Messenger(getApplicationContext());
            messenger.sendMessageTo(nnumber, contents);
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    public class Messenger {
        private Context mContext;
        public Messenger(Context mContext){
            this.mContext = mContext;
        }

        public void sendMessageTo(String phoneNum,String message){
            SmsManager smsmanager = SmsManager.getDefault();
            smsmanager.sendTextMessage(phoneNum,null,message,null,null);
            Toast.makeText(mContext,"전송되었습니다",Toast.LENGTH_SHORT).show();
        }
    }
}

