package com.syssolution.ssonline;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Guide extends AppCompatActivity {
    ImageView back_btn;
    TextView textView, textView2, textView3, textView4, textView5;
    LinearLayout layout , layout2,layout3,layout4,layout5;
    CardView cardView, cardView2,cardView3,cardView4, cardView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        back_btn = findViewById(R.id.back_button);

        textView = findViewById(R.id.whats_router);
        layout = findViewById(R.id.linearLayout);
        cardView = findViewById(R.id.elvMobile);

        textView2 = findViewById(R.id.better_speed);
        layout2 = findViewById(R.id.linearLayout2);
        cardView2 = findViewById(R.id.elvMobile2);

        textView3 = findViewById(R.id.tp_link);
        layout3 = findViewById(R.id.linearLayout3);
        cardView3 = findViewById(R.id.elvMobile3);

        textView4 = findViewById(R.id.tenda);
        layout4 = findViewById(R.id.linearLayout4);
        cardView4 = findViewById(R.id.elvMobile4);


        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout4.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);




        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this, Homepage.class);
                startActivity(intent);
            }
        });


    }

    public void card1(View view) {
        int a =(textView.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        textView.setVisibility(a);
    }

    public void card2(View view) {
        int a =(textView2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        textView2.setVisibility(a);
    }


    public void card3(View view) {
        int a =(textView3.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        textView3.setVisibility(a);
    }

    public void card4(View view) {
        int a =(textView4.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
        textView4.setVisibility(a);
    }
}
