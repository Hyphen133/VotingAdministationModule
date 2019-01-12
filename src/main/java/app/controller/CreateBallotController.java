//package app.controller;
//
//import app.database.UserRepository;
//import app.domain.Ballot;
//import app.domain.BallotParticipants;
//import app.domain.Candidate;
//import app.domain.User;
//import app.services.BallotParticipantsManager;
//import app.services.BallotStartupServices;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import tornadofx.control.DateTimePicker;
//
//import java.net.URL;
//import java.time.LocalDateTime;
//import java.util.*;
//
//@Controller
//public class CreateBallotController implements Initializable {
//
//    @FXML
//    public ListView userList;
//
//    @FXML
//    public ListView candidateList;
//
//    @FXML
//    public DateTimePicker startDatePicker;
//
//    @FXML
//    public DateTimePicker endDatePicker;
//
//    @FXML
//    public TextField nameField;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    BallotParticipantsManager participantsManager;
//
//    @Autowired
//    BallotStartupServices startupServices;
//
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        candidateList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        userList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        for (User user : userRepository.findAll()) {
//            userList.getItems().add(user.getUsername());
//        }
//        userList.getSelectionModel().select(0);
//
//    }
//
//    //Kind of inconviniecence between gui and naming but still happens this way for user its creating ballot for us its launching its startup
//    public void startBallot(ActionEvent actionEvent) {
//
//
////        Ballot ballot = createBallot();
////        //Start ballot
////        startupServices.startTimerForBallot(ballot);
//
//    }
//
//
//    //TODO -> Add data checking
//    private Ballot createBallot(){
//        String name = nameField.getText();
//
//
//        LocalDateTime startDate = startDatePicker.getDateTimeValue();
//        LocalDateTime endDate = endDatePicker.getDateTimeValue();
//
//        ObservableList<String> selectedUsers = userList.getSelectionModel().getSelectedItems();
//        ObservableList<String> selectedCandidates = candidateList.getItems();       //Assume all are selected
//
//        List<User> users = new ArrayList<>();
//        List<Candidate> candidates = new ArrayList<>();
//
//        for (String candidateName : selectedCandidates) {
//            candidates.add(new Candidate(candidateName));
//        }
//
//
//        for (String username: selectedUsers) {
//            users.add(userRepository.findByUsername(username).get(0));  //Assuming unique names
//        }
//
//        //Create ballot
//        BallotParticipants participants = new BallotParticipants(users,candidates);
//        Ballot ballot = new Ballot(-1,name,participants,startDate,endDate);
//
//        return ballot;
//    }
//
//    public void addCandidate(ActionEvent actionEvent) {
//        TextInputDialog dialog = new TextInputDialog();
//        dialog.setTitle("Adding candidate");
//        dialog.setHeaderText("Enter candidate name");
//
//        Optional<String> result = dialog.showAndWait();
//
//        if(result.isPresent()){
//            candidateList.getItems().add(result.get());
//        }
//    }
//
//    public void deleteCandidates(ActionEvent actionEvent) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Delete Candidates");
//        alert.setContentText("Are you sure you want to delete selected candidates?");
//
//        Optional<ButtonType> result = alert.showAndWait();
//
//        if(result.isPresent() && result.get() == ButtonType.OK){
//            candidateList.getItems().removeAll(candidateList.getSelectionModel().getSelectedItems());
//        }
//    }
//
//    public void selectAllUsers(ActionEvent actionEvent) {
//        userList.getSelectionModel().selectAll();
//    }
//}
