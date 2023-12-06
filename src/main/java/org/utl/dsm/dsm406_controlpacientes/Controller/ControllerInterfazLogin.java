package org.utl.dsm.dsm406_controlpacientes.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.utl.dsm.dsm406_controlpacientes.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInterfazLogin implements Initializable {
    @FXML private Button btnIniciarSesionCentral;
    @FXML private Button btnIniciarSesionSucursal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnIniciarSesionSucursal.setOnAction(event -> {
            try {
                iniciarSesionSucursal();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void iniciarSesionSucursal() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_login.fxml"));
        Scene scene = new Scene(root,400,250);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Medicamos tu Vida");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage ventanaLogin = (Stage) btnIniciarSesionSucursal.getScene().getWindow();
        ventanaLogin.close();
    }


}
