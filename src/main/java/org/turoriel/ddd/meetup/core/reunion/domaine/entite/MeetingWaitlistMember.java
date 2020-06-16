package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * <p>Entité domaine representant les informations de la liste d'attente</p>
 * @author Touré Ahmed Christian Cédrick 2020-06-16
 */
public class MeetingWaitlistMember implements Serializable {

    private UUID id;
    private Set<Membre> membres = new HashSet<>();
    private Meeting meeting;


    public MeetingWaitlistMember() {
    }

    public Set<Membre> getMembres() {
        return new HashSet<Membre>(membres);
    }

    public void setMembres(Set<Membre> membres) {
        this.membres = membres;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private void ajouterMembre(Membre membre) {
        this.membres.add(membre);
    }

}
