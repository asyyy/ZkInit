package data;



import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.json.JSONArray;
import org.zkoss.json.parser.JSONParser;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class TableViewModel {

    private static final String footerMessage = "A Total of %d trucs Items";
    public String title = "Liste des trucs";
    private TableFilter tableFilter = new TableFilter();
    private List<TableLine2> currentTable = Table2.getTable();


    /**
     * Retourne l'objet servant de filtre pour la vue
     * @return TableFilter
     */
    public TableFilter getTableFilter(){
        return tableFilter;
    }

    /**
     * getter de title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter de title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Rend le tablo au Grid
     * @return ListModel
     */
    public ListModel<TableLine2> getTableModel(){
        return new ListModelList<>(currentTable);
    }

    /**
     * Modifie le message de taille total du tableau
     * @return
     */
    public String getFooter() {
        return String.format(footerMessage, currentTable.size());
    }

    /**
     * Affiche un joli tablo (débug à la mano)
     */
    public void affiche(){
        /*for(TableLine l : this.currentTable){
            System.out.println(l.getArtiste());
            System.out.println(l.getAnnee());
            System.out.println(l.getPays());
            System.out.println(l.getVille());
        }*/
    }

    @Command
    @NotifyChange({"tableModel", "footer"})
    public void changeFilter() {
        currentTable = Table2.getFilterTableLine(tableFilter);
        //affiche();
    }
}
