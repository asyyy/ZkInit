package data;

public class TableLine implements Comparable<TableLine>{

    public String artiste;
    public String pays;
    public String ville;
    public String annee;

    public TableLine(String artiste, String pays, String ville, String annee){
        this.artiste = artiste;
        this.pays = pays;
        this.ville = ville;
        this.annee = annee;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAnnee() {
        return annee;
    }
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public int compareTo(TableLine o) {
        return this.compareTo(o);
    }
}
