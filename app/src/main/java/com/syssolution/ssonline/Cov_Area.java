package com.syssolution.ssonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.syssolution.ssonline.adapter.RecyclerAdapter;

public class Cov_Area extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String[] area = {"Lalbag", "Dhanmondi", "Gulshan","Chowkbazar", "Wari", "Gendaria","Sutrapur","Azimpur", "Zinzira","Banani","New Market","Farmgate",
    "Islampur","Kotwali","Shahbagh","Hatirpool", "Ramna", "Paltan","Motijheel","Kamrangirchar","Kalabagan","Hazaribag","Bangshal", "Badda"};


    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cov_area);

        back_btn = findViewById(R.id.back_button);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, area) ;
        recyclerView.setAdapter(adapter);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(Cov_Area.this, Homepage.class);
                startActivity(intent7);
            }
        });


        }
    }



