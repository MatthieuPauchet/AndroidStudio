package com.afpa.filrouge;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Model.JsonPlaceHolderApi;
import Model.Produit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static Model.JsonPlaceHolderApi.urlAPI;

public class ListProduitActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    List<Produit> produits;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        permet de supprimer le bandeau du haut de téléphone de l'appli
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_produit);

        // Récupération de listview/textviex et spinner
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getProduits();
    }

    private void getProduits(){
        Call<List<Produit>> call = jsonPlaceHolderApi.getProduits();

        call.enqueue(new Callback<List<Produit>>() {
            @Override
            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code "+response.code());
                    return;
                }

                produits = response.body();

                listView.setAdapter(new CustomListAdapterProduit(produits, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Produit>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

}
