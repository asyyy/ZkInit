package data;


import java.util.HashMap;
import java.util.Map;

public class TableLine2 {
    private boolean detailOpen;
    private Map<String,String> details = new HashMap<String, String>();

    public TableLine2(boolean detailOpen, Map<String,String> details){
        this.detailOpen = false;
        this.details = details;
    }

    public String getArtiste() {
        return findOrDefault("artistes");
    }
    public String getPays() {
        return findOrDefault("origine_pays1");
    }

    public String getVille() {
        return findOrDefault("origine_ville1");
    }

    public String getAnnee() {
        return findOrDefault("annee");
    }

    public String findOrDefault(String find){
        return details.getOrDefault(find,"Nono didn't found this info");
    }

    public boolean isDetailOpen() {
        return detailOpen;
    }


    public Map<String, String> getDetails() {
        return details;
    }
    public String getSpotify(){
        String spo = details.get("spotify");
        String res = "";
        if(spo != null){
            res = "https://open.spotify.com/embed?uri="+spo;
        }
        return res;
    }


}
