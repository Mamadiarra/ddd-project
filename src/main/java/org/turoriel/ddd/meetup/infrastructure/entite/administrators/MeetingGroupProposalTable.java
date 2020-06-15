package org.turoriel.ddd.meetup.infrastructure.entite.administrators;

import org.turoriel.ddd.meetup.infrastructure.entite.reunion.MeetingGroupTable;
import org.turoriel.ddd.meetup.infrastructure.entite.reunion.MembreTable;
import org.turoriel.ddd.meetup.infrastructure.objetvaleur.administrateur.MeetingGroupProposalDecisionTable;
import org.turoriel.ddd.meetup.infrastructure.objetvaleur.administrateur.MeetingGroupProposalStatusTable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MeetingGroupProposalTable implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private MeetingGroupTable meetingGroup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private MembreTable membre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AdministrateurTable administrateurTable;

    @Enumerated(value = EnumType.STRING)
    private MeetingGroupProposalStatusTable status = MeetingGroupProposalStatusTable.InVerification;

    @Enumerated(value = EnumType.STRING)
    private MeetingGroupProposalDecisionTable decision;

    @Id
    @GeneratedValue
    private long id;

    public MeetingGroupProposalTable() {
    }

    public MeetingGroupProposalTable(MembreTable member) {
        this.membre = member;
    }

    public MeetingGroupTable getMeetingGroup() {
        return meetingGroup;
    }

    public void setMeetingGroup(MeetingGroupTable meetingGroup) {
        this.meetingGroup = meetingGroup;
    }

    public MembreTable getMembre() {
        return membre;
    }

    public void setMembre(MembreTable membre) {
        this.membre = membre;
    }

    public AdministrateurTable getAdministrateurTable() {
        return administrateurTable;
    }

    public void setAdministrateurTable(AdministrateurTable administrateurTable) {
        this.administrateurTable = administrateurTable;
    }

    public MeetingGroupProposalStatusTable getStatus() {
        return status;
    }

    public void setStatus(MeetingGroupProposalStatusTable status) {
        this.status = status;
    }

    public MeetingGroupProposalDecisionTable getDecision() {
        return decision;
    }

    public void setDecision(MeetingGroupProposalDecisionTable decision) {
        this.decision = decision;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
