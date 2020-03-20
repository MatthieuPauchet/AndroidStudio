package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Model.JsonPlaceHolderApi;
import Model.Produit;
import Model.Rubrique;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static Model.JsonPlaceHolderApi.urlAPI;

public class ListProduitRubriqueActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    List<Produit> produits;
    List<Produit> prods = new ArrayList<>();
    List<Rubrique> sousRubriques;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    int rub_id;
    String rub_nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        permet de supprimer le bandeau du haut de téléphone de l'appli
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_produit_rubrique);

        Bundle b = getIntent().getExtras();
        rub_id = b.getInt("rub_id");
        rub_nom = b.getString("rub_nom");


        // Récupération de listview/textviex et spinner
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);

        textView.setText("Nos produits dans la catégorie : "+rub_nom.toUpperCase());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getSousRubrique(rub_id);

    }

    private void getSousRubrique(int id) {
        Call<List<Rubrique>> call = jsonPlaceHolderApi.getSousRubrique(id);

        call.enqueue(new Callback<List<Rubrique>>() {
            @Override
            public void onResponse(Call<List<Rubrique>> call, Response<List<Rubrique>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code " + response.code());
                    return;
                }
                sousRubriques = response.body();

                getProduitsRubriques(sousRubriques);
            }

            @Override
            public void onFailure(Call<List<Rubrique>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void getProduitsRubriques(List<Rubrique> rubs){

        for (Rubrique rub : rubs) {
            Call<List<Produit>> call = jsonPlaceHolderApi.getProduiSousRubrique(rub.getRub_id());

            call.enqueue(new Callback<List<Produit>>() {
                @Override
                public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                    if (!response.isSuccessful()){
                        textView.setText("Code "+response.code());
                        return;
                    }
                    produits = response.body();
                    for (Produit prod : produits){
                        prods.add(prod);
                    }
                    listView.setAdapter(new CustomListAdapterProduit(prods, getApplicationContext()));
                }

                @Override
                public void onFailure(Call<List<Produit>> call, Throwable t) {
                    textView.setText(t.getMessage());
                }

            });
        }

    }
}
