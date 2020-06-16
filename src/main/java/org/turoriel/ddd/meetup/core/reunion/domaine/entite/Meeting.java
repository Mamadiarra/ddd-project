package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * <p>Entité domaine representant les informations d'un meeting</p>
 * @author Touré Ahmed Christian Cédrick 2020-06-16
 */
public class Meeting implements Serializable {

    private UUID id;
    private Set<MeetingAttendee> meetingAttendeeList = new HashSet<>();
    private Set<MeetingNotAttendee> meetingNotAttendeeList = new HashSet<>();
    private Set<MeetingWaitlistMember> meetingWaitlistList = new HashSet<>();
    private MeetingGroup meetingGroup;
    private MeetingLocation location;

    public Meeting() {
    }

    public Meeting(Set<MeetingAttendee> meetingAttendees) {
        this.meetingAttendeeList = meetingAttendees;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<MeetingAttendee> getMeetingAttendeeList() {
        return meetingAttendeeList;
    }

    public void setMeetingAttendeeList(Set<MeetingAttendee> meetingAttendeeList) {
        this.meetingAttendeeList = meetingAttendeeList;
    }

    public Set<MeetingNotAttendee> getMeetingNotAttendeeList() {
        return meetingNotAttendeeList;
    }

    public void setMeetingNotAttendeeList(Set<MeetingNotAttendee> meetingNotAttendeeList) {
        this.meetingNotAttendeeList = meetingNotAttendeeList;
    }

    public Set<MeetingWaitlistMember> getMeetingWaitlistList() {
        return meetingWaitlistList;
    }

    public void setMeetingWaitlistList(Set<MeetingWaitlistMember> meetingWaitlistList) {
        this.meetingWaitlistList = meetingWaitlistList;
    }

    public MeetingGroup getMeetingGroup() {
        return meetingGroup;
    }

    public void setMeetingGroup(MeetingGroup meetingGroup) {
        this.meetingGroup = meetingGroup;
    }

    public MeetingLocation getLocation() {
        return location;
    }

    public void setLocation(MeetingLocation location) {
        this.location = location;
    }

    public void ajouterMeetingAttendee(MeetingAttendee meetingAttendee) {
        this.meetingAttendeeList.add(meetingAttendee);
    }

    public void ajouterMeetingNotAttendee(MeetingNotAttendee meetingNotAttendee) {
        this.meetingNotAttendeeList.add(meetingNotAttendee);
    }

    public void ajouterMeetingWaitlist(MeetingWaitlistMember meetingWaitlist) {
        this.meetingWaitlistList.add(meetingWaitlist);
    }
}
