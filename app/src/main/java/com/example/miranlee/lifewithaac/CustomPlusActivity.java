package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
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
    //내용
    String txt=null;
    EditText editText;
    long check=0;
    //image
    private static final int FROM_ALBUM = 1;
    private static final int FROM_CAMERA = 2;
    ImageView imageView;
    Bitmap photo;

    //record
    MediaRecorder recorder = new MediaRecorder();
    MediaPlayer mediaPlayer;
    TextToSpeech tts;

    Button startbtn;
    Button stopbtn;
    Button playbtn;

    String voiceStoragePath;

    //추가
    Button addbtn;
    int result=0;

    static Random rnd = new Random();
    static final String AB="abcdefghijklmnopqrstuvwxyz";

    int type = -1;
    TextView tvSelect;
    TextView tvText;
    TextView tvRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_custom_plus);
        setTitle("myAAC");
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(this,this);
        tts.setLanguage(Locale.KOREA);

        tvSelect = (TextView)findViewById(R.id.tvSelect);
        tvText = (TextView)findViewById(R.id.tvText);
        tvRecord = (TextView)findViewById(R.id.tvRecord);

        Intent i = getIntent();
        type = i.getIntExtra("type",-1);
        if(type == 0) {
            tvSelect.setText("이미지를 선택하세요");
            tvText.setText("텍스트");
            tvRecord.setText("녹음");
        }else if(type == 1) {
            tvSelect.setText("Select Image");
            tvText.setText("TEXT");
            tvRecord.setText("RECORD");
        }

        init();

    }

    void init() {
        //추가
        addbtn = (Button)findViewById(R.id.addbtn);

        //내용기입
        editText = (EditText)findViewById(R.id.gettxt);

        //녹음
        startbtn = (Button)findViewById(R.id.recordstartbtn);
        stopbtn = (Button)findViewById(R.id.recordstopbtn);
        playbtn = (Button)findViewById(R.id.recordplaybtn);
        if(type == 0) {
            startbtn.setText("시작");
            stopbtn.setText("멈춤");
            playbtn.setText("재생");
        }else if(type == 1) {
            startbtn.setText("START");
            stopbtn.setText("STOP");
            playbtn.setText("PLAY");
        }

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

        //사진가져오기
        imageView = (ImageView)findViewById(R.id.showimg);
        Button camerabtn = (Button)findViewById(R.id.camerabtn);
        Button albumbtn = (Button)findViewById(R.id.albumbtn);
        if(type == 0) {
            camerabtn.setText("카메라");
            albumbtn.setText("갤러리");
        }else if(type == 1) {
            camerabtn.setText("CAMERA");
            albumbtn.setText("ALBUM");
        }

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
                intent.putExtra("outputX",100);
                intent.putExtra("outputY",100);

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
                Intent nintent = new Intent(Intent.ACTION_PICK);
                nintent.setType(MediaStore.Images.Media.CONTENT_TYPE);

                //이미지 자르기
                nintent.putExtra("crop","true");
                nintent.putExtra("aspectX",0);
                nintent.putExtra("aspect",0);
                nintent.putExtra("outputX",100);
                nintent.putExtra("outputY",100);

                try{
                    nintent.putExtra("return-data",true);
                    startActivityForResult(nintent,FROM_ALBUM);

                }catch(ActivityNotFoundException e){

                }
            }
        });

        //디비에 추가

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean con =false;

                //여기에 디비에 넣는거 하고
                txt=editText.getText().toString();
                final MyAACHandler dbHandler = new MyAACHandler(getApplicationContext());
                check = dbHandler.insert(voiceStoragePath,getBytes(photo),txt);    //이거 안되면 이미지도 경로저장도전..
                //디비에 넣기 성공하면
                if(check==1){
                    Toast.makeText(getApplicationContext(), "추가했습니다!", Toast.LENGTH_SHORT).show();
                    con = true;

                }
                    //이걸로 새로운거 만들라고 보내기
                    Intent intent = new Intent();
                    result = 1;
                    intent.putExtra("result", result);

                if(con)
                    setResult(RESULT_OK,intent);    //된것
                else
                    setResult(RESULT_CANCELED,intent);//실패

                finish();
                //
            }
        });


    }

    public void onClickStart(View view) {
        if(type == 0) {
            tts.speak("이 멘트가 끝나면 녹음이 시작됩니다.", TextToSpeech.QUEUE_FLUSH, null);
        }else if(type == 1) {
            tts.speak("Recording will start when this is stop",TextToSpeech.QUEUE_FLUSH,null);
        }
        try {
            voiceStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File audioVoice = new File(voiceStoragePath+File.separator+"voice");
            if(!audioVoice.exists()){
                audioVoice.mkdir();
                if(!audioVoice.mkdir()){
                    if(type == 0) {
                        Toast.makeText(getApplicationContext(), "저장에 실패했습니다", Toast.LENGTH_SHORT).show();
                    }else if(type == 1) {
                        Toast.makeText(getApplicationContext(), "Failed to save", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
            }

            voiceStoragePath = voiceStoragePath+File.separator+"voice/"+generateVoiceFilename(5)+".3gpp";

           // Toast.makeText(getApplicationContext(),voiceStoragePath,Toast.LENGTH_SHORT).show();

            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(voiceStoragePath);

            recorder.prepare();
            while(tts.isSpeaking()) {
                // 안내 음성이 다 끝나고 나야 저장할 것이다!
            }
            recorder.start();

            startbtn.setEnabled(false);
            stopbtn.setEnabled(true);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickStop(View view) {
        recorder.stop();
        recorder.release();
        if(type == 0) {
            tts.speak("녹음이 완료되었습니다", TextToSpeech.QUEUE_FLUSH, null);
        }else if(type == 1) {
            tts.speak("Recording is done",TextToSpeech.QUEUE_FLUSH,null);
        }
        startbtn.setEnabled(true);
        stopbtn.setEnabled(false);
        playbtn.setEnabled(true);
      //  backbtn.setEnabled(true);
    }

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

    private String generateVoiceFilename(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i=0;i<len;i++){
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @Override
    public void onInit(int i) {

    }

    //카메라..
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == FROM_CAMERA){
            Bundle extras = data.getExtras();
            if(extras != null) {
                photo = extras.getParcelable("data");
                imageView.setImageBitmap(photo);
            }
        }

        if(requestCode == FROM_ALBUM){
            Bundle extras = data.getExtras();
            if(extras != null){
                photo = extras.getParcelable("data");
                imageView.setImageBitmap(photo);
            }
        }
    }

        // 비트맵이미지를 바이트어레이로 바꿔서 저장
        public byte[] getBytes(Bitmap bitmap) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
            return stream.toByteArray();
        }



}
