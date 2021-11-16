module com.example.tour_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;


    exports com.example.tour_project;
    opens com.example.tour_project to javafx.fxml, org.hibernate.orm.core;


    exports com.example.tour_project.utils;
    opens com.example.tour_project.utils to javafx.fxml, org.hibernate.orm.core;
    exports com.example.tour_project.models;
    opens com.example.tour_project.models to javafx.fxml, org.hibernate.orm.core;
    exports com.example.tour_project.controllers;
    opens com.example.tour_project.controllers to javafx.fxml, org.hibernate.orm.core;

    requires java.naming;
    requires lombok;
}
