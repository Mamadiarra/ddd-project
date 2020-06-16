package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.turoriel.ddd.meetup.core.administration.domaine.entite.Administrateur;
import org.turoriel.ddd.meetup.core.administration.domaine.entite.MeetingGroupProposal;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

/**
 * <p>Entité domaine representant les informations d'un membre</p>
 * @author Touré Ahmed Christian Cédrick 2020-06-16
 */
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

  public void ajouterMeetingAttendee(MeetingAttendee meetingAttendee) {
    this.listAttendee.add(meetingAttendee);
  }

  public void ajouterMeetingNotAttendee(MeetingNotAttendee notAttendee) {
    this.listNotAttendee.add(notAttendee);
  }

  public void ajouterMeetingWaitlistMember(MeetingWaitlistMember waiting) {
    this.listWaiting.add(waiting);
  }

  public void ajouterMeetingGroupProposal(MeetingGroupProposal proposals) {
    this.proposals.add(proposals);
  }

  public void envoyerPropositionMeetingGroup(
      Administrateur administrateur,
      MeetingGroupProposal meetingGroupProposal) {

    meetingGroupProposal.setMember(this);
    administrateur.assignateMeetingGroupProposal(meetingGroupProposal);

  }

  public MeetingGroupProposal creerMeetingGroup(Administrateur administrateur,
      Set<MeetingAttendee> meetingAttendees,
      Set<MeetingNotAttendee> meetingNotAttendees,
      Set<MeetingWaitlistMember> meetingWaitlistMembers) {

    Meeting meeting = new Meeting();
    MeetingGroupProposal meetingGroupProposal = new MeetingGroupProposal();

    MeetingGroup meetingGroup = new MeetingGroup();

    meeting.setMeetingAttendeeList(meetingAttendees);
    meeting.setMeetingNotAttendeeList(meetingNotAttendees);
    meeting.setMeetingWaitlistList(meetingWaitlistMembers);

    meeting.setMeetingGroup(meetingGroup);
    meetingGroup.ajouterMeeting(meeting);

    meetingGroupProposal.setAdministrator(administrateur);
    meetingGroupProposal.setMeetingGroup(meetingGroup);
    meetingGroupProposal.setMember(this);

    return meetingGroupProposal;

  }

}
