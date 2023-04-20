package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


import java.io.IOException;

public class EscenaPagar extends Escena {

    public Text activitat_text;
    public Text data_text;
    public Button bizum_btn;
    public Button comptebancaria_btn;
    public Button paypal_btn;

    public void setPagar(String nomActivitat, String nomExcursio) {

        activitat_text.setText(nomActivitat);
        data_text.setText("Preu : " + controller.findActivitat(nomActivitat, nomExcursio) + "€");

        bizum_btn.setOnAction(new EventHandler<javafx.event.ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraBizum(nomActivitat,nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        paypal_btn.setOnAction(new EventHandler<javafx.event.ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraPaypal(nomActivitat,nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        comptebancaria_btn.setOnAction(new EventHandler<javafx.event.ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraCompteBancaria(nomActivitat,nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


    }
    public void mostrarFinestraBizum(String activitat,String excursio) throws IOException {
        Escena escena = EscenaFactory.INSTANCE.creaEscena("bizum-view", activitat);
        EscenaBizum escenaBizum = ((EscenaBizum)escena);
        escenaBizum.setController(controller);
        escenaBizum.setActivitat(activitat,excursio);



    }
    public void mostrarFinestraPaypal(String activitat,String excursio) throws IOException {
        Escena escena = EscenaFactory.INSTANCE.creaEscena("paypal-view", activitat);
        EscenaPayPal escenaPayPal = ((EscenaPayPal)escena);
        escenaPayPal.setController(controller);
        escenaPayPal.setActivitat(activitat,excursio);



    }

    public void mostrarFinestraCompteBancaria(String activitat,String excursio) throws IOException {
        Escena escena = EscenaFactory.INSTANCE.creaEscena("comptebancaria-view", activitat);
        EscenaCompteBancaria escenaCompteBancaria = ((EscenaCompteBancaria)escena);
        escenaCompteBancaria.setController(controller);
        escenaCompteBancaria.setActivitat(activitat,excursio);



    }
}
