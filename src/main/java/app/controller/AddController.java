//package app.controller;
//
//import app.database.UserRepository;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class AddController {
//    @Autowired
//    UserRepository repository;
//
//    @FXML
//    TextField nameField;
//    @FXML
//    PasswordField passwordField;
//
//    public void add(ActionEvent actionEvent) {
//        app.domain.User u1 = new app.domain.User();
//        u1.setUsername(nameField.getText());
//
//        //Encrypt Password with 10 rounds of BCrypt
//        PasswordEncoder encoder = new BCryptPasswordEncoder(10);    //strength - num of rounds
//        u1.setPassword(encoder.encode(passwordField.getText()));
//
//        repository.save(u1);
//    }
//}
