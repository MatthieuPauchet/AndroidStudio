package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    Button listProduitBtn;
    Button listRubriqueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // enlevons la bare en haut
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logoView);
        listProduitBtn = findViewById(R.id.btnListProduit);
        listRubriqueBtn = findViewById(R.id.btnListRubrique);

        Picasso.get().load("https://dev.amorce.org/mpar/filrouge/annexe/Charte/HEADER/logo%20village%20green.png").into(logo);

        // Animations
        Animation topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation_layout);
        Animation bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation_layout);

        //Assignment
        logo.setAnimation(topAnim);
        listProduitBtn.setAnimation(bottomAnim);
        listRubriqueBtn.setAnimation(bottomAnim);
    }

    public void LoadViewListProduit(View view){
        Intent intent = new Intent(this, ListProduit.class);
        startActivity(intent);
    }

    public void LoadViewListRubrique(View view){
        Intent intent = new Intent(this, ListSousRubrique.class);
        startActivity(intent);
    }

}
