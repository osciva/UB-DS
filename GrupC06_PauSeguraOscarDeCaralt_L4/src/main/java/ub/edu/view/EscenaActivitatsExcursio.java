package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class EscenaActivitatsExcursio extends Escena{
    private static final double ESPAI_ENTRE_BOTONS = 30;

    public AnchorPane activitats_pane;
    public Button activitat_btn;
    public Text excursio_text;


    public EscenaActivitatsExcursio() throws IOException {
    }

    public void setExcursio(String nomExcursio) {
        excursio_text.setText(nomExcursio);



        // TODO: Fer canvis per no mostrar dades dummy
        Iterable<String> iterableActivitats = controller.getExcursio(nomExcursio).activitats();
        popularActivitats(iterableActivitats,nomExcursio);

    }

    private void popularActivitats(Iterable<String> iterableExcursions, String nomExcursio){
        List<Node> excursionsPaneChildren = activitats_pane.getChildren();

        double width = activitat_btn.getWidth();
        double height = activitat_btn.getHeight();
        double layoutX = activitat_btn.getLayoutX();
        double layoutY = activitat_btn.getLayoutY();
        //Instanciem un botó per cada activitat
        for (String excursio : iterableExcursions){
            // TODO: Fer canvis per no mostrar dades dummy
            Button new_btn = createActivitatButton(excursio, nomExcursio, width, height, layoutX, layoutY);
            excursionsPaneChildren.add(new_btn);
            layoutY += ESPAI_ENTRE_BOTONS;
        }
        //Actualitzem la mida del pane que conté els botons perque es pugui fer scroll cap abaix si hi ha més botons dels que caben al pane
        activitats_pane.setPrefHeight(layoutY);
        //Esborrem excursio_btn, que l'utlitzavem únicament com a referència per la mida dels botons
        excursionsPaneChildren.remove(activitat_btn);
    }

    /*
     * Crea un botó de dimensions width x height, colocat a la posició (layoutX, layoutY)
     * */
    private Button createActivitatButton(String activitat, String nomExcursio,  double width, double height, double layoutX, double layoutY){
        Button new_btn = new Button();
        new_btn.setPrefWidth(width);
        new_btn.setPrefHeight(height);
        new_btn.setText(activitat);
        new_btn.setLayoutX(layoutX);
        new_btn.setLayoutY(layoutY);
        new_btn.setAlignment(Pos.BASELINE_LEFT);
        new_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mostrarFinestraActivitat(activitat,nomExcursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return new_btn;
    }

    public void mostrarFinestraActivitat(String activitat, String nomExcursio) throws IOException {
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("activitat-view", activitat);
        EscenaActivitat escenaActivitat = ((EscenaActivitat)escena);
        escenaActivitat.setController(controller);
        escenaActivitat.setActivitat(activitat,nomExcursio);
    }
}
