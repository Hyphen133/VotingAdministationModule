package app.services;

import app.domain.Ballot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@Data
@AllArgsConstructor
public class BallotTimer {
    BallotStartupServices controller;
    Ballot ballot;

    public void start() {
        //Start timertask
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Starting Ballot");
                controller.startBallot(ballot);
                System.out.println("Started Ballot");
                //Stop timertask
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Ending Ballot");
                        signal();
                        System.out.println("Ended Ballot");
                    }
                }, Duration.between(ballot.getStartDate(), ballot.getEndDate()).toMillis());
            }
        }, Duration.between(LocalDateTime.now(), ballot.getStartDate()).toMillis());

    }

    private void signal() {
        controller.endBallot(ballot);
    }
}
