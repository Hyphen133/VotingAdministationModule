package app.web_controller;

import app.database.UserRepository;
import app.domain.Ballot;
import app.domain.BallotParticipants;
import app.domain.Candidate;
import app.domain.User;
import app.services.BallotStartupServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ballot")
public class WebCreateBallotController {

    public class CandidateList {
        public ArrayList<String> candidates;

        public CandidateList() {
            candidates = new ArrayList<>();
        }

        public ArrayList<String> getCandidates() {
            return candidates;
        }

        public void setCandidates(ArrayList<String> candidates) {
            this.candidates = candidates;
        }
    }

    @Autowired
    BallotStartupServices startupServices;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String showBallotForm(Model model) {
        model.addAttribute("ballot", new BallotDto());
        model.addAttribute("allUsers", userRepository.findAll());
        return "createBallotForm";
    }

    @PostMapping
    public String createBallot(@ModelAttribute("ballot") BallotDto ballotDto, BindingResult result) {
        //Start ballot
        startupServices.startTimerForBallot(toBallot(ballotDto));
        return "index";
    }

    //Mock data
    public Ballot createBallotMockData() {

        LocalDateTime startDate = LocalDateTime.now().plusSeconds(10);
        LocalDateTime endDate = LocalDateTime.now().plusMinutes(10);

        List<User> users = new ArrayList<>();
        List<Candidate> candidates = new ArrayList<>();


        users.add(new User(1, "John", "password"));
        users.add(new User(2, "Patrick", "password"));
        users.add(new User(3, "Emma", "password"));
        users.add(new User(4, "Natalie", "password"));

        candidates.add(new Candidate("Frank Underwood"));
        candidates.add(new Candidate("Heather"));

        BallotParticipants participants = new BallotParticipants(users, candidates);

        Ballot ballot = new Ballot(1, "Sample Ballot", participants, startDate, endDate);

        return ballot;

    }

    public Ballot toBallot(BallotDto dto) {
        Ballot ballot = new Ballot();
        ballot.setId(dto.id);
        ballot.setName(dto.name);
        ballot.setStartDate(dto.startDate);
        ballot.setEndDate(dto.endDate);
        for (String username : dto.usernames) {
            ballot.getParticipants().getUsers().add(userRepository.findByUsername(username).get());
        }
        for (String candidate : dto.candidates) {
            ballot.getParticipants().getCandidates().add(new Candidate(candidate));
        }

        return ballot;
    }


    @Data
    class BallotDto {
        int id;
        String name;
        BallotParticipants participants;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
        LocalDateTime startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
        LocalDateTime endDate;
        List<String> usernames;
        List<String> candidates;

        public BallotDto() {
            usernames = new ArrayList<>();
            candidates = new ArrayList<>();
        }


    }


}
