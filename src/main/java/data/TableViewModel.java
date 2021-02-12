package data;



import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.json.JSONArray;
import org.zkoss.json.parser.JSONParser;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.io.FileReader;
import java.io.IOException;


public class TableViewModel {

    private static final String footerMessage = "A Total of %d trucs Items";
    public String title = "Liste des trucs";
    private Table table;
    private TableFilter tableFilter = new TableFilter();

    public TableViewModel(){
        this.table = new Table();
    }
    public TableFilter getTableFilter(){
        return tableFilter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListModel<TableLine> getListModel(){
        return new ListModelList<TableLine>(table.getTable());
    }

    public static void main(String[] args) {
        TableViewModel d = new TableViewModel();
    }

    public String getFooter() {
        return String.format(footerMessage, table.getTable().size());
    }
    /*
    @Command
    @NotifyChange({"foodModel", "footer"})
    public void changeFilter() {
        table.set = FoodData.getFilterFoods(foodFilter);
    }*/

}
