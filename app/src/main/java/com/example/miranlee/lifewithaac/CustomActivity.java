package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungd on 2017-05-28.
 */

public class CustomActivity extends Activity{

    GridView gridView;
    MediaPlayer mediaPlayer;
    MyAACDB myAACDB;
    SQLiteDatabase db;

    GridAdapter adapter;
    //final List<String> list = new ArrayList<String>();
    //final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
    //ArrayList<Bitmap> photoArr = new ArrayList<Bitmap>();
    //ArrayList<String>textArr= new ArrayList<String>();
    //ArrayList<String>voiceArr=new ArrayList<String>();

    ArrayList<AAC> aac = new ArrayList<AAC>();


    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_custom);
        setTitle("myAAC");
        super.onCreate(savedInstanceState);


        //리스트로.. 이미지나오게..?

        //여기에서 디비 열어서 아이템하나씩 array에 추가 & 보여주기 터치하면 그거 음성나오는건 어케할까
        //커스텀 리스트뷰 성공하고
        //디비에 있는 사진이랑 음성 불러오기~ //음성은 터치시에 나오게!
        init();

    }

    void init(){
        gridView = (GridView)findViewById(R.id.myAACgrid);
        Button btn = (Button)findViewById(R.id.cutomplus);
        adapter = new GridAdapter(this,aac);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AAC item = (AAC)adapter.getItem(pos);

                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(item.getMvoice());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //추가ㅏ화면으로 넘어가기
                Intent intent = new Intent(getApplicationContext(), CustomPlusActivity.class);
                startActivityForResult(intent,1);//requestcode==1

            }
        });

        showList();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Toast.makeText(getApplicationContext(),"AAC added",Toast.LENGTH_SHORT).show();
            //
            if(resultCode==RESULT_OK){ //넣기 성공
                showList(); //목록보여주기
            }
        }
    }

    void showList(){
        //리스트 갱신
        aac.clear();
        myAACDB = new MyAACDB(this);
        db = myAACDB.getReadableDatabase();
        myAACDB.onCreate(db);
        final MyAACHandler dbhandler = new MyAACHandler(getApplicationContext());
        Cursor cursor = db.rawQuery("SELECT * FROM MyAAC",null);
        int count = cursor.getCount();

        while(cursor.moveToNext()){
            String voice = cursor.getString(0); //voice
            byte[] image = cursor.getBlob(1);//image
            String textt = cursor.getString(2);//text

           // photoArr.add(getImage(image));
           // textArr.add(textt);
           // voiceArr.add(voice);

            adapter.ADDAAC(new AAC(textt,voice,getImage(image)));
        }
        cursor.close();
       // gridViewArrayAdapter.notifyDataSetChanged();
//        reviewAdapter.notifyDataSetChanged();

        //
        //imageView.setImageBitmap(getImage(image));
        adapter.notifyDataSetChanged();

    }

//바이트어레이를 비트맵으로
    public static Bitmap getImage(byte[] image){
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }

    //온클릭 달아서 누르면 소리나오게
    //경로 가져와서 하기...
    //play함수 응용
}
