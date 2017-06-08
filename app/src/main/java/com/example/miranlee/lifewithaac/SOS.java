package com.example.miranlee.lifewithaac;

/**
 * Created by hojingong on 2017. 6. 8..
 */

public class SOS {

    private String mname;
    private String mtel;

    public SOS(String mname, String mtel){
        this.mname = mname;
        this.mtel = mtel;
    }

    public String getMname(){
        return mname;
    }

    public void setMname(String mname){this.mname= mname;}

    public String getMtel(){
        return mtel;
    }
    public void setMtel(String mvoice){
        this.mtel=mvoice;
    }

}
