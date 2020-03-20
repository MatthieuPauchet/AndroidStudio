package Model;

import androidx.annotation.NonNull;

public class Rubrique {
    private int rub_id;
    private String rub_nom;
    private String rub_libelle;
    private String rub_photo;
    private int rub_id_1;

    public Rubrique() {
    }

    public Rubrique(int rub_id, String rub_nom, String rub_libelle, String rub_photo) {
        this.rub_id = rub_id;
        this.rub_nom = rub_nom;
        this.rub_libelle = rub_libelle;
        this.rub_photo = rub_photo;
        this.rub_id_1 = -1;
    }

    public Rubrique(int rub_id, String rub_nom, String rub_libelle, String rub_photo, int rub_id_1) {
        this.rub_id = rub_id;
        this.rub_nom = rub_nom;
        this.rub_libelle = rub_libelle;
        this.rub_photo = rub_photo;
        this.rub_id_1 = rub_id_1;
    }

    public int getRub_id() {
        return rub_id;
    }

    public void setRub_id(int rub_id) {
        this.rub_id = rub_id;
    }

    public String getRub_nom() {
        return rub_nom;
    }

    public void setRub_nom(String rub_nom) {
        this.rub_nom = rub_nom;
    }

    public String getRub_libelle() {
        return rub_libelle;
    }

    public void setRub_libelle(String rub_libelle) {
        this.rub_libelle = rub_libelle;
    }

    public String getRub_photo() {
        return rub_photo;
    }

    public void setRub_photo(String rub_photo) {
        this.rub_photo = rub_photo;
    }

    public int getRub_id_1() {
        return rub_id_1;
    }

    public void setRub_id_1(int rub_id_1) {
        this.rub_id_1 = rub_id_1;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
