package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Model.JsonPlaceHolderApi;
import Model.Produit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static Model.JsonPlaceHolderApi.urlAPI;

public class ListProduitRubriqueActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    List<Produit> produits;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    int pro_rub_id;
    String rub_nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        permet de supprimer le bandeau du haut de téléphone de l'appli
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_produit_rubrique);

        Bundle b = getIntent().getExtras();
        pro_rub_id = b.getInt("rub_id");
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


    }
}
