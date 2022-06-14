module com.example.gradleairquality {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires java.datatransfer;
    requires java.management;
    requires java.desktop;


    opens com.example.gradleairquality to javafx.fxml;
    exports com.example.gradleairquality;
}