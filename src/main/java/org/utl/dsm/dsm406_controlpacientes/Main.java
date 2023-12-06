package org.utl.dsm.dsm406_controlpacientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {



    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(Main.class.getResource("view_principal.fxml"));
        Scene scene = new Scene(root,600,400);
        //scene.getStylesheets().add(getClass().getResource("stylePrincipal.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Medicamos tu Vida");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
/*
 root = FXMLLoader.load(Main.class.getResource("view_gestionClientes.fxml"));
        //root= FXMLLoader.load(this.getClass().getResource("view_login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/mystyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Administrar empleado - Medicamos tu vida");
        primaryStage.show();
 */