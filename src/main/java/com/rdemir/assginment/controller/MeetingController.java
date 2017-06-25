package com.rdemir.assginment.controller;

import com.rdemir.assginment.entity.Meeting;
import com.rdemir.assginment.service.imp.MeetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {

    @Autowired
    private MeetingServiceImp meetingServiceImp;

    @RequestMapping(name = "/meetings",method = RequestMethod.GET)
    public List<Meeting> getMeetings(){
        return meetingServiceImp.getMeetings();
    }

    @RequestMapping(value = "/meeting/{id}",method = RequestMethod.GET)
    public Meeting getMeeting(@PathVariable Long id){
        return meetingServiceImp.getMeeting(id);
    }

    @RequestMapping(value = "/meeting",method = RequestMethod.POST)
    public List<Meeting> addMeeting(@RequestBody Meeting meeting){
        meetingServiceImp.saveMeeting(meeting);

        return meetingServiceImp.getMeetings();
    }

    @RequestMapping(value = "/meeting/{id}",method = RequestMethod.PUT)
    public List<Meeting> updateMeeting(@PathVariable Long id,@RequestBody Meeting meeting){
        meetingServiceImp.updateMeeting(meeting);

        return meetingServiceImp.getMeetings();
    }

    @RequestMapping(value = "/meeting/{id}",method = RequestMethod.DELETE)
    public List<Meeting> deleteMeeting(@PathVariable Long id){
        meetingServiceImp.deleteMeeting(id);

        return meetingServiceImp.getMeetings();
    }
}
