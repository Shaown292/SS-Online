package com.syssolution.ssonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.syssolution.ssonline.live_tv.Browser;
import com.syssolution.ssonline.live_tv.LiveTv2;
import com.syssolution.ssonline.live_tv.LiveTv3;
import com.syssolution.ssonline.live_tv.LiveTv4;
import com.syssolution.ssonline.live_tv.LiveTv5;
import com.syssolution.ssonline.live_tv.LiveTv6;

public class Live_tv extends AppCompatActivity implements View.OnClickListener {





    LinearLayout LL1, LL2, LL3, LL4, LL5, LL6;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tv);

        LL1 = findViewById(R.id.LT1);
        LL2 = findViewById(R.id.LT2);
        LL3 = findViewById(R.id.LT3);
        LL4 = findViewById(R.id.LT4);
        LL5 = findViewById(R.id.LT5);
        LL6 = findViewById(R.id.LT6);
        back_btn = findViewById(R.id.back_button);

        LL1.setOnClickListener(this);
        LL2.setOnClickListener(this);
        LL3.setOnClickListener(this);
        LL4.setOnClickListener(this);
        LL5.setOnClickListener(this);
        LL6.setOnClickListener(this);
        back_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LT1:
                Intent intent = new Intent(Live_tv.this, Browser.class);
                startActivity(intent);
                break;

            case R.id.LT2:
                Intent intent2 = new Intent(Live_tv.this, LiveTv2.class);
                startActivity(intent2);
                break;
            case R.id.LT3:
                Intent intent3 = new Intent(Live_tv.this, LiveTv3.class);
                startActivity(intent3);
                break;
            case R.id.LT4:
                Intent intent4 = new Intent(Live_tv.this, LiveTv4.class);
                startActivity(intent4);
                break;
            case R.id.LT5:
                Intent intent5= new Intent(Live_tv.this, LiveTv5.class);
                startActivity(intent5);
                break;
            case R.id.LT6:
                Intent intent6 = new Intent(Live_tv.this, LiveTv6.class);
                startActivity(intent6);
                break;
            case R.id.back_button:
                Intent intent7 = new Intent(Live_tv.this, Homepage.class);
                startActivity(intent7);
                break;
        }

    }
}