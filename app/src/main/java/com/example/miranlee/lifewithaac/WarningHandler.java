package com.example.miranlee.lifewithaac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hojingong on 2017. 6. 7..
 */

public class WarningHandler {
    private WarningDB myWarningDB;
    private SQLiteDatabase db;

    public WarningHandler(Context context){
        this.myWarningDB = new WarningDB(context);
    }

    public void close(){db.close();}

    public long insert(String name, String number){
        db = myWarningDB.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("name",name);
        val.put("number",number);

        if(db.insert("Warning",null,val)<0){
            db.close();
            return 0;
        }else{
            db.close();
            return 1;   //성공
        }
    }

    public long check(String cname, String cnumber){
            int check = 0;
            String gets = null;
            db = myWarningDB.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Warning WHERE number = \'"+cnumber+"\'", null);

            while (cursor.moveToNext()) {
                gets = cursor.getString(1);
                if(cnumber.equals(gets)){
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

}
