package org.turoriel.ddd.meetup.infrastructure.entite.reunion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class MeetingNotAttendeeTable implements Serializable {

    @ManyToMany(mappedBy = "listNotAttendee")
    private Set<MembreTable> members  = new HashSet<>();

    @ManyToOne
    private MeetingTable meeting;

    @Id
    @GeneratedValue
    private UUID id;

    public MeetingNotAttendeeTable() {
    }

    public MeetingNotAttendeeTable(MeetingTable meetingTable) {
        this.meeting = meetingTable;
    }

    public Set<MembreTable> getMembers() {
        return members;
    }

    public void setMembers(Set<MembreTable> members) {
        this.members = members;
    }

    public MeetingTable getMeeting() {
        return meeting;
    }

    public void setMeeting(MeetingTable meeting) {
        this.meeting = meeting;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}