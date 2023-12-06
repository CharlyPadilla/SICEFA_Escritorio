package org.utl.dsm.dsm406_controlpacientes.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAlertaAviso implements Initializable {
    @FXML private Button btnAceptar;
    @FXML private Button btnCancelar;
    @FXML private Label lblTitulo;

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public Label getLblTitulo() {
        return lblTitulo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
