package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalTime;

public class EndAlertController {
    public Label messageLabel;
    public Label solutionLabel;
    public Label timeLabel;
    public Label recordLabel;
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView img4;
    public Button btnOk;
    public TextField usernameFld;

    private int[] solutionList;
    private boolean win;
    private String elapsedTime;
    private ObservableList<Highscore> highscores;

    public EndAlertController(int[] solutionList, boolean win, String elapsedTime, ObservableList<Highscore> highscores) {
        this.solutionList = solutionList;
        this.win = win;
        this.elapsedTime = elapsedTime;
        this.highscores = highscores;
    }

    @FXML
    public void initialize() {
        setSolutionImages();
        setMessageLabelText();
        setTimeLabelTime();
        if (!isNewHighscore(elapsedTime)) {
            recordLabel.setVisible(false);
            usernameFld.setVisible(false);
        } else {
            recordLabel.setText("Cestitamo postavili ste novi rekord! Unesite vase ime:");
        }
    }

    private boolean isNewHighscore(String elapsedTime) {
        LocalTime lt = LocalTime.parse(elapsedTime);
        if (win && (highscores.isEmpty() || lt.isBefore(highscores.get(0).getTime())))
            return true;
        return false;
    }

    private void setTimeLabelTime() {
        timeLabel.setText(timeLabel.getText() + " " + elapsedTime);
    }

    private void setMessageLabelText() {
        if (win) messageLabel.setText("Bravo! Pogodili ste kombinaciju:");
        else messageLabel.setText("Nazalost niste pogodili kombinaciju:");
    }

    private void setSolutionImages() {
        img1.setImage(new Image(getImgSource(solutionList[0])));
        img2.setImage(new Image(getImgSource(solutionList[1])));
        img3.setImage(new Image(getImgSource(solutionList[2])));
        img4.setImage(new Image(getImgSource(solutionList[3])));
    }

    private String getImgSource(int identifier) {
        switch (identifier) {
            case 1:
                return "/img/854.png";
            case 2:
                return "/img/djetelina54.png";
            case 3:
                return "/img/list54.png";
            case 4:
                return "/img/srce54.png";
            case 5:
                return "/img/baklava54.png";
            case 6:
                return "/img/dijamant54.png";
        }
        return null;
    }

    public void closeAlertAction(ActionEvent actionEvent) {
        // need to update db
        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }
}
