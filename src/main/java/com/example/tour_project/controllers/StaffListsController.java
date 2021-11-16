package com.example.tour_project.controllers;

import com.example.tour_project.dao.StaffDAO;
import com.example.tour_project.dao.TourDAO;
import com.example.tour_project.models.Staff;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import org.hibernate.SessionFactory;

import com.example.tour_project.utils.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffListsController implements Initializable {
    @FXML
    private TableView<Staff> tableListStaffs;

    @FXML
    private TableColumn<Staff, String> manhanvien, tennhanvien, sodienthoai, diachi;

    @FXML
    private ObservableList<Staff> staffList;

    private static SessionFactory factory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factory = HibernateUtil.getSessionFactory();
        manhanvien.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getManhanvien()));
        tennhanvien.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTennhanvien()));
        sodienthoai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSodienthoai()));
        diachi.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDiachi()));
        loadData();
    }


    private void loadData() {
        staffList = FXCollections.observableArrayList(StaffDAO.listStaff());
        tableListStaffs.getItems().clear();
        tableListStaffs.setItems(staffList);
    }
}