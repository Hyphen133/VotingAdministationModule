package app.domain;

import app.domain.BallotParticipants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Ballot {
    BigInteger id;
    String name;
    BallotParticipants participants;
    LocalDateTime startDate;
    LocalDateTime endDate;

    public Ballot() {
        participants = new BallotParticipants();
    }
}
