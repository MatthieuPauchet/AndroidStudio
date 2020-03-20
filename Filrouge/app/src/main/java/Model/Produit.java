package Model;

import androidx.annotation.NonNull;

public class Produit {
    private int pro_id;
    private String pro_libelle_court;
    private String pro_libelle_long;
    private double pro_prix_achat;
    private String pro_photo;
    private int pro_rub_id;
    private int pro_fou_id;

    public Produit() {
    }

    public Produit(String pro_libelle_court, String pro_libelle_long, double pro_prix_achat, String pro_photo) {
        this.pro_libelle_court = pro_libelle_court;
        this.pro_libelle_long = pro_libelle_long;
        this.setPro_prix_achat(pro_prix_achat);
        this.pro_photo = pro_photo;
        this.pro_fou_id = 3;
        this.pro_rub_id = 6;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_libelle_court() {
        return pro_libelle_court;
    }

    public void setPro_libelle_court(String pro_libelle_court) {
        this.pro_libelle_court = pro_libelle_court;
    }

    public String getPro_libelle_long() {
        return pro_libelle_long;
    }

    public void setPro_libelle_long(String pro_libelle_long) {
        this.pro_libelle_long = pro_libelle_long;
    }

    public double getPro_prix_achat() {
        return pro_prix_achat;
    }

    public void setPro_prix_achat(double pro_prix_achat) {
        if (pro_prix_achat<0){
            this.pro_prix_achat = Double.parseDouble(null);
        }
        this.pro_prix_achat = pro_prix_achat;
    }

    public String getPro_photo() {
        return pro_photo;
    }

    public void setPro_photo(String pro_photo) {
        this.pro_photo = pro_photo;
    }

    public int getPro_rub_id() {
        return pro_rub_id;
    }

    public void setPro_rub_id(int pro_rub_id) {
        this.pro_rub_id = pro_rub_id;
    }

    public int getPro_fou_id() {
        return pro_fou_id;
    }

    public void setPro_fou_id(int pro_fou_id) {
        this.pro_fou_id = pro_fou_id;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }


}
