package com.jojo.controller;

import com.jojo.entity.PlayerEntity;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SquidController {
    @FXML
    private TextField txtPemberiUtang;
    @FXML
    private TextField txtJumlah;
    @FXML
    private Button btnTambahData;
    @FXML
    private Button btnHapusHutang;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnHapusPemain;
    @FXML
    private ComboBox<PlayerEntity> cmbPeserta;
    @FXML
    private TableView<PlayerEntity> tablePemain;
    @FXML
    private TableView<PlayerEntity> tableHutang;



}
