package ub.edu.view;




import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.text.Text;
import ub.edu.controller.Controller;


import java.io.IOException;

public class EscenaCompteBancaria extends Escena{
    public TextField visa;
    public TextField cad;
    public TextField codi;
    public Button pagar;
    public TextField preutext;
    public Text activitattext;
    public Text data_activitat;

    public void setActivitat(String activitat,String excursio){
        activitattext.setText(activitat);
        data_activitat.setText("Preu : " + controller.findActivitat(activitat, excursio) + "€");
        String s = controller.findActivitat(activitat,excursio);
        preutext.setText(s);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        pagar.setOnAction(new EventHandler<javafx.event.ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                if(controller.isVisa(visa.getText()) == false){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("La tarjeta ha de tenir 16 dígits");
                    alert.show();

                }else if(controller.isCodi(codi.getText()) == false){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("El codi ha de tenir 3 dígits");
                    alert.show();

                }else if(controller.isCad(cad.getText()) == false) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("El format de caducitat ha de ser MM/YY");
                    alert.show();


                }else if(!preutext.getText().equals(controller.findActivitat(activitat,excursio))){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Aquest no és el preu");
                    alert.show();

                }else{
                    controller.pagarCompteBancaria(activitat,excursio,controller.recuperaString());
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Pagat!");
                    alert.setHeaderText("Activitat pagada!");
                    alert.show();
                    alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                        @Override
                        public void handle(DialogEvent dialogEvent) {
                            stage.close();
                            Escena main = null;
                            try {
                                main = EscenaFactory.INSTANCE.creaEscena("main-view", "CeXtrem");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            EscenaMain escenaMain = ((EscenaMain)main);
                            main.setController(controller);
                            escenaMain.start();
                        }

                    });
                }

            }
        });


    }
}









