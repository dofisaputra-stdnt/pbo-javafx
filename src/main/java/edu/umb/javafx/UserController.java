package edu.umb.javafx;

import edu.umb.javafx.service.DataService;
import edu.umb.javafx.util.DialogUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class UserController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnUpdate;

    @FXML
    private ChoiceBox<String> dropdownRole;

    @FXML
    private PasswordField txPassword;

    @FXML
    private PasswordField txRetypePassword;

    @FXML
    private TextField txUserId;

    @FXML
    private TextField txUsername;

    @FXML
    void cancelOperation(ActionEvent event) {
        clickedButton(btnCancel);
    }

    @FXML
    void findUser(ActionEvent event) {
        clickedButton(btnFind);
    }

    @FXML
    void newUser(ActionEvent event) {
        if (btnNew.getText().equals("Save")) {
            String username = txUsername.getText();
            String password = txPassword.getText();
            String retypePassword = txRetypePassword.getText();
            String role = dropdownRole.getValue();

            if (password.equals(retypePassword)) {
                DataService.insertUser(username, password, username + "@example.com", role);
                DialogUtil.showInfo("User has been created");
            } else {
                DialogUtil.showError("Password and retype password must be the same");
            }
        }
        clickedButton(btnNew);
    }

    @FXML
    void updateUser(ActionEvent event) {
        clickedButton(btnUpdate);
    }

    public void initialize() {
        dropdownRole.getItems().addAll(List.of("User", "Admin"));
        dropdownRole.setValue("User");
    }

    void clickedButton(Button button) {
        if (button == btnNew) {
            btnNew.setText("Save");
            btnUpdate.setDisable(true);
            btnFind.setDisable(true);
        } else if (button == btnUpdate) {
            btnUpdate.setText("Save");
            btnNew.setDisable(true);
            btnFind.setDisable(true);
        } else {
            btnNew.setText("New");
            btnUpdate.setText("Update");

            btnNew.setDisable(false);
            btnUpdate.setDisable(false);
            btnCancel.setDisable(false);
            btnFind.setDisable(false);
        }
    }

}
