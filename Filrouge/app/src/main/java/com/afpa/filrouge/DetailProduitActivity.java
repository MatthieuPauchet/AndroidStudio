package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailProduitActivity extends AppCompatActivity {

    private ImageView ivProduit;
    private TextView tvName;
    private TextView tvLibelle;
    private TextView tvPrix;
    List<Produit> produits;
    Produit produit;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_produit);

        ivProduit = findViewById(R.id.ivPicture);
        tvName = findViewById(R.id.tvLibelleCourt);
        tvLibelle = findViewById(R.id.tvLibelleLong);
        tvPrix = findViewById(R.id.tvPrix);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev.amorce.org/mpar/filrouge/index.php/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getProduit();
    }


    private void getProduit(){
        Call<List<Produit>> call = jsonPlaceHolderApi.getProduit();

        call.enqueue(new Callback<List<Produit>>() {
            @Override
            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                if (!response.isSuccessful()){
                    tvName.setText("Code "+response.code());
                    return;
                }

                produits = response.body();
                produit = produits.get(0);

                tvName.setText(produits.get(0).getPro_libelle_court());
                tvLibelle.setText(produits.get(0).getPro_libelle_long());
                tvPrix.setText(String.valueOf(produits.get(0).getPro_prix_achat()));
                Picasso.get().load("https://dev.amorce.org/mpar/filrouge/assets/images/"+produit.getPro_photo()).into(ivProduit);
            }

            @Override
            public void onFailure(Call<List<Produit>> call, Throwable t) {
                tvLibelle.setText(t.getMessage());
            }
        });
    }
}
