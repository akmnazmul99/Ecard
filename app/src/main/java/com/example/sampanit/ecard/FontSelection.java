package com.example.sampanit.ecard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;


public class FontSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_selection);

        RadioButton rb_txt_1 = (RadioButton) findViewById(R.id.font_1);
        Typeface font_1 = Typeface.createFromAsset(getAssets(), "fonts/angelina.TTF");
        rb_txt_1.setTypeface(font_1);

        RadioButton rb_txt_2 = (RadioButton) findViewById(R.id.font_2);
        Typeface font_2 = Typeface.createFromAsset(getAssets(), "fonts/Army.ttf");
        rb_txt_2.setTypeface(font_2);

        RadioButton rb_txt_3 = (RadioButton) findViewById(R.id.font_3);
        Typeface font_3 = Typeface.createFromAsset(getAssets(), "fonts/Bellerose.ttf");
        rb_txt_3.setTypeface(font_3);

        RadioButton rb_txt_4 = (RadioButton) findViewById(R.id.font_4);
        Typeface font_4 = Typeface.createFromAsset(getAssets(), "fonts/CLOSCP__.TTF");
        rb_txt_4.setTypeface(font_4);

        RadioButton rb_txt_5 = (RadioButton) findViewById(R.id.font_5);
        Typeface font_5 = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");
        rb_txt_5.setTypeface(font_5);

        RadioButton rb_txt_6 = (RadioButton) findViewById(R.id.font_6);
        Typeface font_6 = Typeface.createFromAsset(getAssets(), "fonts/FortuneCity.ttf");
        rb_txt_6.setTypeface(font_6);

        RadioButton rb_txt_7 = (RadioButton) findViewById(R.id.font_7);
        Typeface font_7 = Typeface.createFromAsset(getAssets(), "fonts/DroidSerif-Regular.ttf");
        rb_txt_7.setTypeface(font_7);

        RadioButton rb_txt_8 = (RadioButton) findViewById(R.id.font_8);
        Typeface font_8 = Typeface.createFromAsset(getAssets(), "fonts/DroidSerif-Bold.ttf");
        rb_txt_8.setTypeface(font_8);

        RadioButton rb_txt_9 = (RadioButton) findViewById(R.id.font_9);
        Typeface font_9 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        rb_txt_9.setTypeface(font_9);

        RadioButton rb_txt_10 = (RadioButton) findViewById(R.id.font_10);
        Typeface font_10 = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.otf");
        rb_txt_10.setTypeface(font_10);

        RadioButton rb_txt_11 = (RadioButton) findViewById(R.id.font_11);
        Typeface font_11 = Typeface.createFromAsset(getAssets(), "fonts/Sansation_Bold.ttf");
        rb_txt_11.setTypeface(font_11);

        RadioButton rb_txt_12 = (RadioButton) findViewById(R.id.font_12);
        Typeface font_12 = Typeface.createFromAsset(getAssets(), "fonts/Walkway Black.ttf");
        rb_txt_12.setTypeface(font_12);

        RadioButton rb_txt_13 = (RadioButton) findViewById(R.id.font_13);
        Typeface font_13 = Typeface.createFromAsset(getAssets(), "fonts/Fun Raiser.ttf");
        rb_txt_13.setTypeface(font_13);

        RadioButton rb_txt_14 = (RadioButton) findViewById(R.id.font_14);
        Typeface font_14 = Typeface.createFromAsset(getAssets(), "fonts/smart watch.ttf");
        rb_txt_14.setTypeface(font_14);
    }
}
