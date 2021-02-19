package data;

import org.zkoss.io.FileReader;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Table {
    private static List<TableLine> table;

    static {
        String name = "./bdd.json";

        JSONParser bddParse = new JSONParser();
        table = new ArrayList<>();
        try{
            JSONArray bddArray = (JSONArray) bddParse.parse(new FileReader(name,null));

            fillAll(bddArray);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*
    private void constructData(){
        String name = "./bdd.json";

        JSONParser bddParse = new JSONParser();
        try{
            bddArray = (JSONArray) bddParse.parse(new FileReader(name,null));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    public static void fillAll(JSONArray bddArray){
        for(int i = 0;i< bddArray.size();i++){
            fillOneLine(bddArray,i);
        }
    }

    public static void fillOneLine(JSONArray bddArray,int i){
        JSONObject obj = (JSONObject) bddArray.get(i);
        JSONObject fields = (JSONObject) obj.get("fields");
        String art = "not found in data base";
        String pays = "not found in data base";
        String ville = "not found in data base";
        String annee = "not found in data base";

        String firstDate = "not found in data base";
        String firstSalle = "not found in data base";
        String secondDate = "not found in data base";
        String secondSalle = "not found in data base";
        String thirdDate = "not found in data base";
        String thirdSalle = "not found in data base";

        Map<String,String> details = new HashMap<String,String>();

        if(fields.containsKey("artistes")){
            art = (String) fields.get("artistes");
        }
        if(fields.containsKey("origine_pays1")){
            pays = (String) fields.get("origine_pays1");
        }
        if(fields.containsKey("origine_ville1")){
            ville = (String) fields.get("origine_ville1");
        }
        if(fields.containsKey("annee")){
            annee = (String) fields.get("annee");
        }

        if(fields.containsKey("firstDate") &&
                fields.containsKey("firstSalle")){
            details.put((String) fields.get("1ere_salle"),(String) fields.get("1ere_date"));
        }

        if(fields.containsKey("secondDate") &&
                fields.containsKey("secondSalle")){
            details.put((String) fields.get("2eme_salle"),(String) fields.get("2eme_date"));
        }

        if(fields.containsKey("thirdDate") &&
                fields.containsKey("thirdSalle")){
            details.put((String) fields.get("3eme_date"),(String) fields.get("3eme_salle"));
        }

        TableLine l = new TableLine(art,pays,ville,annee,false,details);
        table.add(l);
    }

    public static List<TableLine> getTable(){
        return table;
    }
    public void setTable(List<TableLine> table) {
        this.table = table;
    }
    public static void affiche(){
        for(TableLine l : table){
            System.out.println(l.getArtiste());
            System.out.println(l.getAnnee());
            System.out.println(l.getPays());
            System.out.println(l.getVille());
        }
    }

    public static List<TableLine> getFilterTableLine(TableFilter tableFilter) {
        List<TableLine> someLine = new ArrayList<TableLine>();
        String art = tableFilter.getArtiste().toLowerCase();
        String pays = tableFilter.getPays().toLowerCase();
        String ville = tableFilter.getVille().toLowerCase();
        String annee = tableFilter.getAnnee().toLowerCase();

        for (Iterator<TableLine> i = table.iterator(); i.hasNext();) {
            TableLine tmp = i.next();
            if (tmp.getArtiste().toLowerCase().contains(art) &&
                    tmp.getPays().toLowerCase().contains(pays)  &&
                    tmp.getVille().toLowerCase().contains(ville) &&
                    tmp.getAnnee().toLowerCase().contains(annee)) {
                someLine.add(tmp);
            }
        }
        return someLine;
    }
    public static void main(String[] args) {
       affiche();
    }

}
