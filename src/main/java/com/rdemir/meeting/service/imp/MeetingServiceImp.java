package com.rdemir.meeting.service.imp;


import com.rdemir.meeting.entity.Meeting;
import com.rdemir.meeting.repository.MeetingRepository;
import com.rdemir.meeting.service.MeetingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeetingServiceImp implements MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingServiceImp(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public List<Meeting> getMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeeting(Long meetingId) {
        return meetingRepository.findById(meetingId).orElse(null);
    }

    @Override
    public List<Meeting> saveMeeting(Meeting meeting) {
        if (meeting != null)
            meetingRepository.save(meeting);
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> updateMeeting(Long id, Meeting meeting) {
        Meeting meeting1 = meetingRepository.findById(id).orElse(null);
        if (meeting1 != null) {
            meeting1.setName(meeting.getName());
            meeting1.setDescription(meeting.getDescription());
            meeting1.setDepartments(meeting.getDepartments());
            meetingRepository.save(meeting1);
        }
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> deleteMeeting(Long meetingId) {
        List<Meeting> allMeeting;
        try {
            meetingRepository.deleteById(meetingId);
            allMeeting = meetingRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
        return allMeeting;
    }
}
