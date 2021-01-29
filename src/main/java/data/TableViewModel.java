package data;



import org.zkoss.json.JSONArray;
import org.zkoss.json.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;


public class TableViewModel {
    public JSONArray bddArray;
    public String title = "Liste des trucs";
    private Table table;

    public TableViewModel(){
        this.table = new Table();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args) {
        TableViewModel d = new TableViewModel();
    }

}
