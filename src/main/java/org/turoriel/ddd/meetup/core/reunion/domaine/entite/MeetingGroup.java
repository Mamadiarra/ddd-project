package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import org.turoriel.ddd.meetup.core.administration.domaine.entite.MeetingGroupProposal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MeetingGroup implements Serializable {

    private UUID id;
    private Set<Meeting> meetings = new HashSet<>();
    private MeetingGroupProposal meetingGroupProposal;

    public MeetingGroup() {
    }

    public MeetingGroup(MeetingGroupProposal meetingGroupProposal) {
        this.meetingGroupProposal = meetingGroupProposal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }

    public MeetingGroupProposal getMeetingGroupProposal() {
        return meetingGroupProposal;
    }

    public void setMeetingGroupProposal(MeetingGroupProposal meetingGroupProposal) {
        this.meetingGroupProposal = meetingGroupProposal;
    }
}
