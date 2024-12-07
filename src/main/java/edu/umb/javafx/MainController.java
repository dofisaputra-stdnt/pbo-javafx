package edu.umb.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

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
    void calculateTemp(ActionEvent event) {
        double temp = Double.parseDouble(inputTemp.getText());
        double result = 0;

        if (rdrCelcius.isSelected()) {
            result = temp;
        } else if (rdrFahrenheit.isSelected()) {
            result = (temp * 9 / 5) + 32;
        } else if (rdrKelvin.isSelected()) {
            result = temp + 273.15;
        } else if (rdrReamur.isSelected()) {
            result = temp * 4 / 5;
        }

        outputTemp.setText(String.valueOf(result));
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

    @FXML
    void initialize() {
        detectTemp();
        detectInputTemp();

        ToggleGroup tempGroup = new ToggleGroup();
        rdrCelcius.setToggleGroup(tempGroup);
        rdrFahrenheit.setToggleGroup(tempGroup);
        rdrKelvin.setToggleGroup(tempGroup);
        rdrReamur.setToggleGroup(tempGroup);

        rdrCelcius.setSelected(true);
    }

    void detectTemp() {
        slideTemp.setMin(-100);
        slideTemp.setMax(100);
        slideTemp.setValue(0);
        inputTemp.setText("0");

        slideTemp.valueProperty().addListener((observable, oldValue, newValue) -> {
            inputTemp.setText(String.valueOf(newValue.intValue()));
        });
    }

    void detectInputTemp() {
        inputTemp.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                System.out.println(newValue);
                try {
                    inputTemp.setStyle("-fx-border-color: none;");
                    slideTemp.setValue(Double.parseDouble(newValue));
                } catch (NumberFormatException e) {
                    inputTemp.setStyle("-fx-border-color: red; -fx-border-width: 2;");
                }
            }
        });
    }

}
