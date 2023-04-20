package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ub.edu.model.Excursio;
import ub.edu.resources.dao.MOCK.DAOExcursioMOCK;

import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class EscenaExcursio extends Escena{

    public Excursio excursio;

    public Text excursio_text;
    public Text data_text;
    public Button origen_btn;
    public Button desti_btn;
    public Button activitats_btn;

    public void setExcursio(String nomExcursio) throws IOException {
        excursio_text.setText(nomExcursio);
        // TODO: Fer canvis per no mostrar dades dummy:
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        data_text.setText(controller.getExcursio(nomExcursio).getData().format(formatter));
        origen_btn.setText("Centre d'Excursionistes");
        desti_btn.setText(nomExcursio);
        origen_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraLocalitzacio(nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        desti_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraLocalitzacio(nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        activitats_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraActivitatsExcursio(nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }



    public void mostrarFinestraLocalitzacio(String localitzacio) throws IOException {
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("localitzacio-view", localitzacio);
        EscenaLocalitzacio escenaLocalitzacio = ((EscenaLocalitzacio)escena);
        escenaLocalitzacio.setController(controller);
        escenaLocalitzacio.setLocalitzacio(localitzacio);
    }

    private void mostrarFinestraActivitatsExcursio(String excursio) throws IOException {
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("activitatsexcursio-view", excursio);
        EscenaActivitatsExcursio escenaActExcursio = ((EscenaActivitatsExcursio)escena);
        escenaActExcursio.setController(controller);
        escenaActExcursio.setExcursio(excursio);
    }
}
