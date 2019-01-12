package app.services;

import app.domain.BallotParticipants;
import app.domain.Candidate;
import app.domain.User;

public interface BallotParticipantsManager {
    void addCandidateToBallotParticipants(Candidate candidate, BallotParticipants participants);
    void deleteCandidateFromBallotParticipants(String candidateName, BallotParticipants participants);
    void addUserToBallotParticipants(User user, BallotParticipants participants);
    void deleteUserFromBallotParticipants(String username, BallotParticipants participants);

}
