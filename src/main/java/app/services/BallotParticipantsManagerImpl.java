package app.services;

import app.domain.BallotParticipants;
import app.domain.Candidate;
import app.domain.User;
import org.springframework.stereotype.Service;

@Service
public class BallotParticipantsManagerImpl implements BallotParticipantsManager {
    public void addCandidateToBallotParticipants(Candidate candidate, BallotParticipants participants) {
        participants.getCandidates().add(candidate);
    }

    public void deleteCandidateFromBallotParticipants(String candidateName, BallotParticipants participants) {
        participants.getCandidates().remove(participants.getCandidates().stream().filter(c -> c.getName() == candidateName).findFirst().get());
    }

    public void addUserToBallotParticipants(User user, BallotParticipants participants) {
        participants.getUsers().add(user);
    }

    public void deleteUserFromBallotParticipants(String username, BallotParticipants participants) {
        participants.getUsers().remove(participants.getUsers().stream().filter(u -> u.getUsername() == username).findFirst().get());
    }
}
