package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashMap;

public class GameController {
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

    private int activeLine = 0;
    private int[] inputList = new int[4];

    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
        for(int i=0; i<4; i++) {
            model.getInputList()[i] = -1;
        }
    }

    @FXML
    public void initialize() {
    }

    private void inputRegistration(Button btn1, Button btn2, Button btn3, Button btn4, int identifier) {

        int emptyIndex = firstEmptyIndex();
        if (emptyIndex == -2)
            return;

        Button button = new Button();

        model.getInputList()[emptyIndex] = identifier;

        switch (emptyIndex) {
            case 0:
                button = btn1;
                break;
            case 1:
                button = btn2;
                break;
            case 2:
                button = btn3;
                break;
            case 3:
                button = btn4;
                break;
        }

        String imageSource = "";

        switch (identifier) {
            case 1:
                imageSource = "/img/854.png";
                break;
            case 2:
                imageSource = "/img/djetelina54.png";
                break;
            case 3:
                imageSource = "/img/list54.png";
                break;
            case 4:
                imageSource = "/img/srce54.png";
                break;
            case 5:
                imageSource = "/img/baklava54.png";
                break;
            case 6:
                imageSource = "/img/dijamant54.png";
                break;
        }

        button.setStyle("-fx-background-image: url(\"" + imageSource + "\");" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-position:center;" +
                "-fx-background-color: white;");
    }

    private int firstEmptyIndex() {
        for (int i=0; i<4; i++) {
            if (model.getInputList()[i] == -1)
                return i;
        }
        return -2;
    }

    public void inputAction(ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();

        int identifier = 1;

        if (button == btnShamrock)
            identifier = 2;
        else if (button == btnLeaf)
            identifier = 3;
        else if (button == btnHeart)
            identifier = 4;
        else if (button == btnSquare)
            identifier = 5;
        else if (button == btnDiamond)
            identifier = 6;

        switch (activeLine) {
            case 0:
                inputRegistration(btn00, btn01, btn02, btn03, identifier);
                break;
            case 1:
                inputRegistration(btn10, btn11, btn12, btn13, identifier);
                break;
            case 2:
                inputRegistration(btn20, btn21, btn22, btn23, identifier);
                break;
            case 3:
                inputRegistration(btn30, btn31, btn32, btn33, identifier);
                break;
            case 4:
                inputRegistration(btn40, btn41, btn42, btn43, identifier);
                break;
            case 5:
                inputRegistration(btn50, btn51, btn52, btn53, identifier);
                break;
        }
    }

    private Label getLabel(Label label1, Label label2, Label label3, Label label4, int i) {
        Label label = new Label();
        switch (i) {
            case 0:
                label = label1;
                break;
            case 1:
                label = label2;
                break;
            case 2:
                label = label3;
                break;
            case 3:
                label = label4;
                break;
        }
        return label;
    }

    private void fillLabels (Label label1, Label label2, Label label3, Label label4, int fullHits, int halfHits) {
        // full hits loop
        for (int i=0; i<fullHits; i++) {
            Label label = getLabel(label1, label2, label3, label4, i);
            label.setStyle(null);
            label.getStyleClass().add("fullHit");
        }

        // half hits loop
        for (int i = fullHits; i < fullHits + halfHits; i++) {
            Label label = getLabel(label1, label2, label3, label4, i);
            label.setStyle(null);
            label.getStyleClass().add("halfHit");
        }
    }

    public void validateAction(ActionEvent actionEvent) {
        if (firstEmptyIndex() != -2) return;

        //validate input...
        HashMap<String, Integer> result = model.validateInput();
        int fullHits = result.get("fullHits"), halfHits = result.get("halfHits");
//        System.out.println("puni : " + fullHits + " pola: " + halfHits);
        switch (activeLine) {
            case 0:
                fillLabels(lab00, lab01, lab02, lab03, fullHits, halfHits);
                break;
            case 1:
                fillLabels(lab10, lab11, lab12, lab13, fullHits, halfHits);
                break;
            case 2:
                fillLabels(lab20, lab21, lab22, lab23, fullHits, halfHits);
                break;
            case 3:
                fillLabels(lab30, lab31, lab32, lab33, fullHits, halfHits);
                break;
            case 4:
                fillLabels(lab40, lab41, lab42, lab43, fullHits, halfHits);
                break;
            case 5:
                fillLabels(lab50, lab51, lab52, lab53, fullHits, halfHits);
                break;
        }

        for(int i=0; i<4; i++)
            model.getInputList()[i] = -1;

        if (fullHits == 4) {
            showEndAlert(true);
            return;
        }

        activeLine++;

        if (activeLine == 6) {
            activeLine = 0;
            showEndAlert(false);
        }
    }

    private void showEndAlert(Boolean win) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (win)
            alert.setHeaderText("Cestitam roki!");
        if (!win)
            alert.setHeaderText("Coukao si role moj");
        alert.show();
    }

    public void recoverAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        int index = 0;

        if (button == btn01 || button == btn11 || button == btn21 || button == btn31 || button == btn41 || button == btn51)
            index = 1;
        else if (button == btn02 || button == btn12 || button == btn22 || button == btn32 || button == btn42 || button == btn52)
            index = 2;
        else if (button == btn03 || button == btn13 || button == btn23 || button == btn33 || button == btn43 || button == btn53)
            index = 3;

        model.getInputList()[index] = -1;

        button.setStyle(null);
        button.setStyle("-fx-background-color: white;");
    }
}
