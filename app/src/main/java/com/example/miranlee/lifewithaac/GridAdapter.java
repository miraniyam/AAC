package com.example.miranlee.lifewithaac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hojingong on 2017. 6. 5..
 */

public class GridAdapter extends BaseAdapter{
    private Context context;
    ArrayList<AAC> aac = new ArrayList<>();
    boolean visible=false;
    //private final int[] mimg;

    public GridAdapter(Context context,ArrayList<AAC> aac){
        this.context = context;
        this.aac = aac;
    }

    @Override
    public int getCount() {
        //return mimg.length;
        return aac.size();
    }

    @Override
    public Object getItem(int i) {
        return aac.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.grid_item,null);
        }
        final TextView tv = (TextView)view.findViewById(R.id.aactxt);
        final ImageView img = (ImageView)view.findViewById(R.id.img);

        AAC AAC  = aac.get(position);
        final int pos =position;

        //tv.setVisibility(TextView.VISIBLE);
        tv.setText(AAC.getMtext());
        img.setImageBitmap(AAC.getMphoto());

        return view;

    }

    public void setVisible(Boolean isVisible){
        visible = isVisible;
        notifyDataSetChanged();
    }

    void addAAC(AAC one){
        aac.add(one);
        this.notifyDataSetChanged();
    }

    void ADDAAC(AAC one){
        aac.add(one);
   //     notifyDataSetChanged();
    }
}
