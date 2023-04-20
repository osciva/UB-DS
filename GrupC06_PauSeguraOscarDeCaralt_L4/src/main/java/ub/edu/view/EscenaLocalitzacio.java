package ub.edu.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import ub.edu.model.Excursio;


public class EscenaLocalitzacio extends Escena{

    public Text ubicacio_text;
    public Hyperlink link_text;
    public ListView especies_list;

    public void setLocalitzacio(String nomLocalitzacio) {
        // TODO: Fer canvis per no mostrar dades dummy:
        ubicacio_text.setText(nomLocalitzacio);
        String link = controller.getLinkLocalitzacio(nomLocalitzacio);

        link_text.setText(link);
        for(String especie : controller.especies(nomLocalitzacio)){
            especies_list.getItems().add(especie);
        }
    }
}
