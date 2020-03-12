package com.afpa.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération de listview
        ListView listView = (ListView)findViewById(R.id.listView);
        //Création des users
        UserAcount francois = new UserAcount("François","admin");
        UserAcount germain = new UserAcount("Germain","user");
        UserAcount cedric = new UserAcount("Cédric","guest",false);
        UserAcount mo = new UserAcount("MO","guest");
        UserAcount fred = new UserAcount("Fred","guest");
        UserAcount loic = new UserAcount("Loic","user");
        UserAcount greg = new UserAcount("Greg","admin");
        UserAcount hans = new UserAcount("Hans","guest");
        UserAcount alex = new UserAcount("Alex","user");
        //Création de la liste
        UserAcount[] users = new UserAcount[]{francois,germain,cedric};

        //Création de l'adapter
        ArrayAdapter<UserAcount> arrayAdapter = new ArrayAdapter<UserAcount>(this, android.R.layout.simple_list_item_1,users);

        //Affectation de l'adapter
//        listView.setAdapter(arrayAdapter);

        List<UserAcount> listCli = new ArrayList<>();

        listCli.add(francois);
        listCli.add(germain);
        listCli.add(cedric);
        listCli.add(mo);
        listCli.add(greg);
        listCli.add(hans);
        listCli.add(loic);
        listCli.add(fred);
        listCli.add(alex);

        listView.setAdapter(new CustomListAdapter(listCli, this));
    }




}
