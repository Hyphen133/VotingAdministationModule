//package app.controller;
//
//import app.App;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.stage.Stage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class MainWindowController {
//
//    @FXML
//    public Label title;
//    @Autowired
//    SceneNavigator navigator;
//
//    public void openAddUserForm(ActionEvent actionEvent) {
//        try {
//            navigator.openScene((Stage)title.getScene().getWindow(), "views/addUserForm.fxml",600, 400);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void openDeleteUserForm(ActionEvent actionEvent) {
//        try {
//            navigator.openScene((Stage)title.getScene().getWindow(), "views/deleteUserForm.fxml",600, 400);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void createBallotForm(ActionEvent actionEvent) {
//        try {
//            navigator.openScene((Stage)title.getScene().getWindow(), "views/createBallotForm.fxml",600, 400);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
