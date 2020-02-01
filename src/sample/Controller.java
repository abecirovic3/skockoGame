package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    public Label lab00;
    public Label lab01;
    public Label lab02;
    public Label lab03;

    @FXML
    public void initialize() {
        lab00.setStyle(null);
        lab00.getStyleClass().add("fullHit");
        lab01.getStyleClass().add("fullHit");
        lab02.getStyleClass().add("fullHit");
        lab03.getStyleClass().add("fullHit");
    }
}
