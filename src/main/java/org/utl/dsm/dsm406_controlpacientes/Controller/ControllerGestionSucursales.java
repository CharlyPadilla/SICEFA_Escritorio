package org.utl.dsm.dsm406_controlpacientes.Controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import org.utl.dsm.dsm406_controlpacientes.Model.Sucursal;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerGestionSucursales implements Initializable {

    @FXML
    private Button btnBarraInicio;
    @FXML private Button btnBarraSucursales;
    @FXML private Button btnBarraProductos;
    @FXML private Button btnBarraPedidos;
    @FXML private MenuItem btnCerrarSesion;
    @FXML private MenuButton menuOpciones;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnModificar;
    @FXML private Button btnRegistrar;
    @FXML private TableView<Sucursal> tblRegistros;
    @FXML private TableColumn<Sucursal, Integer> tcolEstatus;
    @FXML private TableColumn<Sucursal, Integer> tcolId;
    @FXML private TableColumn<Sucursal, String> tcolNombre;
    @FXML private TableColumn<Sucursal, String> tcolTitular;
    @FXML private TextField txtBuscar;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtCodigoPostal;
    @FXML private TextField txtColonia;
    @FXML private TextField txtDomicilio;
    @FXML private TextField txtEstado;
    @FXML private TextField txtID;
    @FXML private TextField txtLatitud;
    @FXML private TextField txtLongitud;
    @FXML private TextField txtNombre;
    @FXML private TextField txtRfc;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtTitular;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBarraInicio.setOnAction(event -> {
            try {
                abrirInicio();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBarraSucursales.setOnAction(event -> {
            try {
                abrirModuloSucursales();
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

        btnBarraPedidos.setOnAction(event -> {
            try {
                abrirModuloPedidos();
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
                String nombreSucursal = txtNombre.getText();
                String titularSucursal = txtTitular.getText();
                String rfcSucursal = txtRfc.getText();
                String domicilioSucursal = txtRfc.getText();
                String coloniaSucursal = txtColonia.getText();
                String codigoPostalSucursal = txtCodigoPostal.getText();
                String ciudadSucursal = txtCiudad.getText();
                String estadoSucursal = txtEstado.getText();
                String telefonoSucursal = txtTelefono.getText();
                String latitudSucursal = txtLatitud.getText();
                String longitudSucursal = txtLongitud.getText();
                String datosSucursal = "{nombreSucursal="+"'"+nombreSucursal+"'"+", titularSucursal="+"'"+titularSucursal+"'"+", rfcSucursal="+"'"+rfcSucursal+"'"+", domicilioSucursal="+"'"+domicilioSucursal+"'"+", coloniaSucursal="+"'"+coloniaSucursal+"'"+", codigoPostalSucursal="+"'"+codigoPostalSucursal+"'"+", ciudadSucursal="+"'"+ciudadSucursal+"'"+", estadoSucursal="+"'"+estadoSucursal+"'"+", telefonoSucursal="+"'"+telefonoSucursal+"'"+", latitulSucursal="+"'"+latitudSucursal+"'"+", longitudSucursal="+"'"+longitudSucursal+"'"+"}";
                System.out.println("Datos de la sucursal que se va a registrar: "+datosSucursal);
                apiResponse1 = Unirest.post("http://localhost:8080/sicefa/api/sucursal/insertSucursal")
                        .field("datosSucursal",datosSucursal)
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
                int idSucursal = Integer.parseInt(txtID.getText());
                String nombreSucursal = txtNombre.getText();
                String titularSucursal = txtTitular.getText();
                String rfcSucursal = txtRfc.getText();
                String domicilioSucursal = txtRfc.getText();
                String coloniaSucursal = txtColonia.getText();
                String codigoPostalSucursal = txtCodigoPostal.getText();
                String ciudadSucursal = txtCiudad.getText();
                String estadoSucursal = txtEstado.getText();
                String telefonoSucursal = txtTelefono.getText();
                String latitudSucursal = txtLatitud.getText();
                String longitudSucursal = txtLongitud.getText();
                //Sucursal datosSucursal = new Sucursal(idSucursal,nombreSucursal,titularSucursal,rfcSucursal,domicilioSucursal,coloniaSucursal,codigoPostalSucursal,ciudadSucursal,estadoSucursal,telefonoSucursal,latitudSucursal,longitudSucursal);
                String datosSucursal = "{idSucursal="+idSucursal+", nombreSucursal="+"'"+nombreSucursal+"'"+", titularSucursal="+"'"+titularSucursal+"'"+", rfcSucursal="+"'"+rfcSucursal+"'"+", domicilioSucursal="+"'"+domicilioSucursal+"'"+", coloniaSucursal="+"'"+coloniaSucursal+"'"+", codigoPostalSucursal="+"'"+codigoPostalSucursal+"'"+", ciudadSucursal="+"'"+ciudadSucursal+"'"+", estadoSucursal="+"'"+estadoSucursal+"'"+", telefonoSucursal="+"'"+telefonoSucursal+"'"+", latitulSucursal="+"'"+latitudSucursal+"'"+", longitudSucursal="+"'"+longitudSucursal+"'"+"}";
                System.out.println("Datos de la sucursal que se va a registrar: "+datosSucursal);
                apiResponse1 = Unirest.post("http://localhost:8080/sicefa/api/sucursal/updateSucursal")
                        .field("datosSucursal",datosSucursal)
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
        Parent root = FXMLLoader.load(Main.class.getResource("view_inicioCentral.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraInicio.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloSucursales() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionSucursales.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraSucursales.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloProductos() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionProductos.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraProductos.getScene().getWindow();
        ventanaLogin.close();
    }

    private void abrirModuloPedidos() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("view_gestionPedidos.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Medicamos tu vida");
        stage.show();
        // Para cerrar la ventana Login:
        Stage ventanaLogin = (Stage) btnBarraPedidos.getScene().getWindow();
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
        apiResponse = Unirest.get("http://localhost:8080/sicefa/api/sucursal/getAll").asJson();
        alert = new Alert(Alert.AlertType.INFORMATION,
                "Mensaje: ");
        String registros = apiResponse.getBody().toString();
        Sucursal[] arraySucursal = gson.fromJson(registros,Sucursal[].class);
        System.out.println(arraySucursal[0].toString());
        System.out.println(registros);
        ArrayList<Sucursal> listaSucursales = new ArrayList<>(Arrays.asList(arraySucursal));
        ObservableList<Sucursal> registrosSucursal = FXCollections.observableArrayList(listaSucursales);
        tblRegistros.setItems(registrosSucursal);
        tcolNombre.setCellValueFactory(new PropertyValueFactory<>("nombreSucursal"));
        tcolTitular.setCellValueFactory(new PropertyValueFactory<>("titularSucursal"));
        tcolId.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
        tcolEstatus.setCellValueFactory(new PropertyValueFactory<>("estatusSucursal"));
    }

    public void limpiar(){
        txtNombre.setText("");
        txtTitular.setText("");
        txtRfc.setText("");
        txtDomicilio.setText("");
        txtColonia.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
        txtCodigoPostal.setText("");
        txtTelefono.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
        txtID.setText("");
    }

    private void mostrarInfoEmpleado(Sucursal sucursal) {
        txtID.setText(String.valueOf((sucursal.getIdSucursal())));
        txtNombre.setText(sucursal.getNombreSucursal());
        txtTitular.setText(sucursal.getTitularSucursal());
        txtRfc.setText(sucursal.getRfcSucursal());
        txtDomicilio.setText(sucursal.getDomicilioSucursal());
        txtColonia.setText(sucursal.getColoniaSucursal());
        txtCiudad.setText(sucursal.getCiudadSucursal());
        txtCodigoPostal.setText(sucursal.getCodigoPostalSucursal());
        txtEstado.setText(sucursal.getEstadoSucursal());
        txtTelefono.setText(sucursal.getTelefonoSucursal());
        txtLatitud.setText(sucursal.getLatitulSucursal());
        txtLongitud.setText(sucursal.getLongitudSucursal());
    }
}
