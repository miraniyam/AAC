package com.example.miranlee.lifewithaac;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by miran lee on 2017-05-24.
 */

public class ClothActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_cloth);
        super.onCreate(savedInstanceState);
        setTitle("옷가게");
    }
}
