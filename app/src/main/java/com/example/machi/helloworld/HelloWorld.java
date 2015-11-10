package com.example.machi.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;


public class HelloWorld extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LinearLayout myLayout = new LinearLayout(this);
        setContentView(myLayout);
        HelloView myView = new HelloView(this);
        myView.setOnClickListener(this);
        myLayout.addView(myView);
    }

    @Override
    public void onClick(View v) {
        HelloView myView = (HelloView)v;
        myView.ChangeColor();
    }
}