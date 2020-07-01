package com.rdemir.meeting.controller;

import com.rdemir.meeting.annotation.JsonRestController;
import com.rdemir.meeting.entity.Meeting;
import com.rdemir.meeting.service.imp.MeetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@JsonRestController
public class MeetingController {

    @Autowired
    private MeetingServiceImp meetingServiceImp;

    @RequestMapping(value = "/meetings",method = RequestMethod.GET)
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
        meetingServiceImp.updateMeeting(id,meeting);

        return meetingServiceImp.getMeetings();
    }

    @RequestMapping(value = "/meeting/{id}",method = RequestMethod.DELETE)
    public List<Meeting> deleteMeeting(@PathVariable Long id){
        meetingServiceImp.deleteMeeting(id);

        return meetingServiceImp.getMeetings();
    }
}
