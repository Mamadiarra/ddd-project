package org.turoriel.ddd.meetup.core.administration.domaine.entite;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Administrateur extends Utilisateur {

    private Set<MeetingGroupProposal> meetingGroupProposals = new HashSet<>();

    public Administrateur() {
    }

    public Administrateur(String firstName, String lastName, int number) {
        super(firstName, lastName, number);
    }

    public Set<MeetingGroupProposal> getMeetingGroupProposals() {
        return meetingGroupProposals;
    }

    public void setMeetingGroupProposals(Set<MeetingGroupProposal> meetingGroupProposals) {
        this.meetingGroupProposals = meetingGroupProposals;
    }

    public void addMeetingGroupProposals(MeetingGroupProposal meetingGroupProposals) {
        this.meetingGroupProposals.add(meetingGroupProposals);
    }

    public void addMeetingGroupProposals(MeetingGroupProposal... meetingGroupProposals) {
        this.meetingGroupProposals.addAll(Arrays.asList(meetingGroupProposals));
    }
}
