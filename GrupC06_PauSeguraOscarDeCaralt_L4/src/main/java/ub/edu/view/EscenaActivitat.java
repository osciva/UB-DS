package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ub.edu.controller.SociStatus;
import ub.edu.model.LlistaObserver;
import ub.edu.view.EscenaLogin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;


public class EscenaActivitat extends Escena {


    public Text activitat_text;
    public Text data_text;
    public Button apuntarse_btn;
    public Button pagar_btn;
    public Button valorar_btn;


    public void setActivitat(String nomActivitat, String nomExcursio) {

        activitat_text.setText(nomActivitat);
        data_text.setText("Preu : " + controller.findActivitat(nomActivitat, nomExcursio) + "€");

        apuntarse_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                controller.apuntarseActivitat(nomExcursio,nomActivitat,controller.recuperaString());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reserva");
                alert.setHeaderText("Reserva exitosa");
                alert.setContentText("Reserva exitosa");
                alert.show();
                alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                    @Override
                    public void handle(DialogEvent dialogEvent) {

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


        });



        pagar_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraPagar(nomActivitat,nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
    });



}
public void mostrarFinestraPagar(String activitat,String excursio) throws IOException {
    Escena escena = EscenaFactory.INSTANCE.creaEscena("pagar-view", activitat);
    EscenaPagar escenaPagar = ((EscenaPagar)escena);
    escenaPagar.setController(controller);
    escenaPagar.setPagar(activitat,excursio);





    }





}








