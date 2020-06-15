package org.turoriel.ddd.meetup.core.administration.domaine.entite;

import org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur.MeetingGroupProposalDecision;
import org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur.MeetingGroupProposalStatus;
import org.turoriel.ddd.meetup.core.reunion.domaine.entite.MeetingGroup;
import org.turoriel.ddd.meetup.core.reunion.domaine.entite.Membre;

import java.io.Serializable;
import java.util.UUID;


public class MeetingGroupProposal implements Serializable {

    private UUID id;
    private MeetingGroup meetingGroup;
    private Membre member;
    private Administrateur administrator;
    private MeetingGroupProposalStatus status;
    private MeetingGroupProposalDecision decision;

    public MeetingGroupProposal() {
        this.status = MeetingGroupProposalStatus.InVerification;
    }

    public MeetingGroupProposal(Membre member) {

        this.member = member;
        this.status = MeetingGroupProposalStatus.InVerification;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MeetingGroup getMeetingGroup() {
        return meetingGroup;
    }

    public void setMeetingGroup(MeetingGroup meetingGroup) {
        this.meetingGroup = meetingGroup;
    }

    public Membre getMember() {
        return member;
    }

    public void setMember(Membre member) {
        this.member = member;
    }

    public Administrateur getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrateur administrator) {
        this.administrator = administrator;
    }

    public MeetingGroupProposalStatus getStatus() {
        return status;
    }

    public void setStatus(MeetingGroupProposalStatus status) {
        this.status = status;
    }

    public MeetingGroupProposalDecision getDecision() {
        return decision;
    }

    public void setDecision(MeetingGroupProposalDecision decision) {
        this.decision = decision;
    }
}
