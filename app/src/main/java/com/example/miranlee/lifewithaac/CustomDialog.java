package com.example.miranlee.lifewithaac;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;

/**
 * Created by hojingong on 2017. 6. 8..
 */

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);


    }
}
