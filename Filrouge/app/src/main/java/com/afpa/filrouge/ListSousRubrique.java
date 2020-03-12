package com.afpa.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListSousRubrique extends AppCompatActivity {

    ListView listView;
    TextView textView;
    List<Rubrique> rubriques;
    List<Rubrique> sousRubriques = new ArrayList<>();
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_sous_rubrique);

        // Récupération de listview/textview
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev.amorce.org/mpar/filrouge/index.php/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getRubriques();
    }


    private void getRubriques(){
        Call<List<Rubrique>> call = jsonPlaceHolderApi.getRubriques();


        call.enqueue(new Callback<List<Rubrique>>() {
            @Override
            public void onResponse(Call<List<Rubrique>> call, Response<List<Rubrique>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code " + response.code());
                    return;
                }

                rubriques = response.body();

                for (Rubrique rub : rubriques) {
                       if (!String.valueOf(rub.getRub_id_1()).equals("0")){
                           sousRubriques.add(rub);
                       }
                }

                listView.setAdapter(new CustomListAdapterRubrique(sousRubriques, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Rubrique>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
