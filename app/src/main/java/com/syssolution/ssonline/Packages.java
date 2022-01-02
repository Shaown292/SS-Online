package com.syssolution.ssonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.syssolution.ssonline.adapter.PackagesAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class Packages extends AppCompatActivity {

    ImageView back_btn;
    PackagesAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PackagesModel list[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);


        back_btn = findViewById(R.id.back_button);


        recyclerView = findViewById(R.id.recyclerView2);
        setSR();


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(Packages.this, Homepage.class);
                startActivity(intent7);
            }
        });


    }

    private void setSR() {


        list = new PackagesModel[]{

                new PackagesModel("SS Package-1", "600 TK Monthly Charge", "10Mbps"),
                new PackagesModel("SS Package-2", "800 TK Monthly Charge", "15Mbps"),
                new PackagesModel("SS Package-3", "1000 TK Monthly Charge", "20Mbps"),
                new PackagesModel("SS Package-4", "1500 TK Monthly Charge", "25Mbps"),
                new PackagesModel("SS Package-5", "2000 TK Monthly Charge", "30Mbps"),
                new PackagesModel("SS Package-6", "2200 TK Monthly Charge", "35Mbps"),
                new PackagesModel("SS Package-7", "2500 TK Monthly Charge", "40Mbps"),

        };
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PackagesAdapter(list, this);
        recyclerView.setAdapter(adapter);

        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(recyclerView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);

                } else {
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
                }


            }
        }, 0, 3000);

    }


}