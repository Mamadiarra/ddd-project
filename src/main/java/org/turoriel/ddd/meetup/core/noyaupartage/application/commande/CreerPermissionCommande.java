package org.turoriel.ddd.meetup.core.noyaupartage.application.commande;

public class CreerPermissionCommande {

    private String libelle;
    private String description;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
