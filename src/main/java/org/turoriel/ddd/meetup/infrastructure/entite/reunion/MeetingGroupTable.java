package org.turoriel.ddd.meetup.infrastructure.entite.reunion;

import org.turoriel.ddd.meetup.infrastructure.entite.administrators.MeetingGroupProposalTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class MeetingGroupTable implements Serializable {

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<MeetingTable> meetings = new HashSet<MeetingTable>();

    @ManyToOne
    private MeetingGroupProposalTable meetingGroupProposal;

    @Id
    @GeneratedValue
    private UUID id;

    public MeetingGroupTable() {
    }

    public MeetingGroupTable(MeetingGroupProposalTable meetingGroupProposal) {
        this.meetingGroupProposal = meetingGroupProposal;
    }

    public Set<MeetingTable> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<MeetingTable> meetings) {
        this.meetings = meetings;
    }

    public MeetingGroupProposalTable getMeetingGroupProposal() {
        return meetingGroupProposal;
    }

    public void setMeetingGroupProposal(MeetingGroupProposalTable meetingGroupProposal) {
        this.meetingGroupProposal = meetingGroupProposal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
