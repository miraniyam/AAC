package com.example.miranlee.lifewithaac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by hojingong on 2017. 6. 5..
 */

public class GridAdapter extends BaseAdapter{
    private Context mcontext;
    private final int[] mimg;

    public GridAdapter(Context context,int[] mimg){
        mcontext = context;
        this.mimg = mimg;
    }

    @Override
    public int getCount() {
        //return mimg.length;
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null){
            grid = new View(mcontext);
            grid = inflater.inflate(R.layout.grid_item,null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img);
            imageView.setImageResource(mimg[i]);

        }else{
            grid = (View)view;
        }
        return grid;
    }
}
