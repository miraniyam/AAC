package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.jar.Manifest;

/**
 * Created by sungd on 2017-05-28.
 */

public class CustomPlusActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private static final int FROM_CAMERA = 1;
    private static final int FROM_ALBUM = 2;
    ImageView imageView;

    //record
    MediaRecorder recorder = new MediaRecorder();
    MediaPlayer mediaPlayer;
    TextToSpeech tts;

    Button startbtn;
    Button stopbtn;
    Button playbtn;

    String voiceStoragePath;

    public static SimpleDateFormat format;
    public static String date;
    static Random rnd = new Random();
    static final String AB="abcdefghijklmnopqrstuvwxyz";
   // Button backbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_custom_plus);
        setTitle("myAAC");
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(this,this);
        tts.setLanguage(Locale.KOREA);

        init();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){

        }
    }


    void init() {
        //사진가져오기 음성녹음
        // 두개 디비에 저장

        imageView = (ImageView)findViewById(R.id.showimg);
        Button camerabtn = (Button)findViewById(R.id.camerabtn);
        Button albumbtn = (Button)findViewById(R.id.albumbtn);


        //녹음기능 구현



        startbtn = (Button)findViewById(R.id.recordstartbtn);
        stopbtn = (Button)findViewById(R.id.recordstopbtn);
        playbtn = (Button)findViewById(R.id.recordplaybtn);

      //  backbtn = (Button)findViewById(R.id.btn_back);
        stopbtn.setEnabled(false);
        playbtn.setEnabled(false);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStart(view);
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStop(view);
            }
        });

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playLastStoredAudioMusic();
                mediaPlayerPlaying();
            }
        });

        //카메라 사진찍기
        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                intent.putExtra(MediaStore.EXTRA_OUTPUT,MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
                //이미지 자르기
                intent.putExtra("crop","true");
                intent.putExtra("aspectX",0);
                intent.putExtra("aspect",0);
                intent.putExtra("outputX",300);
                intent.putExtra("outputY",300);

                try{
                    intent.putExtra("return-data",true);
                    startActivityForResult(intent,FROM_CAMERA);

                }catch(ActivityNotFoundException e){

                }

            }
        });

        //앨범에서 가져오기
        albumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nintent = new Intent();
                nintent.setType("image/*");
                nintent.setAction(Intent.ACTION_GET_CONTENT);

                //이미지 자르기
                nintent.putExtra("crop","true");
                nintent.putExtra("aspectX",0);
                nintent.putExtra("aspect",0);
                nintent.putExtra("outputX",300);
                nintent.putExtra("outputY",300);

                try{
                    nintent.putExtra("return-data",true);
                    startActivityForResult(nintent,FROM_ALBUM);

                }catch(ActivityNotFoundException e){

                }
            }
        });

    }

    //

    public void onClickStart(View view) {
       // tts.speak("이 멘트가 끝나면 녹음이 시작됩니다.",TextToSpeech.QUEUE_FLUSH,null);
        try {
         /*   File sdir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "AAC");
            //File sdir = new File(getApplicationContext().getFilesDir(),"AAC");
            //boolean f = nfile.mkdirs();

            if(!sdir.exists()){
                if(!sdir.mkdirs()){
                    Toast.makeText(getApplicationContext(),"글렀어",Toast.LENGTH_SHORT).show();
                    return;
                }

            }
*/
            voiceStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File audioVoice = new File(voiceStoragePath+File.separator+"voice");
            if(!audioVoice.exists()){
                audioVoice.mkdir();
                if(!audioVoice.mkdir()){
                    Toast.makeText(getApplicationContext(),"글렀어",Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            voiceStoragePath = voiceStoragePath+File.separator+"voice/"+generateVoiceFilename(5)+".3gpp";
           // String filename = "hi";

            Toast.makeText(getApplicationContext(),voiceStoragePath,Toast.LENGTH_SHORT).show();

         //   Toast.makeText(getApplicationContext(),"file:"+filename,Toast.LENGTH_SHORT).show();

            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(voiceStoragePath);

            //storagepath = sdir.getAbsolutePath().toString()+"/"+filename+".3gp";

            recorder.prepare();
          //  while(tts.isSpeaking()) {
                // 안내 음성이 다 끝나고 나야 저장할 것이다!
          //  }
            Toast.makeText(getApplicationContext(),"여기까지 오니.?1",Toast.LENGTH_SHORT).show();

            recorder.start();
            Toast.makeText(getApplicationContext(),"여기까지 오니.?2",Toast.LENGTH_SHORT).show();

            startbtn.setEnabled(false);
            //backbtn.setEnabled(false);

            stopbtn.setEnabled(true);
            Toast.makeText(getApplicationContext(),"여기까지 오니.?",Toast.LENGTH_SHORT).show();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickStop(View view) {
        recorder.stop();
        recorder.release();
        tts.speak("녹음이 완료되었습니다",TextToSpeech.QUEUE_FLUSH,null);
        startbtn.setEnabled(true);
        stopbtn.setEnabled(false);
        playbtn.setEnabled(true);
      //  backbtn.setEnabled(true);
    }

    ///
    private void playLastStoredAudioMusic(){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(voiceStoragePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        startbtn.setEnabled(true);
        playbtn.setEnabled(false);
    }

    private void mediaPlayerPlaying(){
        if(!mediaPlayer.isPlaying()){
            stopAudioPlay();
        }
    }

    private void stopAudioPlay(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    /*
    private String generateVoiceFilename(int len){ 
        StringBuilder sb = new StringBuilder(len);
        //StringBuilder sb = new StringBuilder(len); 
        int i=0;
        for(i=0;i<len;i++){ 
            sb.append(AB.charAt(rnd.nextInt(AB.length()))); 
        } 
        return sb.toString(); 
    }

    */
    private String generateVoiceFilename(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i=0;i<len;i++){
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
    ///

    @Override
    public void onInit(int i) {

    }

    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == FROM_CAMERA){
            Bundle extras = data.getExtras();
            if(extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imageView.setImageBitmap(photo);
            }
        }

        if(requestCode == FROM_ALBUM){
            Bundle extras = data.getExtras();
            if(extras != null){
                Bitmap photo = extras.getParcelable("data");
                imageView.setImageBitmap(photo);
            }
        }
    }

}
