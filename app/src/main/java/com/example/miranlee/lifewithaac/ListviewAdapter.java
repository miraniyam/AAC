package com.example.miranlee.lifewithaac;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by hojingong on 2017. 6. 8..
 */

public class ListviewAdapter extends BaseAdapter {
    Context context;
    ArrayList<SOS> sos = new ArrayList<>();

    public ListviewAdapter(Context context, ArrayList<SOS> sos){
        this.context= context;
        this.sos=sos;
    }
    @Override
    public int getCount() {
        return sos.size();
    }

    @Override
    public Object getItem(int i) {
        return sos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
        }
        final TextView txtname = (TextView)view.findViewById(R.id.sosname);
        final TextView txtnumber = (TextView)view.findViewById(R.id.sosnumber);

        SOS SOS = sos.get(i);

        txtname.setText(SOS.getMname());
        txtnumber.setText(SOS.getMtel());

        return view;
    }

    void ADDSOS(SOS one){
        sos.add(one);
    }
}
