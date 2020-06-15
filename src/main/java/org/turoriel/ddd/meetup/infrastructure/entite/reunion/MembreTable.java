package org.turoriel.ddd.meetup.infrastructure.entite.reunion;

import org.turoriel.ddd.meetup.infrastructure.entite.UtilisateurTable;
import org.turoriel.ddd.meetup.infrastructure.entite.administrators.MeetingGroupProposalTable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MembreTable extends UtilisateurTable implements Serializable {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MeetingAttendeeTable> listAttendee = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MeetingNotAttendeeTable> listNotAttendee = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MeetingWaitlistMemberTable> listWaiting = new HashSet<>();

    @OneToMany(mappedBy = "membre")
    private Set<MeetingGroupProposalTable> proposals = new HashSet<>();

    public MembreTable() {
    }

    public MembreTable(
            String firstName, String lastName, int number) {

        super(firstName, lastName, number);

    }

    public Set<MeetingAttendeeTable> getListAttendee() {
        return listAttendee;
    }

    public void setListAttendee(Set<MeetingAttendeeTable> listAttendee) {
        this.listAttendee = listAttendee;
    }

    public Set<MeetingNotAttendeeTable> getListNotAttendee() {
        return listNotAttendee;
    }

    public void setListNotAttendee(Set<MeetingNotAttendeeTable> listNotAttendee) {
        this.listNotAttendee = listNotAttendee;
    }

    public Set<MeetingWaitlistMemberTable> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(Set<MeetingWaitlistMemberTable> listWaiting) {
        this.listWaiting = listWaiting;
    }

    public Set<MeetingGroupProposalTable> getProposals() {
        return proposals;
    }

    public void setProposals(Set<MeetingGroupProposalTable> proposals) {
        this.proposals = proposals;
    }
}
