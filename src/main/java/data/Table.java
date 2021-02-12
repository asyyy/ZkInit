package data;

import org.zkoss.io.FileReader;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<TableLine> table;
    private JSONArray bddArray;

    public Table(){
        constructData();
        this.table = new ArrayList<>();
        fillAll();
    }
    public void constructData(){
        String name = "./bdd.json";

        JSONParser bddParse = new JSONParser();
        try{
            bddArray = (JSONArray) bddParse.parse(new FileReader(name,null));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void fillAll(){
        for(int i = 0;i< bddArray.size();i++){
            fillOneLine(i);
        }
    }

    public void fillOneLine(int i){
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

    public List<TableLine> getTable(){
        return table;
    }
    public void setTable(List<TableLine> table) {
        this.table = table;
    }
    public void affiche(){
        for(TableLine l : table){
            System.out.println(l.getArtiste());
            System.out.println(l.getAnnee());
            System.out.println(l.getPays());
            System.out.println(l.getVille());
        }
    }
    public static void main(String[] args) {
        Table t = new Table();
        t.affiche();
    }



}
