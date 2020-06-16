package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import org.turoriel.ddd.meetup.core.administration.domaine.entite.MeetingGroupProposal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * <p>Entité domaine representant les informations d'un groupe de meeting</p>
 * @author Touré Ahmed Christian Cédrick 2020-06-16
 */
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

    public void ajouterMeeting(Meeting meeting) {
        this.meetings.add(meeting);
    }
}
