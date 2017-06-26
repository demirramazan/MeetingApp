package com.rdemir.assginment.service.imp;


import com.rdemir.assginment.entity.Meeting;
import com.rdemir.assginment.repository.MeetingRepository;
import com.rdemir.assginment.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeetingServiceImp implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public List<Meeting> getMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeeting(Long meetingId) {
        return meetingRepository.findOne(meetingId);
    }

    @Override
    public List<Meeting> saveMeeting(Meeting meeting) {
        if (meeting != null)
            meetingRepository.save(meeting);
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> updateMeeting(Long id,Meeting meeting) {
        Meeting meeting1=meetingRepository.findOne(id);
        if (meeting1!=null){
            meeting1.setName(meeting.getName());
            meeting1.setDescription(meeting.getDescription());
            meeting1.setDepartments(meeting.getDepartments());
            meetingRepository.save(meeting1);
        }
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> deleteMeeting(Long meetingId) {
        meetingRepository.delete(meetingId);
        return meetingRepository.findAll();
    }
}
