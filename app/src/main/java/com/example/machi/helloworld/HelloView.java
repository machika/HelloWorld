package com.example.machi.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import android.view.Display;
import android.widget.LinearLayout;

import java.util.GregorianCalendar;
import java.util.Random;

public class HelloView extends View {

    private float myX, myY;
    private int myRadius, myRed, myGreen, myBlue;
    private int myColor;
    private boolean bInit;

    public HelloView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        bInit = false;
    }

    public void ChangeColor() {
        Random rand = new Random();
        rand.setSeed(GregorianCalendar.getInstance().getTimeInMillis());
        myRed = rand.nextInt() % 255;
        myGreen = rand.nextInt() % 255;
        myBlue = rand.nextInt() % 255;
        myColor = Color.rgb(myRed, myGreen, myBlue);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!bInit) {
            myX = (getRight() - getLeft()) / (float)2.0;
            myY = (getBottom() - getTop()) / (float)2.0;
            myRadius = (int)((myY > myX) ? myY / (float)3 : myX / (float)3);
            myRed = 0;
            myGreen = 0;
            myBlue = 255;
            myColor = Color.rgb(myRed, myGreen, myBlue);
            bInit = true;
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(myX, myY, myRadius, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(myColor);
        canvas.drawCircle(myX, myY, myRadius, paint);

        paint.setColor(Color.BLACK);
        canvas.drawLine(myX, myY+myRadius, myX, myY*2, paint);
    }

}
