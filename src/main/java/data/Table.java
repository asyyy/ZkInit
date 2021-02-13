package data;

import org.zkoss.io.FileReader;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {
    private static List<TableLine> table;
    //private static JSONArray bddArray;



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
        String art = "not Found";
        String pays = "not Found";
        String ville = "not Found";
        String annee = "not Found";

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
        TableLine l = new TableLine(art,pays,ville,annee);
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
