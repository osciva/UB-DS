package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import ub.edu.controller.Controller;


import java.io.IOException;

public class EscenaBizum extends Escena{

    public TextField num_txt;
    public TextField comment_text;
    public TextField preu_text;
    public Button pagar_btn;
    public Text activitat_text;
    public Text data_text;



public void setActivitat(String activitat,String excursio){
    activitat_text.setText(activitat);
    data_text.setText("Preu : " + controller.findActivitat(activitat, excursio) + "€");
    String s = controller.findActivitat(activitat,excursio);
    preu_text.setText(s);

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    pagar_btn.setOnAction(new EventHandler<javafx.event.ActionEvent>(){
        @Override
        public void handle(ActionEvent actionEvent) {
          if(!num_txt.getText().equals("633191645")){
              alert.setAlertType(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText("No és el nostre número");
              alert.show();

          }else if(!preu_text.getText().equals(controller.findActivitat(activitat,excursio))){
              alert.setAlertType(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText("Aquest no és el preu");
              alert.show();

          }else{
              controller.pagarBizum(activitat,excursio,controller.recuperaString());
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

