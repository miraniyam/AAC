package com.example.miranlee.lifewithaac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hojingong on 2017. 6. 7..
 */

public class MyAACDB extends SQLiteOpenHelper{
    public static final String DB_NAME = "MyAAC.db";
    public static final int DB_VERSION=1;

    public MyAACDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE if not exists MyAAC(voice TEXT, img BLOB, txt TEXT);");
    }

    public void delete(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM MyAAC;");
        db.close();
    }

}
