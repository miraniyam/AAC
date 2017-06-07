package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sungd on 2017-05-28.
 */

public class CustomActivity extends Activity{
GridView gridView;
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

        final List<String> list = new ArrayList<String>();
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);

        gridView.setAdapter(gridViewArrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //추가ㅏ화면으로 넘어가기
                Intent intent = new Intent(getApplicationContext(), CustomPlusActivity.class);
                startActivity(intent);


                list.add(list.size(),"what?");
                gridViewArrayAdapter.notifyDataSetChanged();

                String addedItemText = list.get(list.size()-1);

                Toast.makeText(getApplicationContext(),"AAC added"+addedItemText,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
