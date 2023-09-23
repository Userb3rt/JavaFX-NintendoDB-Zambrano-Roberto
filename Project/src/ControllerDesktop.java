import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerDesktop implements Initializable{
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private VBox yPane;

    @FXML
    private AnchorPane info;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        // Agrego las opciones al Choicebox
        choiceBox.getItems().addAll(opcions);
        //seleccionamos la primera opción
        choiceBox.setValue(opcions[0]);
        //
        choiceBox.setOnAction((event) -> { loadList(); });
        loadList();
    }

    public void loadList() {
        String opcio = choiceBox.getValue();
        System.out.println(opcio);
        }
        

}

