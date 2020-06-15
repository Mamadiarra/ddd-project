package org.turoriel.ddd.meetup.infrastructure.entite.reunion;

import org.turoriel.ddd.meetup.infrastructure.objetvaleur.reunion.MeetingLocationTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class MeetingTable implements Serializable {

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<MeetingAttendeeTable> meetingAttendeeList = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<MeetingNotAttendeeTable> meetingNotAttendeeList = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<MeetingWaitlistMemberTable> meetingWaitlistList = new HashSet<>();

    //OneTonOne
    @ManyToOne
    private MeetingGroupTable meetingGroup;

    //Embedded
    @Embedded
    private MeetingLocationTable location;

    @Id
    @GeneratedValue
    private UUID id;

    public MeetingTable() {
    }

    public MeetingTable(Set<MeetingAttendeeTable> meetingAttendeeTables) {
        this.meetingAttendeeList = meetingAttendeeTables;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<MeetingAttendeeTable> getMeetingAttendeeList() {
        return meetingAttendeeList;
    }

    public void setMeetingAttendeeList(Set<MeetingAttendeeTable> meetingAttendeeList) {
        this.meetingAttendeeList = meetingAttendeeList;
    }

    public Set<MeetingNotAttendeeTable> getMeetingNotAttendeeList() {
        return meetingNotAttendeeList;
    }

    public void setMeetingNotAttendeeList(Set<MeetingNotAttendeeTable> meetingNotAttendeeList) {
        this.meetingNotAttendeeList = meetingNotAttendeeList;
    }

    public Set<MeetingWaitlistMemberTable> getMeetingWaitlistList() {
        return meetingWaitlistList;
    }

    public void setMeetingWaitlistList(Set<MeetingWaitlistMemberTable> meetingWaitlistList) {
        this.meetingWaitlistList = meetingWaitlistList;
    }

    public MeetingGroupTable getMeetingGroup() {
        return meetingGroup;
    }

    public void setMeetingGroup(MeetingGroupTable meetingGroup) {
        this.meetingGroup = meetingGroup;
    }

    public MeetingLocationTable getLocation() {
        return location;
    }

    public void setLocation(MeetingLocationTable location) {
        this.location = location;
    }

}
