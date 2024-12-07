package edu.umb.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MainController {

    @FXML
    private Button btnExecute;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnGreen;

    @FXML
    private Button btnRed;

    @FXML
    private Button btnUbahPanel1;

    @FXML
    private Button btnUbahPanel2;

    @FXML
    private Button btnVisible;

    @FXML
    private TextField inputTemp;

    @FXML
    private TextField outputTemp;

    @FXML
    private Pane panel1;

    @FXML
    private Pane panel2;

    @FXML
    private Pane panelGreen;

    @FXML
    private Pane panelRed;

    @FXML
    private RadioButton rdrCelcius;

    @FXML
    private RadioButton rdrFahrenheit;

    @FXML
    private RadioButton rdrKelvin;

    @FXML
    private RadioButton rdrReamur;

    @FXML
    private Slider slideTemp;

    @FXML
    private Text txValue;

    @FXML
    void calculateTemp(ActionEvent event) {

    }

    @FXML
    void detectTemp(MouseEvent event) {
        // change the value of the text based on the slider value from 0 to 100
        txValue.setText(String.valueOf(slideTemp.getValue()));
    }

    @FXML
    void exitApp(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void changePanel1(ActionEvent event) {
        if (panel1.getStyle().equals("-fx-background-color: blue;")) {
            panel1.setStyle("-fx-background-color: yellow;");
        } else {
            panel1.setStyle("-fx-background-color: blue;");
        }
    }

    @FXML
    void changePanel2(ActionEvent event) {
        if (panel2.getStyle().equals("-fx-background-color: orange;")) {
            panel2.setStyle("-fx-background-color: black;");
        } else {
            panel2.setStyle("-fx-background-color: orange;");
        }
    }

    @FXML
    void visiblePanelGreen(ActionEvent event) {
        panelGreen.setVisible(true);
    }

    @FXML
    void visiblePanelRed(ActionEvent event) {
        panelRed.setVisible(true);
    }

    @FXML
    void visiblePanelRedGreen(ActionEvent event) {
        panelRed.setVisible(false);
        panelGreen.setVisible(false);
    }

}
