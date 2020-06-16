package org.turoriel.ddd.meetup.core.reunion.domaine.entite;

/**
 * <p>Entité domaine representant les informations de la location du meeting</p>
 * @author Touré Ahmed Christian Cédrick 2020-06-16
 */
public class MeetingLocation {

    private String localisation;

    public MeetingLocation() {
    }

    public MeetingLocation(String localisation) {
        this.localisation = localisation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}
