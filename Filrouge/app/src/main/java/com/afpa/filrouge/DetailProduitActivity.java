package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

import Model.JsonPlaceHolderApi;
import Model.Produit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static Model.JsonPlaceHolderApi.urlAPI;
import static Model.JsonPlaceHolderApi.urlPhoto;

public class DetailProduitActivity extends AppCompatActivity {

    private ImageView ivProduit;
    private TextView tvName;
    private TextView tvLibelle;
    private TextView tvPrix;
    List<Produit> produits;
    Produit produit;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    int pro_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_produit);

        Bundle b = getIntent().getExtras();
        pro_id = b.getInt("pro_id");

        ivProduit = findViewById(R.id.ivPicture);
        tvName = findViewById(R.id.tvLibelleCourt);
        tvLibelle = findViewById(R.id.tvLibelleLong);
        tvPrix = findViewById(R.id.tvPrix);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getProduit(pro_id);
    }


    private void getProduit(int id){
        Call<List<Produit>> call = jsonPlaceHolderApi.getProduit(id);

        call.enqueue(new Callback<List<Produit>>() {
            @Override
            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                if (!response.isSuccessful()){
                    tvName.setText("Code "+response.code());
                    return;
                }

                produits = response.body();
                produit = produits.get(0);

                tvName.setText(produit.getPro_libelle_court());
                tvLibelle.setText(produit.getPro_libelle_long());
                final NumberFormat instance = NumberFormat.getNumberInstance();
                instance.setMinimumFractionDigits(2);
                instance.setMaximumFractionDigits(2);
                tvPrix.setText("Prix : "+instance.format(produit.getPro_prix_achat())+"€");
                Picasso.get().load(urlPhoto + produit.getPro_photo()).into(ivProduit);
            }

            @Override
            public void onFailure(Call<List<Produit>> call, Throwable t) {
                tvLibelle.setText(t.getMessage());
            }
        });
    }
}
