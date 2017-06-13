package com.example.miranlee.lifewithaac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.sql.Blob;

/**
 * Created by hojingong on 2017. 6. 7..
 */

public class MyAACHandler {
    private MyAACDB myAACDB;
    private SQLiteDatabase db;

    public MyAACHandler(Context context){
        this.myAACDB = new MyAACDB(context);
    }

    public void close(){
        db.close();
    }

    public long insert(String voice, byte[] image, String txt){
        db = myAACDB.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("voice",voice);
        val.put("img",image);
        val.put("txt",txt);
        long conc = db.insert("MyAAC",null,val);
        if(conc<0){
           db.close();
            return 0;   //실패
        }else {
            db.close();
            return 1;   //성공
        }
    }

    public void show() {

        String gets = null;
        byte[] image = null;
        db = myAACDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MyAAC;", null);

        while (cursor.moveToNext()) {
            gets = cursor.getString(1);
            image = cursor.getBlob(1);

        }
    }

    public void delete(){
        db = myAACDB.getWritableDatabase();
        //삭제
        db.rawQuery("DELETE FROM MyAAC;", null);

    }


}

/*

    public long check(String moviename) {
        int check = 0;
        String gets = null;
        db = mLikedb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LikeMovie;", null);

        while (cursor.moveToNext()) {
            gets = cursor.getString(1);
            if(moviename.equals(gets)){
                check=1;
            }
        }
        if(check == 0) {
            //없다
            return 0;
        }else {
            //있다
            return 1;
        }
    }


    public void delete(){
        db = mLikedb.getWritableDatabase();
        //삭제
        db.rawQuery("DELETE FROM LOGIN;", null);

    }
}

 */