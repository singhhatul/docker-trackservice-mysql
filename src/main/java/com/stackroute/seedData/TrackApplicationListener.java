package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//This class always provide data when we are running the application each time instead of putting data
// each time after running of our project
@Component
//@Qualifier("TrackServiceImpl")
public class TrackApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;

    //Autowire of TrackRepository and making constructor of TrackApplicationListener class

    @Autowired
    public TrackApplicationListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //putting data into database using Track object
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context application listerer Received");
        System.out.println("Application Event running");
        Track track1 = new Track(24, "atul", "singh");
        Track track2 = new Track(25, "pushkar", "shankar");
        Track track3 = new Track(26, "samresh", "maiti");
        Track track4 = new Track(27, "shiv", "prakash");

        //passing the track object
        trackRepository.save(track1);
        trackRepository.save(track2);
        trackRepository.save(track3);
        trackRepository.save(track4);
    }
}
