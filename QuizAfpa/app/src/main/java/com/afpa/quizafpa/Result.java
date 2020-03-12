package com.afpa.quizafpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.params.Face;
import android.media.FaceDetector;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    //private TextView ResultText;
    public int min = 1;
    public int result, max;
    private TextView txtResult, txtFaceDe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle b = getIntent().getExtras();
        max = b.getInt("NombreFaces");
        //Intent intent = getIntent();
        //max = intent.getIntExtra("NombreFaces",);


        result = min + (int)(Math.random() * ((max - min) + 1));

        txtResult = findViewById(R.id.text_result);
        txtResult.setText(String.valueOf(result));

        txtFaceDe = findViewById(R.id.txt_faceDe);
        txtFaceDe.setText("Pour un dé à "+max+" Faces");

        Log.d("test", "onCreate: "+result+", "+max);

    }

    public void backHome (View view){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        result = min + (int)(Math.random() * ((max - min) + 1));

        txtResult = findViewById(R.id.text_result);
        txtResult.setText(String.valueOf(result));

    }


}
