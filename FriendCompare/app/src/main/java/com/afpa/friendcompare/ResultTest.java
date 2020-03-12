package com.afpa.friendcompare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultTest extends AppCompatActivity {

    private TextView txtPrenoms, txtResult, txtAmitie;
    private Handler hdlr = new Handler();
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test);

        // On génère aléatoirement un nombre entre 1 et 100
        final int result = (int)(Math.random()*99)+1;

        // Récupère les infos de Intent
        Intent intent = getIntent();
        String prenom1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String prenom2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        // on affecte au textView la phrase d'intro avec les deux prénoms
        txtPrenoms =findViewById(R.id.txtPrenoms);
        txtPrenoms.setText(prenom1+" et "+prenom2+"\n votre amitié est fiable à :");

        txtResult=findViewById(R.id.txtResult);
        txtAmitie=findViewById(R.id.txtAmitie);


        new Thread(new Runnable() {
            public void run() {
                while (i < result) {
                    i += 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            txtResult.setText(i+"%");
                            if (i<25){
                                txtResult.setTextColor(Color.parseColor("#FF0000"));
                            } else if (i<50) {
                                txtResult.setTextColor(Color.parseColor("#FFBB00"));
                            } else if(i<75) {
                                txtResult.setTextColor(Color.parseColor("#00FFBD"));
                            } else {
                                txtResult.setTextColor(Color.parseColor("#00FF00"));
                            }
                            if (i==result){
                                if (result<25){
                                    txtAmitie.setText("Vous ne pouvez pas vous voir");
                                    txtAmitie.setTextColor(Color.parseColor("#FF0000"));
                                } else if (result<50){
                                    txtAmitie.setText("Vous faites semblant de bien vous entendre");
                                    txtAmitie.setTextColor(Color.parseColor("#FFBB00"));
                                } else if (result<75){
                                    txtAmitie.setText("Vous vous entendez bien");
                                    txtAmitie.setTextColor(Color.parseColor("#00FFBD"));
                                } else {
                                    txtAmitie.setText("Vous n'êtes pas plus que des amis...?");
                                    txtAmitie.setTextColor(Color.parseColor("#00FF00"));
                                }
                            }
                        }

                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
