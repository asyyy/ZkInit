package data;

import org.zkoss.io.FileReader;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;

import java.io.IOException;
import java.util.*;

public class Table2 {
    private static List<TableLine2> table;

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
    public static void fillAll(JSONArray bddArray){
        for(int i = 0;i< bddArray.size();i++){
            fillOneLine2(bddArray,i);
        }
    }
    public static void fillOneLine2(JSONArray bddArray,int i){
        JSONObject obj = (JSONObject) bddArray.get(i);
        JSONObject fields = (JSONObject) obj.get("fields");
        Map<String,String> everything = new HashMap<String,String>();

        for(Map.Entry<Object, Object> s : fields.entrySet()){

            String value = "";
            //s.getValue() n'est pas toujours un string
            if(s.getValue() instanceof Integer || s.getValue() instanceof Double){
                value = String.valueOf(s.getValue());
            }else if(s.getValue() instanceof JSONArray){
                JSONArray array = (JSONArray) s.getValue();
                value = "[ ";
                for(Object truc : array){
                    value+= String.valueOf(truc) +",";
                }
                //Tout ça juste pour enlever la derniere virgule.
                value= value.substring(0,value.length()-1)+ " ]";
            }else{
                value = (String) s.getValue();
            }
            //Pour que ça rende plus beau

            everything.put((String)s.getKey(),value);
        }
        TableLine2 l = new TableLine2(false,everything);
        table.add(l);
    }


    public static List<TableLine2> getTable(){
        return table;
    }
    public void setTable(List<TableLine2> table) {
        this.table = table;
    }


    public static List<TableLine2> getFilterTableLine(TableFilter tableFilter) {
        List<TableLine2> someLine = new ArrayList<TableLine2>();
        String art = tableFilter.getArtiste().toLowerCase();
        String pays = tableFilter.getPays().toLowerCase();
        String ville = tableFilter.getVille().toLowerCase();
        String annee = tableFilter.getAnnee().toLowerCase();

        for (Iterator<TableLine2> i = table.iterator(); i.hasNext();) {
            TableLine2 tmp = i.next();
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

    }

}
