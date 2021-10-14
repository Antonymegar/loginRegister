package com.example.loginregister.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 65)
    private String description;
    @Column(nullable = false, length = 45)
    private String start_time;
    @Column(nullable = false, length= 45)
    private String end_time;
    @Temporal(TemporalType.DATE)
    private Date  meeting_day;

    @ManyToMany
    @JoinTable(
            name = "Own_meeting",
            joinColumns = { @JoinColumn(name = "meeting_id") },
            inverseJoinColumns = { @JoinColumn(name = "owners_id") })
    private List<MeetingOwner> meetingOwners= new ArrayList<MeetingOwner>();

    @ManyToOne
    @JoinColumn(name="fk_room")
    private Room room;

    public Meeting() {

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Meeting(Room room) {
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Date getMeeting_day() {
        return meeting_day;
    }

    public void setMeeting_day(Date meeting_day) {
        this.meeting_day = meeting_day;
    }

    public List<MeetingOwner> getMeetingOwners() {
        return meetingOwners;
    }

    public void setMeetingOwners(List<MeetingOwner> meetingOwners) {
        this.meetingOwners = meetingOwners;
    }
}
