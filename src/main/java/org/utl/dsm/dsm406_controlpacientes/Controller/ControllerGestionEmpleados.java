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
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.utl.dsm.dsm406_controlpacientes.Main;
import org.utl.dsm.dsm406_controlpacientes.Model.Empleado;
import org.utl.dsm.dsm406_controlpacientes.Model.Persona;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerGestionEmpleados implements Initializable {
    @FXML private Button btnBarraClientes;
    @FXML private Button btnBarraEmpleados;
    @FXML private Button btnBarraInicio;
    @FXML private Button btnBarraCompras;
    @FXML private Button btnBarraProductos;
    @FXML private Button btnBarraVentas;
    @FXML private MenuButton menuOpciones;
    @FXML private MenuItem btnCerrarSesion;

    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnModificar;
    @FXML private Button btnRegistrar;

    @FXML private TableView<Empleado> tblRegistros;
    @FXML private TableColumn<Empleado, String> tcolNombre;
    @FXML private TableColumn<Empleado, String> tcolApellidoM;
    @FXML private TableColumn<Empleado, String> tcolApellidoP;
    @FXML private TableColumn<Empleado, Integer> tcolTelefono;

    @FXML private TextField txtApellidoM;
    @FXML private TextField txtApellidoP;
    @FXML private TextField txtBuscar;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtCodigoPostal;
    @FXML private TextField txtSalarioBruto;
    @FXML private TextField txtPuesto;
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
                abrirModuloBuscarProductos();
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

        btnModificar.setDisable(true);
        btnModificar.setOnAction(event -> {
            try {
                mostarAvisoModificar("¿Todos los datos a modificar son correctos?");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //btnRegistrar.setDisable(true);
        btnRegistrar.setOnAction(event -> {
            try {
                mostrarAvisoRegistrar("¿Todos los datos son correctos?");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnEliminar.setDisable(true);
        btnEliminar.setOnAction(event -> {
            try {
                mostrarAvisoEliminar("¿Está seguro de que quiere eliminar el registro?");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnLimpiar.setOnAction(event -> {
            limpiarCampos();
        });

        try {
            cargarRegistros();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        tblRegistros.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarInfoEmpleado(newValue);
            }
        });


        txtID.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtNombre.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtApellidoP.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtApellidoM.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtGenero.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtFechaNac.valueProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtRfc.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtCurp.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtFoto.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtDomicilio.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtSalarioBruto.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtCodigoPostal.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtCiudad.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtEstado.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtTelefono.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());
        txtPuesto.textProperty().addListener((observable, oldValue, newValue) -> handleCambioEnCampos());

    }

    private void mostrarInfoEmpleado(Empleado empleado) {
        txtID.setText(String.valueOf((empleado.getIdEmpleado())));
        txtNombre.setText(empleado.getPersonaEmpleado().getNombrePersona());
        txtApellidoP.setText(empleado.getPersonaEmpleado().getApellidoPaternoPersona());
        txtApellidoM.setText(empleado.getPersonaEmpleado().getApellidoMaternoPersona());
        txtGenero.setText(empleado.getPersonaEmpleado().getGeneroPersona());
        txtFechaNac.setValue(LocalDate.parse(empleado.getPersonaEmpleado().getFechaNacimientoPersona()));
        txtRfc.setText(empleado.getPersonaEmpleado().getRfcPersona());
        txtCurp.setText(empleado.getPersonaEmpleado().getCurpPersona());
        txtFoto.setText(empleado.getPersonaEmpleado().getFotoPersona());
        txtDomicilio.setText(empleado.getPersonaEmpleado().getDomicilioPersona());
        txtCodigoPostal.setText(empleado.getPersonaEmpleado().getCodigoPostalPersona());
        txtCiudad.setText(empleado.getPersonaEmpleado().getCiudadPersona());
        txtEstado.setText(empleado.getPersonaEmpleado().getEstadoPersona());
        txtSalarioBruto.setText(String.valueOf(empleado.getSalarioBrutoEmpleado()));
        txtTelefono.setText(empleado.getPersonaEmpleado().getTelefonoPersona());
        txtPuesto.setText(empleado.getPuestoEmpleado());
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

    private void abrirModuloBuscarProductos() throws IOException {
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

    private void mostarAvisoModificar(String mensaje) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view_alertaAviso.fxml"));
        Parent root = loader.load();
        ControllerAlertaAviso controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        Label lblTitulo = controller.getLblTitulo();
        lblTitulo.setText(mensaje);
        btnAceptar.setOnAction(event -> {
            modificarEmpleado();
            popup.hide();
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnModificar.getScene().getWindow());
    }

    private void mostrarAvisoRegistrar(String mensaje) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view_alertaAviso.fxml"));
        Parent root = loader.load();
        ControllerAlertaAviso controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        Label lblTitulo = controller.getLblTitulo();
        lblTitulo.setText(mensaje);
        btnAceptar.setOnAction(event -> {
            registrarEmpleado();
            popup.hide();
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnRegistrar.getScene().getWindow());
    }

    private void mostrarAvisoEliminar(String mensaje) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view_alertaAviso.fxml"));
        Parent root = loader.load();
        ControllerAlertaAviso controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        Label lblTitulo = controller.getLblTitulo();
        lblTitulo.setText(mensaje);
        btnAceptar.setOnAction(event -> {
            eliminarEmpleado();
            popup.hide();
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnEliminar.getScene().getWindow());
    }

    private void registrarEmpleado() {
        System.out.println("Apunto de registrar empleado");
        Empleado empleado = new Empleado();
        empleado.getPersonaEmpleado().setNombrePersona(txtNombre.getText());
        empleado.getPersonaEmpleado().setApellidoPaternoPersona(txtApellidoP.getText());
        empleado.getPersonaEmpleado().setApellidoMaternoPersona(txtApellidoM.getText());
        empleado.getPersonaEmpleado().setGeneroPersona(txtGenero.getText());
        empleado.getPersonaEmpleado().setFechaNacimientoPersona(String.valueOf(txtFechaNac.getValue()));
        empleado.getPersonaEmpleado().setRfcPersona(txtRfc.getText());
        empleado.getPersonaEmpleado().setCurpPersona(txtCurp.getText());
        empleado.getPersonaEmpleado().setFotoPersona(txtFoto.getText());
        empleado.getPersonaEmpleado().setDomicilioPersona(txtDomicilio.getText());
        empleado.getPersonaEmpleado().setCiudadPersona(txtCiudad.getText());
        empleado.getPersonaEmpleado().setCodigoPostalPersona(txtCodigoPostal.getText());
        empleado.getPersonaEmpleado().setEstadoPersona(txtEstado.getText());
        empleado.setSalarioBrutoEmpleado(Float.valueOf(txtSalarioBruto.getText()));
        empleado.getPersonaEmpleado().setTelefonoPersona(txtTelefono.getText());
        empleado.setPuestoEmpleado(txtPuesto.getText());
        System.out.println(empleado);
    }

    public void modificarEmpleado() {
        System.out.println("Apunto de modificar empleado");
    }

    private void eliminarEmpleado() {
    }
    public void limpiarCampos(){
        txtID.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtGenero.setText("");
        txtFechaNac.setValue(null);
        txtRfc.setText("");
        txtCurp.setText("");
        txtFoto.setText("");
        txtDomicilio.setText("");
        txtCodigoPostal.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
        txtSalarioBruto.setText("");
        txtTelefono.setText("");
        txtPuesto.setText("");
    }

    public void cargarRegistros() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/sicefa/api/empleado/getAll")
                .asJson();

        String registros = (apiResponse.getBody().toString());
        System.out.println(registros);

        Gson gson = new Gson();

        Empleado[] arrayEmpleado = gson.fromJson(registros, Empleado[].class);
        //System.out.println(arrayEmpleado[0].toString());
        System.out.println(registros);
        ArrayList<Empleado> listaEmpleados = new ArrayList<>(Arrays.asList(arrayEmpleado));

        ObservableList<Empleado> registrosEmpleado = FXCollections.observableArrayList(listaEmpleados);
        tblRegistros.setItems(registrosEmpleado);
        tcolNombre.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaEmpleado().getNombrePersona()).asString());
        tcolApellidoP.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaEmpleado().getApellidoPaternoPersona()));
        tcolApellidoM.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersonaEmpleado().getApellidoMaternoPersona()));
        tcolTelefono.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getActivoEmpleado()));

    }




    @FXML
    private void handleCambioEnCampos() {
        actualizarEstadoBtnRegistrar();
        actualizarEstadoBtnModificarEliminar();
    }

    // Método para habilitar/deshabilitar el botón Registrar según el estado de los campos
    private void actualizarEstadoBtnRegistrar() {
        btnRegistrar.setDisable(!verificarCamposVacios());
    }
    private void actualizarEstadoBtnModificarEliminar() {
        btnModificar.setDisable(verificarCampoId());
        btnEliminar.setDisable(verificarCampoId());
    }


    private boolean verificarCampoId() {
        return txtID.getText().trim().isEmpty();
    }

    // Eventos de cambio en los campos para actualizar el estado del botón
    private boolean verificarCamposVacios() {
        return txtID.getText().trim().isEmpty()
                && txtNombre.getText().trim().isEmpty()
                && txtApellidoP.getText().trim().isEmpty()
                && txtApellidoM.getText().trim().isEmpty()
                && txtGenero.getText().trim().isEmpty()
                && txtFechaNac.getValue() == null
                && txtRfc.getText().trim().isEmpty()
                && txtCurp.getText().trim().isEmpty()
                && txtFoto.getText().trim().isEmpty()
                && txtDomicilio.getText().trim().isEmpty()
                && txtCodigoPostal.getText().trim().isEmpty()
                && txtCiudad.getText().trim().isEmpty()
                && txtEstado.getText().trim().isEmpty()
                && txtSalarioBruto.getText().trim().isEmpty()
                && txtTelefono.getText().trim().isEmpty()
                && txtPuesto.getText().trim().isEmpty();
        // Puedes seguir añadiendo otros campos según sea necesario...
    }

}
