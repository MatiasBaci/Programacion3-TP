module orgFiuba.tpjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens orgFiuba.tpjava to javafx.fxml;
    exports orgFiuba.tpjava;
    exports orgFiuba.tpjava.Controller;
    opens orgFiuba.tpjava.Controller to javafx.fxml;
}