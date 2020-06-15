package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MeetingAttendee implements Serializable {

    private UUID id;
    private Set<Membre> membres = new HashSet<>();
    private Meeting meeting;

    public MeetingAttendee() {
    }

    public MeetingAttendee(Meeting meeting) {
        this.meeting = meeting;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Membre> getMembres() {
        return membres;
    }

    public void setMembres(Set<Membre> membres) {
        this.membres = membres;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
