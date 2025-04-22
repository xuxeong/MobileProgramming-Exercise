package com.example.exercise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDrawEx extends View {
    public MyDrawEx(Context c){
        super(c);
    }
    public MyDrawEx(Context c, AttributeSet a){
        super(c, a);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawColor(Color.WHITE);
        for(int x=0; x<200; x+=5){
            canvas.drawLine(x, 0, 200-x, 100, paint);
        }
    }

}
