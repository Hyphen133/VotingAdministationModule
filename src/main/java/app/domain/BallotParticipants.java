package app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class BallotParticipants {
    List<User> users;
    List<Candidate> candidates;

    public BallotParticipants() {
        users = new ArrayList<>();
        candidates = new ArrayList<>();
    }
}
