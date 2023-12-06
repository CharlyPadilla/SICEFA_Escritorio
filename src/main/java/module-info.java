module org.utl.dsm.dsm406_controlpacientes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires unirest.java;


    opens org.utl.dsm.dsm406_controlpacientes to javafx.fxml;
    exports org.utl.dsm.dsm406_controlpacientes;

    exports org.utl.dsm.dsm406_controlpacientes.Controller;
    opens org.utl.dsm.dsm406_controlpacientes.Controller to javafx.fxml;

    exports org.utl.dsm.dsm406_controlpacientes.Model;
    opens org.utl.dsm.dsm406_controlpacientes.Model to com.google.gson, javafx.fxml;



}
