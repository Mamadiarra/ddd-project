package org.turoriel.ddd.meetup.infrastructure.entite.administrators;

import org.turoriel.ddd.meetup.infrastructure.entite.UtilisateurTable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AdministrateurTable extends UtilisateurTable {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MeetingGroupProposalTable> meetingGroupProposalTables = new HashSet<MeetingGroupProposalTable>();

    public AdministrateurTable() {
    }

    public AdministrateurTable(String firstName, String lastName, int number) {
        super(firstName, lastName, number);
    }

    public Set<MeetingGroupProposalTable> getMeetingGroupProposalTables() {
        return meetingGroupProposalTables;
    }

    public void setMeetingGroupProposalTables(Set<MeetingGroupProposalTable> meetingGroupProposalTables) {
        this.meetingGroupProposalTables = meetingGroupProposalTables;
    }
}
