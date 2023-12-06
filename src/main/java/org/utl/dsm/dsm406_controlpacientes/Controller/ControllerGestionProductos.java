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
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.utl.dsm.dsm406_controlpacientes.Model.Producto;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerGestionProductos implements Initializable {

    @FXML private Button btnBarraInicio;
    @FXML private Button btnBarraSucursales;
    @FXML private Button btnBarraProductos;
    @FXML private Button btnBarraPedidos;
    @FXML private MenuItem btnCerrarSesion;
    @FXML private MenuButton menuOpciones;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField precioCompra;
    @FXML
    private TextField precioVenta;
    @FXML
    private TableView<Producto> tblRegistrosProductos;
    @FXML
    private TableColumn<Producto, String> tcolFormaFarmaceutica;
    @FXML
    private TableColumn<Producto, Integer> tcolIdProducto;
    @FXML
    private TableColumn<Producto, String> tcolNombreGenerico;
    @FXML
    private TableColumn<Producto, String> tcolPrecioVenta;

    @FXML
    private TableColumn<Producto, String> tcolEstatus;


    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtCodigoBarras;

    @FXML
    private TextField txtConcentracion;

    @FXML
    private TextField txtContraindicaciones;

    @FXML
    private TextField txtFormaFarmaceutica;

    @FXML
    private TextField txtIdProductos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreGenerico;

    @FXML
    private TextField txtPresentacion;

    @FXML
    private TextField txtPrincipalIndicacion;

    @FXML
    private TextField txtUnidadDeMedida;

    @FXML
    private TextField txtUnidadEnvase;



    public void getAll() throws UnirestException {
        System.out.println("Recuperando registros mediante metodo Post");
        HttpResponse<JsonNode> respuestaServidor = Unirest.get("http://localhost:8080/moduloProductosSeparado/producto/GestionProductos/registros").asJson();
        String registros = respuestaServidor.getBody().toString();
        System.out.println(registros);
        Gson gson = new Gson(); // Para convertir Json a objetos

        // Convertir el JSON a un array de Productos

        /*  Gson maneja automáticamente la creación del array basándose en la cantidad de elementos
        encontrados en el JSON. */

        Producto[] arrayProductos = gson.fromJson(registros, Producto[].class);
        /*
        El primer argumento, registros, es la cadena JSON que se va a convertir en objetos Producto

        El segundo argumento, Producto[].class, es la clase que Gson utiliza como tipo de destino al
        convertir el JSON. En este caso, le estás diciendo a Gson que el resultado debe ser un array ([])
         de objetos de tipo Producto.
         */


        // Convertir el array de Productos a un ArrayList
        ArrayList<Producto> listProductos = new ArrayList<>(Arrays.asList(arrayProductos));

        // Iterar sobre la lista usando forEach, para agregar el estatus de inactivo o activo
        for (Producto registro :listProductos) {
            if (registro.getEstatus()==1){
                registro.setEstatusCadena("Activo");
            }else {
                registro.setEstatusCadena("Inactivo");
            }
        }

        ObservableList<Producto> registrosProductos = FXCollections.observableArrayList(listProductos);

        tblRegistrosProductos.setItems(registrosProductos);

    }



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
 
        try {
            getAll();
        } catch (UnirestException e) {
            System.out.println(e.getMessage());
        }

        tcolIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        tcolNombreGenerico.setCellValueFactory(new PropertyValueFactory<>("nombreGenerico"));
        tcolPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        tcolFormaFarmaceutica.setCellValueFactory(new PropertyValueFactory<>("formaFarmaceutica"));
        tcolEstatus.setCellValueFactory(new PropertyValueFactory<>("estatusCadena"));

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
}
