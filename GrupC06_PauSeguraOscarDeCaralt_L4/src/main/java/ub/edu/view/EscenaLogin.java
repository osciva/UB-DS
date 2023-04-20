package ub.edu.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ub.edu.controller.Controller;
import ub.edu.controller.SociStatus;

import java.io.IOException;

public class EscenaLogin extends Escena {

    public Button login_btn;
    public TextField login_correu;
    public PasswordField login_pwd;
    public Button registre_btn;
    public TextField registre_correu;
    public PasswordField registre_pwd;

    @FXML
    protected void onLoginButtonClick() {
        String correu = login_correu.getText();
        String pwd = login_pwd.getText();

        SociStatus resultat = controller.loguejarSociStatus(correu, pwd);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if(resultat == SociStatus.CORREU_INEXISTENT || resultat == SociStatus.CONTRASSENYA_INCORRECTA){
            //Problema en el login:
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el login");
            alert.setContentText(resultat.toString());
        }else{
            //Login amb èxit:
            controller.guardaString(correu);
            alert.setTitle("Login exitòs");
            alert.setHeaderText("Login exitòs");
            //Fent això, canviarem l'escena quan es tanqui el diàleg
            alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                @Override
                public void handle(DialogEvent dialogEvent) {
                    try {
//                        Escena main = canviarEscena("main-view", "CeXtrem");
                        Escena main = EscenaFactory.INSTANCE.creaEscena("main-view", "CeXtrem");
                        EscenaMain escenaMain = ((EscenaMain)main);
                        main.setController(controller);
                        escenaMain.start();
                        stage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        alert.showAndWait();
    }

    @FXML
    public void onRegistreButtonClick() {
        String correu = registre_correu.getText();
        String pwd = registre_pwd.getText();
        SociStatus resultat = controller.RegistrarSoci(correu, pwd);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if(resultat == SociStatus.SOCI_DUPLICAT || resultat == SociStatus.FORMAT_INCORRECTE){
            //Problema en el registre:
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el registre");
            alert.setContentText(resultat.toString());
        }else{
            //Registre amb èxit:
            alert.setTitle("Registre exitòs");
            alert.setHeaderText("Registre exitòs");
        }
        alert.showAndWait();
    }
}