package Model;

import java.util.List;

import Model.Produit;
import Model.Rubrique;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    public String urlAPI ="https://dev.amorce.org/mpar/filrouge/index.php/Api/";
    public String urlPhoto ="https://dev.amorce.org/mpar/filrouge/assets/images/";

    @GET("List/produit")
    Call<List<Produit>> getProduits();

    @GET("List/rubrique")
    Call<List<Rubrique>> getRubriques();

    @GET("Find/produit/{id}")
    Call<List<Produit>> getProduit(@Path("id") int pro_id);

    @GET("List/rubrique/rubrique/{id}")
    Call<List<Rubrique>> getSousRubrique(@Path("id") int rub_id);

    @GET("List/produit/rubrique/{id}")
    Call<List<Produit>> getProduiSousRubrique(@Path("id") int pro_rub_id);

}
