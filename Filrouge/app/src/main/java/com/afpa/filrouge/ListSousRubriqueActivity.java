package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Model.JsonPlaceHolderApi;
import Model.Rubrique;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static Model.JsonPlaceHolderApi.urlAPI;

public class ListSousRubriqueActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    TextView textView2;
    List<Rubrique> rubriques;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    int rub_id;
    String rub_nom;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_sous_rubrique);



        b = getIntent().getExtras();
        rub_id = b.getInt("rub_id");
        rub_nom = b.getString("rub_nom");

        // Récupération de listview/textview
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);


        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Intent intent = new Intent(context, ListProduitRubriqueActivity.class);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        textView.setText(rub_nom.toUpperCase());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getSousRubrique(rub_id);
    }


    private void getSousRubrique(int id){
        Call<List<Rubrique>> call = jsonPlaceHolderApi.getSousRubrique(id);

        call.enqueue(new Callback<List<Rubrique>>() {
            @Override
            public void onResponse(Call<List<Rubrique>> call, Response<List<Rubrique>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code " + response.code());
                    return;
                }

                rubriques = response.body();

                listView.setAdapter(new CustomListAdapterRubrique(rubriques, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Rubrique>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
