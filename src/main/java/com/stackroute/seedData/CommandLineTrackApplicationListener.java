package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//This class is to implement the commandline dataseed implementation
@Component
//@Profile("!dev")
public class CommandLineTrackApplicationListener implements CommandLineRunner {
    private TrackRepository trackRepository;

    //Making constructor and autowiring the TrackRepository class
    @Autowired
    public CommandLineTrackApplicationListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //putting values and passing the Track object
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Context commandline Received");
        Track track1 = new Track(1, "singh", "atul");
        Track track2 = new Track(2, "shankar", "pushkar");
        Track track3 = new Track(3, "maiti", "samresh");
        Track track4 = new Track(4, "prakash", "shiv");

        //passing the track object
        trackRepository.save(track1);
        trackRepository.save(track2);
        trackRepository.save(track3);
        trackRepository.save(track4);
        System.out.println("command line runner working");

    }
}
