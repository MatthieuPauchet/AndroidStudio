package com.afpa.quizafpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int NbFaces;
    private TextView txtFace, txtAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lancerDe(View view) {

        txtFace = findViewById(R.id.txt_faces);
        txtAlert = findViewById(R.id.txt_alert);

        if (txtFace.getText().toString().length()!=0){
            NbFaces = Integer.valueOf(txtFace.getText().toString());
            Intent intent = new Intent(this, Result.class);
            Bundle b = new Bundle();
            b.putInt("NombreFaces", NbFaces);
            intent.putExtras(b);
            startActivity(intent);
        } else {
            txtAlert.setText("Tu a oublié de prendre le dé avant de lancer...");
        }
    }

}
