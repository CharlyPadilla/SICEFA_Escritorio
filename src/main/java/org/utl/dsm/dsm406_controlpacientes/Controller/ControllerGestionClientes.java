package org.utl.dsm.dsm406_controlpacientes.Controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import org.utl.dsm.dsm406_controlpacientes.Model.Cliente;
import org.utl.dsm.dsm406_controlpacientes.Model.Persona;

public class ControllerGestionClientes implements Initializable {

    @FXML private Button btnBarraInicio;
    @FXML private Button btnBarraClientes;
    @FXML private Button btnBarraEmpleados;
    @FXML private Button btnBarraCompras;
    @FXML private Button btnBarraProductos;
    @FXML private Button btnBarraVentas;
    @FXML private MenuButton menuOpciones;
    @FXML private MenuItem btnCerrarSesion;

    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnModificar;
    @FXML private Button btnRegistrar;

    @FXML private TableView<Cliente> tblRegistros;
    @FXML private TableColumn<Cliente, String> tcolApellidoM;
    @FXML private TableColumn<Cliente, String> tcolApellidoP;
    @FXML private TableColumn<Cliente, String> tcolEstatus;
    @FXML private TableColumn<Cliente, String> tcolNombre;
    @FXML private TextField txtApellidoM;
    @FXML private TextField txtApellidoP;
    @FXML private TextField txtBuscar;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtCodigoPostal;
    @FXML private TextField txtColonia;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtCurp;
    @FXML private TextField txtDomicilio;
    @FXML private TextField txtEstado;
    @FXML private DatePicker txtFechaNac;
    @FXML private TextField txtFoto;
    @FXML private TextField txtGenero;
    @FXML private TextField txtID;
    @FXML private TextField txtNombre;
    @FXML private TextField txtRfc;
    @FXML private TextField txtTelefono;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnBarraInicio.setOnAction(event -> {
            try {
                abrirInicio();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraClientes.setOnAction(event -> {
            try {
                abrirModuloClientes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraEmpleados.setOnAction(event -> {
            try {
                abrirModuloEmpleados();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraProductos.setOnAction(event -> {
            try {
                abrirModuloProductos();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraCompras.setOnAction(event -> {
            try {
                abrirModuloCompras();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraVentas.setOnAction(event -> {
            try {
                abrirModuloVentas();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnCerrarSesion.setOnAction(event -> {
            try {
                cerrarSesion();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



        Gson gson = new Gson();
        HttpResponse<JsonNode> apiResponse = null;
        Alert alert = null;
        try {
            cargarTabla();
        } catch (Exception ex) {
            ex.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR,
                    "Error en la peticion");
            alert.show();
        }

        btnRegistrar.setOnAction(event -> {
            HttpResponse<JsonNode> apiResponse2 = null;
            Alert alert2 = null;
            try {
                Persona p = new Persona();
                p.setNombrePersona(txtNombre.getText());
                p.setApellidoPaternoPersona(txtApellidoP.getText());
                p.setApellidoMaternoPersona(txtApellidoM.getText());
                p.setCiudadPersona(txtCiudad.getText());
                p.setCodigoPostalPersona(txtCodigoPostal.getText());
                p.setColoniaPersona(txtColonia.getText());
                p.setCurpPersona(txtCurp.getText());
                p.setDomicilioPersona(txtDomicilio.getText());
                p.setEstadoPersona(txtEstado.getText());
                p.setFechaNacimientoPersona(txtFechaNac.getValue().toString());
                p.setFotoPersona(txtFoto.getText());
                p.setGeneroPersona(txtGenero.getText());
                p.setRfcPersona(txtRfc.getText());
                p.setTelefonoPersona(txtTelefono.getText());

                Cliente c = new Cliente();
                c.setPersonaCliente(p);
                c.setEmailCliente(txtCorreo.getText());

                String params = gson.toJson(c);

                apiResponse2 = Unirest.post("http://localhost:8080/sicefa/api/cliente/insertCliente")
                        .field("datosCliente", params)
                        .asJson();

                alert2 = new Alert(Alert.AlertType.CONFIRMATION,
                        "Datos ingresados correctamente");
                alert2.show();
                cargarTabla();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(apiResponse2.getBody().toString());
                alert2 = new Alert(Alert.AlertType.ERROR,
                        "Error en la petición");
                alert2.show();
            }
        });
    }


    private void abrirInicio() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load (Main.class.getResource("view_inicioSucursal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraInicio.getScene().getWindow();
        ventanaLogin.close();
    }


    private void abrirModuloEmpleados() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionEmpleados.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraEmpleados.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloClientes() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionClientes.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraClientes.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloProductos() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_busquedaProductos.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraProductos.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloCompras() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionCompras.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraCompras.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloVentas() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionVentas.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraVentas.getScene().getWindow();
        ventanaLogin.close();
    }

    private void cerrarSesion() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load (Main.class.getResource("view_principal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) menuOpciones.getScene().getWindow();
        ventanaLogin.close();
    }



    public void cargarTabla() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = null;
        Alert alert = null;
        Gson gson = new Gson();
        apiResponse = Unirest.get("http://localhost:8080/sicefa/api/cliente/getAll").asJson();
        alert = new Alert(Alert.AlertType.INFORMATION,
                "Mensaje: ");
        String registros = apiResponse.getBody().toString();
        Cliente[] arrayPersona = gson.fromJson(registros,Cliente[].class);
        System.out.println(arrayPersona[0].toString());
        System.out.println(registros);
        ArrayList<Cliente> listaPersona = new ArrayList<>(Arrays.asList(arrayPersona));
        ObservableList<Cliente> registrosPersona = FXCollections.observableArrayList(listaPersona);
        tblRegistros.setItems(registrosPersona);
        tcolNombre.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getNombrePersona()));
        tcolApellidoP.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getApellidoPaternoPersona()));
        tcolApellidoM.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getApellidoMaternoPersona()));
        tcolEstatus.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getTelefonoPersona()));
    }
}