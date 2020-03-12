package com.afpa.filrouge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("List/produit")
    Call<List<Produit>> getProduits();

    @GET("List/rubrique")
    Call<List<Rubrique>> getRubriques();

    @GET("Find/produit/5")
    Call<List<Produit>> getProduit();

}
