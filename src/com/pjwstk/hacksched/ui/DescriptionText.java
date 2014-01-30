package com.pjwstk.hacksched.ui;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class DescriptionText extends TextView{

	public DescriptionText(Context context) {
        super(context);
        style(context);
    }

    public DescriptionText(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context);
    }

    public DescriptionText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        style(context);
    }

    private void style(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),"fonts/roboto_light.ttf");
        setTypeface(tf);
    }


}