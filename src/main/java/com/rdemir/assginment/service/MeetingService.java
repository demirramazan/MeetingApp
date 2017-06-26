package com.rdemir.assginment.service;


import com.rdemir.assginment.entity.Meeting;

import java.util.List;

public interface MeetingService {

    public List<Meeting> getMeetings();

    public Meeting getMeeting(Long meetingId);

    public List<Meeting> saveMeeting(Meeting meeting);

    public List<Meeting> updateMeeting(Long id,Meeting meeting);

    public List<Meeting> deleteMeeting(Long meetingId);
}
