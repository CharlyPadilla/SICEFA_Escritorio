package org.utl.dsm.dsm406_controlpacientes.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAlertaError {
    @FXML
    private Label lblTitulo;
    @FXML private Button btnAceptar;
   // @FXML private Button btnCancelar;

    public Label getLblTitulo() {
        return lblTitulo;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }


}
