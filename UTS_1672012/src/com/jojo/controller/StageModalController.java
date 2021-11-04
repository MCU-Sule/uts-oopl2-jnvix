package com.jojo.controller;

import com.jojo.entity.PlayerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

/**
 * @author Jonathan-1672012
 */
public class StageModalController {
    @FXML
    private Label lblId;
    @FXML
    private Label lblNama;
    @FXML
    private Label lblUmur;
    @FXML
    private Label lblKeahlian;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtUmur;
    @FXML
    private TextArea txtKeahlian;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    @FXML
    private void saveAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty() || txtUmur.getText().trim().isEmpty() || txtKeahlian.getText().trim().isEmpty()){
            Alert alert  = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill id, name, age and skill");
            alert.showAndWait();
        }else {
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setId(txtId.getText().trim());
            playerEntity.setNama(txtNama.getText().trim());
            playerEntity.setUmur(txtUmur.getText().trim());
            playerEntity.setKeahlian(txtKeahlian.getText().trim());
        }
    }
}
