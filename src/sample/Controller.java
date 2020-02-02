package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Label lab00;
    public Label lab01;
    public Label lab02;
    public Label lab03;
    public Label lab10;
    public Label lab11;
    public Label lab12;
    public Label lab13;
    public Label lab20;
    public Label lab21;
    public Label lab22;
    public Label lab23;
    public Label lab30;
    public Label lab31;
    public Label lab32;
    public Label lab33;
    public Label lab40;
    public Label lab41;
    public Label lab42;
    public Label lab43;
    public Label lab50;
    public Label lab51;
    public Label lab52;
    public Label lab53;

    public Button btnBall;
    public Button btnShamrock;
    public Button btnLeaf;
    public Button btnHeart;
    public Button btnSquare;
    public Button btnDiamond;
    public Button btnOk;

    public Button btn00;
    public Button btn01;
    public Button btn02;
    public Button btn03;
    public Button btn10;
    public Button btn11;
    public Button btn12;
    public Button btn13;
    public Button btn20;
    public Button btn21;
    public Button btn22;
    public Button btn23;
    public Button btn30;
    public Button btn31;
    public Button btn32;
    public Button btn33;
    public Button btn40;
    public Button btn41;
    public Button btn42;
    public Button btn43;
    public Button btn50;
    public Button btn51;
    public Button btn52;
    public Button btn53;


    @FXML
    public void initialize() {
//        lab00.setStyle(null);
//        lab00.getStyleClass().add("fullHit");
//        lab01.getStyleClass().add("fullHit");
//        lab02.getStyleClass().add("fullHit");
//        lab03.getStyleClass().add("fullHit");
    }

    public void test(ActionEvent actionEvent) {
//        btnTest.setStyle(null);
        btn00.setStyle("-fx-background-image: url(\"/img/list54.png\");" +
                "-fx-background-repeat: no-repeat;\n" +
                "-fx-background-position:center;" +
                "-fx-background-color: white;");
    }

    public void remove(ActionEvent actionEvent) {
        btn00.setStyle("-fx-background-color: white; -fx-border-color: lightblue;");
    }
}
