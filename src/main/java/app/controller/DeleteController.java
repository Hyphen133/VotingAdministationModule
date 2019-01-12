//package app.controller;
//
//import app.database.UserRepository;
//import app.domain.User;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.SelectionMode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//@Controller
//public class DeleteController implements Initializable {
//
//    @FXML
//    Button loadButton;
//
//    @FXML
//    Button deleteButton;
//
//    @FXML
//    ListView userList;
//
//    @Autowired
//    UserRepository repository;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        for (User user : repository.findAll()) {
//            userList.getItems().add(user.getUsername());
//        }
//        userList.getSelectionModel().select(0);
//
//    }
//
//    public void deleteUser(ActionEvent actionEvent) {
//        String selectedUser = userList.getSelectionModel().getSelectedItem().toString();
//        User userToDelete = repository.findByUsername(selectedUser).get(0); //Assuming that names are unique
//        repository.delete(userToDelete);
//
//        //Delete selected user from listview
//        userList.getItems().remove(userList.getSelectionModel().getSelectedIndex());
//    }
//}
