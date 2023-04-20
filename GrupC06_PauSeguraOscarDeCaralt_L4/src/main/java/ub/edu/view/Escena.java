package ub.edu.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ub.edu.AppMain;
import ub.edu.controller.Controller;

import java.io.IOException;

public abstract class Escena {
    protected Stage stage;
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setStage(Stage newStage) {
        this.stage = newStage;
    }
}
