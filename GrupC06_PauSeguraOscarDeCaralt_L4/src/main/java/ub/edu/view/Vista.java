package ub.edu.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ub.edu.AppMain;
import ub.edu.controller.Controller;

import java.io.IOException;

public class Vista {
    protected Controller controller;
    public Vista(Stage stage, Controller controller) throws IOException {
        this.controller = controller;
        //Posem titol a la finestra

        Escena login = EscenaFactory.INSTANCE.creaEscena("login-view", "Login");

        //Li enviem la finestra (stage) i el controlador a la nova escena
        login.setController(controller);

    }
}
