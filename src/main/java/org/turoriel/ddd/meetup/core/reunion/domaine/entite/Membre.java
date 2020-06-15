package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import org.turoriel.ddd.meetup.core.administration.domaine.entite.MeetingGroupProposal;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Membre extends Utilisateur implements Serializable {

    private Set<MeetingAttendee> listAttendee = new HashSet<>();
    private Set<MeetingNotAttendee> listNotAttendee = new HashSet<>();
    private Set<MeetingWaitlistMember> listWaiting = new HashSet<>();
    private Set<MeetingGroupProposal> proposals = new HashSet<>();

    public Membre() {
    }

    public Membre(
            String firstName, String lastName, int number) {

        super(firstName, lastName, number);

    }

    public Set<MeetingAttendee> getListAttendee() {
        return listAttendee;
    }

    public void setListAttendee(Set<MeetingAttendee> listAttendee) {
        this.listAttendee = listAttendee;
    }

    public Set<MeetingNotAttendee> getListNotAttendee() {
        return listNotAttendee;
    }

    public void setListNotAttendee(Set<MeetingNotAttendee> listNotAttendee) {
        this.listNotAttendee = listNotAttendee;
    }

    public Set<MeetingWaitlistMember> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(Set<MeetingWaitlistMember> listWaiting) {
        this.listWaiting = listWaiting;
    }

    public Set<MeetingGroupProposal> getProposals() {
        return proposals;
    }

    public void setProposals(Set<MeetingGroupProposal> proposals) {
        this.proposals = proposals;
    }
}
