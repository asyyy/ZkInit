package data;


import java.util.*;

public class TableLine{

    private String artiste;
    private String pays;
    private String ville;
    private String annee;

    private boolean detailOpen;
    private Map<String,String> details = new HashMap<String, String>();

    public TableLine(String artiste, String pays, String ville, String annee,
                     boolean detailOpen, Map<String,String> details){
        this.artiste = artiste;
        this.pays = pays;
        this.ville = ville;
        this.annee = annee;
        this.detailOpen = false;
        this.details.put("Bonjour","Commissaire");
        this.details.put("chapi","chapo");
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

    public boolean isDetailOpen() {
        return detailOpen;
    }

    public void setDetailOpen(boolean detailOpen) {
        this.detailOpen = detailOpen;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }


}
