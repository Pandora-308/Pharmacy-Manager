module com.pandorapharmacymanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.pandorapharmacymanager to javafx.fxml;
    exports com.pandorapharmacymanager;
    exports com.pandorapharmacymanager.controller;
    opens com.pandorapharmacymanager.controller to javafx.fxml;
}