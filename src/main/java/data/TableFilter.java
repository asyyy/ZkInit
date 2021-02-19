package data;

import java.util.Objects;

public class TableFilter {
    private String artiste="";
    private String pays="";
    private String ville="";
    private String annee="";

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        Objects.requireNonNull(artiste);
        this.artiste = artiste.trim();
        //this.artiste = artiste==null?"":artiste.trim();
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        Objects.requireNonNull(pays);
        this.pays = pays.trim();
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        Objects.requireNonNull(ville);
        this.ville = ville.trim();
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        Objects.requireNonNull(annee);
        this.annee = annee.trim();
    }
}
