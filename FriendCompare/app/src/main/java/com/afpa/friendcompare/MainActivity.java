package com.afpa.friendcompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText etxtPrenom1, etxtPrenom2;
    private String prenom1, prenom2;
    private ImageButton btnGo;
    public static final String EXTRA_MESSAGE1 = "com.afpa.myapplication.PRENOM1";
    public static final String EXTRA_MESSAGE2 = "com.afpa.myapplication.PRENOM2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = findViewById(R.id.imgBtn);
        btnGo.setEnabled(false);
        etxtPrenom2 = findViewById(R.id.etxt_prenom2);
        etxtPrenom2.setEnabled(false);
        etxtPrenom1 = findViewById(R.id.etxt_prenom1);

        etxtPrenom1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etxtPrenom2.setEnabled(s.toString().length()!=0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        etxtPrenom2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnGo.setEnabled(s.toString().length()!=0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void goResult(View view){
        Intent intent = new Intent(this, ResultTest.class);
        etxtPrenom1 = findViewById(R.id.etxt_prenom1);
        prenom1 = etxtPrenom1.getText().toString();
        etxtPrenom2 = findViewById(R.id.etxt_prenom2);
        prenom2 = etxtPrenom2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, prenom1);
        intent.putExtra(EXTRA_MESSAGE2, prenom2);
        startActivity(intent);
    }


}
