package org.utl.dsm.dsm406_controlpacientes.Controller;

import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import org.utl.dsm.dsm406_controlpacientes.Model.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerLoginSucursal implements Initializable {
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPasword;
    @FXML
    private PasswordField txtUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Se agrega el evento EventHandler al botón exit.
        btnCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit();
            }
        });

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    login();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (UnirestException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        txtUser.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                txtPasword.requestFocus();
            }
        });

        txtPasword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    login();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (UnirestException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void exit() {
        System.exit(0);
    }

    public void login() throws IOException, UnirestException {
        String usuarioInexistente = "{\"Mensaje\":\"usuario inexistente\"}";
        String contraseniaIncorrecta = "{\"Mensaje\":\"Contrasenia incorrecta\"}";
        String user, password;
        user = txtUser.getText();
        password = txtPasword.getText();

        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/sicefa/api/inicioSesion/login")
                .queryString("nombreUsuario", user)
                .queryString("contrasenia", password)
                .asJson();

       // System.out.println(apiResponse.getBody().toString());
        String data = (apiResponse.getBody().toString());

        if (data.equals(usuarioInexistente)) {
            System.out.println("Usuario inexistente");
            //alert("Usuario inexistente");
            mostarAlerta("Contraseña o usuario incorrectos");
        } else if (data.equals(contraseniaIncorrecta)) {
            //alert("Contraseña incorrecta");
            System.out.println("Contraseña incorrecta");
            mostarAlerta("Contraseña o usuario incorrectos");
        } else {
            Gson gson = new Gson();
            Usuario usuarioResponse = gson.fromJson(data.toString(), Usuario.class);
            if ((!("ADMS").equals(usuarioResponse.rolUsuario)) && !(("EMPS").equals(usuarioResponse.rolUsuario))) {
                System.out.println("No tienes los permisos para ingresar a este sistema!");
                mostarAlerta("No tienes los permisos para ingresar a este sistema!");
            } else {
                System.out.println("Apunto de abrir inicio Sesión");
                cargarInicioSucursal();
            }
        }
    }

    public void cargarInicioSucursal() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_inicioSucursal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnLogin.getScene().getWindow();
        ventanaLogin.close();
    }

    private void mostarAlerta(String mensaje) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view_alertaError.fxml"));
        Parent root = loader.load();
        ControllerAlertaError controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Label lblTitulo = controller.getLblTitulo();
        lblTitulo.setText(mensaje);

        btnAceptar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton aceptar
            popup.hide();
        });

        popup.getContent().add(root);
        popup.show(btnLogin.getScene().getWindow());
    }
}
/*

            System.out.println("Credenicales válidas");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Main.class.getResource("view_inicioSucursal.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Medicamos tu vida");
            stage.show();
            // Para cerrar la ventana Login:
            Stage ventanaLogin =(Stage) btnLogin.getScene().getWindow();
            ventanaLogin.close();

    }
*/
