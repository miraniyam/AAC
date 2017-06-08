package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sungd on 2017-05-28.
 */

public class SosActivity extends Activity{
    Button addbutton;
    ListView listView;
    ListviewAdapter adapter;
    String name=null;
    String number=null;

    WarningDB warningDB;
    SQLiteDatabase db;

    //dialog
    String selectname=null;
    String selectnumber=null;
    ImageButton callbtn;
    ImageButton snsbtn;

    CustomDialog customDialog;


    ArrayList<SOS> sos = new ArrayList<SOS>();

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sos);
        setTitle("sos");
        super.onCreate(savedInstanceState);

        init();
    }

    //시간되면
    //위치정보 받아와서 메세지에 주소 같이 첨부
    //등록한 전화번호 삭제
    //남은 경고는 조장님 부정적인 감정 여러번 누르면 메세지 보내는거하기~

    void init(){

        listView = (ListView)findViewById(R.id.warninglist);
        adapter = new ListviewAdapter(this,sos);
        listView.setAdapter(adapter);


        //오래누르면 삭제되게=>산협프 프로젝트 찾아보기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //터치하면 전화 or 메세지 보내는 dialog창 뜨게

                SOS item =(SOS)adapter.getItem(i);
                selectname = item.getMname();
                selectnumber= item.getMtel();
                customDialog = new CustomDialog(SosActivity.this);
                customDialog.show();
                ///다이얼로그 안에있는 버튼들
                callbtn = (ImageButton)customDialog.findViewById(R.id.call);
                snsbtn = (ImageButton)customDialog.findViewById(R.id.sns);

                callbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),selectnumber,Toast.LENGTH_SHORT).show();
                        //전화걸기 구현
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+selectnumber));
                        startActivity(callIntent);
                    }
                });

                snsbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),selectname,Toast.LENGTH_SHORT).show();
                        //메세지 보내기 기능 구현
                        /////+위치정보 전송하기//시간되면..
                        String contents = "제가 지금 위험해요!";
                        Messenger messenger = new Messenger(getApplicationContext());
                        messenger.sendMessageTo(selectnumber,contents);
                    }
                });
            }
        });


        addbutton = (Button)findViewById(R.id.addnumber);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent,0);
            }
        });

        showListview();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            Cursor cursor = getContentResolver().query(data.getData(),new String[]{
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},null,null,null);
            cursor.moveToFirst();
            name = cursor.getString(0);
            number = cursor.getString(1);
            //가져온거 디비에 저장
            final WarningHandler dbhandler = new WarningHandler(getApplicationContext());
            //만약 있는번호면 있다고 알림
            ///
            long check2 = dbhandler.check(name,number); //이 아이디가 댓글 달았는지 확인
            if (check2 == 1) {
                //이미등록
                Toast.makeText(this, "이미 등록된 전화번호입니다.", Toast.LENGTH_SHORT).show();
            } else {
                long check1 = dbhandler.insert(name,number);
                if(check1 == 0){
                    Toast.makeText(this, "오류", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "등록완료!", Toast.LENGTH_SHORT).show();
                }
            }
            ///
            cursor.close();
            showListview();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void showListview(){
        //리스트 갱신
        sos.clear();
        warningDB = new WarningDB(this);
        db = warningDB.getReadableDatabase();
        warningDB.onCreate(db);
        Cursor cursor2 = db.rawQuery("SELECT * FROM Warning",null);
        //int count = cursor.getCount();

        while(cursor2.moveToNext()){
            String nname = cursor2.getString(0); //name
            String nnumber = cursor2.getString(1);//number

            adapter.ADDSOS(new SOS(nname,nnumber));
        }
        cursor2.close();

        adapter.notifyDataSetChanged();

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
