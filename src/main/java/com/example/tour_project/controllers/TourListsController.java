package com.example.tour_project.controllers;

import java.io.IOException;
import java.util.List;

import com.example.tour_project.dao.TourDAO;
import com.example.tour_project.models.Tour;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.tour_project.utils.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListsController implements Initializable {
    @FXML
    private TableView<Tour> tableListTours;

    @FXML
    private TableColumn<Tour, String> matour;

    @FXML
    private TableColumn<Tour, String> tengoi;

    @FXML
    private TableColumn<Tour, String> maloaihinh;

    @FXML
    private TableColumn<Tour, String> dacdiem;

    @FXML
    private ObservableList<Tour> tourList;


    private static SessionFactory factory;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factory = HibernateUtil.getSessionFactory();
        matour.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMatour()));
        tengoi.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTengoi()));
        maloaihinh.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMaloaihinh()));
        dacdiem.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDacdiem()));
        loadData();
    }

    private void loadData() {
        tourList = FXCollections.observableArrayList(TourDAO.listTour());
        tableListTours.getItems().clear();
        tableListTours.setItems(tourList);
    }

    public void gotoDetails(ActionEvent e) throws IOException {
        //lấy stage hiện tại
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/tour_project/tour-details.fxml"));
        Parent tourDetailsParent = loader.load();
        Scene scene = new Scene(tourDetailsParent);

        TourDetailsController controller = loader.getController();
        Tour selected = tableListTours.getSelectionModel().getSelectedItem();
        controller.setView(selected);

        stage.setScene(scene);
    }

    //    public void addTour(String matour, String tengoi, String dacdiem) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Tour tour = new Tour(matour, tengoi, dacdiem, "");
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
}
