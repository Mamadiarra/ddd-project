package org.turoriel.ddd.meetup.core.administration.domaine.entite;
/**
 * Entité domaine Utilisateur
 *
 * @author Diarra Mamadou 15-06-2020
 */

import org.turoriel.ddd.meetup.core.administration.domaine.exception.MeetingAssignateException;
import org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur.MeetingGroupProposalDecision;
import org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur.MeetingGroupProposalStatus;
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

    public void assignateMeetingGroupProposal(MeetingGroupProposal meetingGroupProposals) {
        this.meetingGroupProposals.add(meetingGroupProposals);
    }

    public void assignateManyMeetingGroupProposals(MeetingGroupProposal... meetingGroupProposals) {
        this.meetingGroupProposals.addAll(Arrays.asList(meetingGroupProposals));
    }

    /**
     * Point d'entrée de la validation du group passé en paramètre assigné à l'utilisateur
     */
    public void validDecision(MeetingGroupProposal meetingGroupProposal) {
        this.makeAction(meetingGroupProposal, MeetingGroupProposalDecision.Accept, MeetingGroupProposalStatus.Accepted);
    }

    /**
     * Point d'entrée du rejet du group passé en paramètre assigné à l'utilisateur
     */
    public void rejectDecision(MeetingGroupProposal meetingGroupProposal) {
        this.makeAction(meetingGroupProposal, MeetingGroupProposalDecision.Reject, MeetingGroupProposalStatus.Rejected);
    }

    /**
     * Point d'entrée du rejet des group assigné à l'utilisateur
     */
    public void rejectAllDecision() {
        this.meetingGroupProposals.forEach( meetingGroupProposal -> {
            this.makeAction(meetingGroupProposal, MeetingGroupProposalDecision.Reject, MeetingGroupProposalStatus.Rejected);
        });
    }

    /**
     * Point d'entrée de la validation des group assigné à l'utilisateur
     */
    public void validAllDecision() {
        this.meetingGroupProposals.forEach( meetingGroupProposal -> {
            this.makeAction(meetingGroupProposal, MeetingGroupProposalDecision.Accept, MeetingGroupProposalStatus.Accepted);
        });
    }

    /**
     * Cette methode sert à verifier si le group passé en paramètre appartient à l'administrateur.
     * @param meetingGroupProposal
     * @return boolean
     */
    private Boolean isMeetingGroupProposalAssignateToMe(MeetingGroupProposal meetingGroupProposal) {
        return this.meetingGroupProposals.contains(meetingGroupProposal);
    }

    /**
     * Cette fonction sert à la prise de décision sur un group de meeting
     * @param meetingGroupProposal
     * @param meetingGroupProposalStatus
     * @param meetingGroupProposalDecision
     */
    private void makeAction(MeetingGroupProposal meetingGroupProposal,
                            MeetingGroupProposalDecision meetingGroupProposalDecision,
                            MeetingGroupProposalStatus meetingGroupProposalStatus) {

        if (this.isMeetingGroupProposalAssignateToMe(meetingGroupProposal)) {

            meetingGroupProposal.setDecision(meetingGroupProposalDecision);
            meetingGroupProposal.setStatus(meetingGroupProposalStatus);
            meetingGroupProposal.setAdministrator(this);

        } else {
            throw new MeetingAssignateException();
        }

    }

}
