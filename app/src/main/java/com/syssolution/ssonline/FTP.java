package com.syssolution.ssonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.syssolution.ssonline.ftp.Newspaper;

public class FTP extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ftp1, ftp2, ftp3,ftp4,ftp5, newspaper;
     ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftp);

        ftp1 = findViewById(R.id.LT11);
        ftp2 = findViewById(R.id.LT21);
        ftp3 = findViewById(R.id.LT31);
        ftp4 = findViewById(R.id.LT41);
        ftp5 = findViewById(R.id.LT51);
        newspaper = findViewById(R.id.LT61);

        back_btn = findViewById(R.id.back_button);

        ftp1.setOnClickListener(this);
        ftp2.setOnClickListener(this);
        ftp3.setOnClickListener(this);
        ftp4.setOnClickListener(this);
        ftp5.setOnClickListener(this);
        newspaper.setOnClickListener(this);
        back_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.LT11:
                Intent intent = new Intent(FTP.this, com.syssolution.ssonline.ftp.ftp1.class);
                startActivity(intent);
                break;
            case R.id.LT21:
                Intent intent2 = new Intent(FTP.this, com.syssolution.ssonline.ftp.ftp2.class);
                startActivity(intent2);
                break;
            case R.id.LT31:
                Intent intent3 = new Intent(FTP.this, com.syssolution.ssonline.ftp.ftp3.class);
                startActivity(intent3);
                break;
            case R.id.LT41:
                Intent intent4 = new Intent(FTP.this, com.syssolution.ssonline.ftp.ftp4.class);
                startActivity(intent4);
                break;
            case R.id.LT51:
                Intent intent5 = new Intent(FTP.this, com.syssolution.ssonline.ftp.ftp5.class);
                startActivity(intent5);
                break;
            case R.id.LT61:
                Intent intent6 = new Intent(FTP.this, Newspaper.class);
                startActivity(intent6);
                break;
            case R.id.back_button:
                Intent intent7 = new Intent(FTP.this, Homepage.class);
                startActivity(intent7);
                break;

        }
    }
}