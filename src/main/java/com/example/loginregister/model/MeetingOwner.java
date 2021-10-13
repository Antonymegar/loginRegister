package com.example.loginregister.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ownerCo")
public class MeetingOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false,length = 65)
    private String Owner;
    @Column(nullable = false,length = 65)
    private String Co_owner;
   @ManyToMany(mappedBy="meetingOwners")
   private List<Meeting>meetings=new ArrayList<Meeting>();

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getCo_owner() {
        return Co_owner;
    }

    public void setCo_owner(String co_owner) {
        Co_owner = co_owner;
    }
}
