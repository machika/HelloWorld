package com.example.machi.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;


public class HelloWorld extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LinearLayout myLayout = new LinearLayout(this);
        LinearLayout secondLayout = new LinearLayout(this);
        myLayout.addView(new HelloView(this));
        secondLayout.addView(new HelloView(this));
        myLayout.addView(secondLayout);
        setContentView(myLayout);
    }
}