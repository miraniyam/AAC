package com.example.miranlee.lifewithaac;

import android.graphics.Bitmap;

/**
 * Created by hojingong on 2017. 5. 31..
 */

public class AAC {

    //DB에서 가져온 데이터 이걸로 통해 보여주기
    private String mtext;
    private String mvoice;
    private Bitmap mphoto;

    public AAC(String mtext, String mvoice, Bitmap mphoto){
        this.mtext = mtext;
        this.mvoice = mvoice;
        this.mphoto = mphoto;
    }

    public String getMtext(){
        return mtext;
    }

    public void setMtext(String mtext){
        this.mtext = mtext;
    }

    public String getMvoice(){
        return mvoice;
    }
    public void setMvoice(String mvoice){
        this.mvoice=mvoice;
    }

    public Bitmap getMphoto(){
        return mphoto;
    }
    public void setMphoto(Bitmap mphoto){
        this.mphoto = mphoto;
    }

}