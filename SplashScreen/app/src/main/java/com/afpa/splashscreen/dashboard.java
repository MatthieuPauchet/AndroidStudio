package com.afpa.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Animation rightAnim = AnimationUtils.loadAnimation(this,R.anim.rigth_animation_layout);
        TextView titre = findViewById(R.id.textTitle);
        titre.setAnimation(rightAnim);
    }
}
