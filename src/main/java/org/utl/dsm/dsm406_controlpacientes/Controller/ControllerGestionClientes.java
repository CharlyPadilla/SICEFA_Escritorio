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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import org.utl.dsm.dsm406_controlpacientes.Model.Cliente;
import org.utl.dsm.dsm406_controlpacientes.Model.Persona;
import org.utl.dsm.dsm406_controlpacientes.Model.Sucursal;

public class ControllerGestionClientes implements Initializable {

    @FXML
    private Button btnBarraClientes;

    @FXML
    private Button btnBarraCompras;

    @FXML
    private Button btnBarraEmpleados;

    @FXML
    private Button btnBarraInicio;

    @FXML
    private Button btnBarraProductos;

    @FXML
    private Button btnBarraVentas;

    @FXML
    private MenuItem btnCerrarSesion;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private MenuButton menuOpciones;

    @FXML
    private TableView<Cliente> tblRegistros;

    @FXML
    private TableColumn<Cliente, String> tcloApellidoP;

    @FXML
    private TableColumn<Cliente, String> tcolApellidoM;

    @FXML
    private TableColumn<Cliente, Integer> tcolId;

    @FXML
    private TableColumn<Cliente, String> tcolNombre;

    @FXML
    private TextField txtApellidoM;

    @FXML
    private TextField txtApellidoP;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtCodigoPostal;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtCurp;

    @FXML
    private TextField txtDomicilio;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtFechaNac;

    @FXML
    private TextField txtFoto;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtRfc;

    @FXML
    private TextField txtTelefono;


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

        tblRegistros.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarInfoEmpleado(newValue);
            }
        });

        Gson gson = new Gson();
        Alert alert = null;
        try{
            cargarTabla();
        }catch (Exception ex){
            ex.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR,
                    "Error en la peticion");
            alert.show();
        }

        btnRegistrar.setOnAction(event -> {
            HttpResponse<JsonNode> apiResponse1 = null;
            Alert alert1 = null;
            try{
                String nombreCliente = txtNombre.getText();
                String apellidoP = txtApellidoP.getText();
                String apellidoM = txtApellidoM.getText();
                String generoCliente = txtGenero.getText();
                String fechaNac = txtFechaNac.getText();
                String rfc = txtRfc.getText();
                String curp = txtCurp.getText();
                String foto = txtFoto.getText();
                String domicilio = txtDomicilio.getText();
                String codigoPostal = txtCodigoPostal.getText();
                String ciudad = txtCiudad.getText();
                String estado = txtEstado.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String datosCliente = "{emailCliente="+"'"+correo+"'"+", personaCliente{ nombrePersona="+"'"+nombreCliente+"'"+", apellidoPaternoPersona="+"'"+apellidoP+"'"+", apellidoMaternoPersona="+"'"+apellidoM+"'"+", generoPersona="+"'"+generoCliente+"'"+", fechaNacimientoPersona="+"'"+fechaNac+"'"+", rfcPersona="+"'"+rfc+"'"+", curpPersona="+"'"+curp+"'"+", domicilioPersona="+"'"+domicilio+"'"+", codigoPostalPersona="+"'"+codigoPostal+"'"+", ciudadPersona="+"'"+ciudad+"'"+", estadoPersona="+"'"+estado+"'"+", telefonoPersona="+"'"+telefono+"'"+", fotoPersona="+"'"+foto+"'"+"}}";
                System.out.println("Datos del cliente que se va a registrar: "+datosCliente);
                apiResponse1 = Unirest.post("http://localhost:8080/sicefa/api/cliente/insertCliente")
                        .field("datosSucursal",datosCliente)
                        .asJson();
                alert1 = new Alert(Alert.AlertType.CONFIRMATION,
                        "Datos ingresados correctamente");
                alert1.show();
                cargarTabla();
                limpiar();
            }catch (Exception ex){
                ex.printStackTrace();
                alert1 = new Alert(Alert.AlertType.ERROR,
                        "Error en la peticion");
                alert1.show();
            }
        });

        btnModificar.setOnAction(event -> {
            HttpResponse<JsonNode> apiResponse1 = null;
            Alert alert1 = null;
            try{
                int idCliente = Integer.parseInt(txtID.getText());
                String nombreCliente = txtNombre.getText();
                String apellidoP = txtApellidoP.getText();
                String apellidoM = txtApellidoM.getText();
                String generoCliente = txtGenero.getText();
                String fechaNac = txtFechaNac.getText();
                String rfc = txtRfc.getText();
                String curp = txtCurp.getText();
                String foto = txtFoto.getText();
                String domicilio = txtDomicilio.getText();
                String codigoPostal = txtCodigoPostal.getText();
                String ciudad = txtCiudad.getText();
                String estado = txtEstado.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String datosCliente = "{idCliente="+idCliente+", emailCliente="+"'"+correo+"'"+", personaCliente{ nombrePersona="+"'"+nombreCliente+"'"+", apellidoPaternoPersona="+"'"+apellidoP+"'"+", apellidoMaternoPersona="+"'"+apellidoM+"'"+", generoPersona="+"'"+generoCliente+"'"+", fechaNacimientoPersona="+"'"+fechaNac+"'"+", rfcPersona="+"'"+rfc+"'"+", curpPersona="+"'"+curp+"'"+", domicilioPersona="+"'"+domicilio+"'"+", codigoPostalPersona="+"'"+codigoPostal+"'"+", ciudadPersona="+"'"+ciudad+"'"+", estadoPersona="+"'"+estado+"'"+", telefonoPersona="+"'"+telefono+"'"+", fotoPersona="+"'"+foto+"'"+"}}";
                System.out.println("Datos del cliente que se va a registrar: "+datosCliente);
                apiResponse1 = Unirest.post("http://localhost:8080/sicefa/api/cliente/updateCliente")
                        .field("datosSucursal",datosCliente)
                        .asJson();
                alert1 = new Alert(Alert.AlertType.CONFIRMATION,
                        "Datos actualizados correctamente");
                alert1.show();
                cargarTabla();
                limpiar();
            }catch (Exception ex){
                ex.printStackTrace();
                alert1 = new Alert(Alert.AlertType.ERROR,
                        "Error en la peticion");
                alert1.show();
            }
        });

        btnEliminar.setOnAction(event -> {
            HttpResponse<JsonNode> apiResponse1 = null;
            Alert alert1 = null;
            try{
                int idSucursal = Integer.parseInt(txtID.getText());
                System.out.println("id de la sucursal que se va a registrar: "+idSucursal);
                apiResponse1 = Unirest.post("http://localhost:8080/sicefa/api/sucursal/deleteSucursal")
                        .field("idSucursal",idSucursal)
                        .asJson();
                alert1 = new Alert(Alert.AlertType.CONFIRMATION,
                        "Sucursal eliminada correctamente");
                alert1.show();
                cargarTabla();
                limpiar();
            }catch (Exception ex){
                ex.printStackTrace();
                alert1 = new Alert(Alert.AlertType.ERROR,
                        "Error en la peticion");
                alert1.show();
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
        Gson gson = new Gson();
        HttpResponse<JsonNode> apiResponse = null;
        Alert alert = null;
        apiResponse = Unirest.get("http://localhost:8080/sicefa/api/cliente/getAll").asJson();
        alert = new Alert(Alert.AlertType.INFORMATION,
                "Mensaje: ");
        String registros = apiResponse.getBody().toString();
        Cliente[] arrayCliente = gson.fromJson(registros,Cliente[].class);
        System.out.println(arrayCliente[0].toString());
        System.out.println(registros);
        ArrayList<Cliente> listaClientes = new ArrayList<>(Arrays.asList(arrayCliente));
        ObservableList<Cliente> registrosCliente = FXCollections.observableArrayList(listaClientes);
        tblRegistros.setItems(registrosCliente);
        tcolNombre.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getNombrePersona()));
        tcolApellidoM.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getApellidoMaternoPersona()));
        tcolId.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getIdCliente()));
        tcloApellidoP.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaCliente().getApellidoPaternoPersona()));
    }

    public void limpiar(){
        txtID.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtGenero.setText("");
        txtFechaNac.setText("");
        txtRfc.setText("");
        txtCurp.setText("");
        txtFoto.setText("");
        txtDomicilio.setText("");
        txtCodigoPostal.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

    private void mostrarInfoEmpleado(Cliente cliente) {
        txtID.setText(String.valueOf((cliente.getIdCliente())));
        txtNombre.setText(cliente.getPersonaCliente().getNombrePersona());
        txtApellidoP.setText(cliente.getPersonaCliente().getApellidoPaternoPersona());
        txtApellidoM.setText(cliente.getPersonaCliente().getApellidoMaternoPersona());
        txtGenero.setText(cliente.getPersonaCliente().getGeneroPersona());
        txtFechaNac.setText(cliente.getPersonaCliente().getFechaNacimientoPersona());
        txtRfc.setText(cliente.getPersonaCliente().getRfcPersona());
        txtCurp.setText(cliente.getPersonaCliente().getCurpPersona());
        txtFoto.setText(cliente.getPersonaCliente().getFotoPersona());
        txtDomicilio.setText(cliente.getPersonaCliente().getDomicilioPersona());
        txtCodigoPostal.setText(cliente.getPersonaCliente().getCodigoPostalPersona());
        txtCiudad.setText(cliente.getPersonaCliente().getCiudadPersona());
        txtEstado.setText(cliente.getPersonaCliente().getEstadoPersona());
        txtTelefono.setText(cliente.getPersonaCliente().getTelefonoPersona());
        txtCorreo.setText(cliente.getEmailCliente());
    }

}