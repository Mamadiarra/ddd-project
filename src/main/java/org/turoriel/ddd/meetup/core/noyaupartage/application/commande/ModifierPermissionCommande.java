package org.turoriel.ddd.meetup.core.noyaupartage.application.commande;

import java.util.UUID;

public class ModifierPermissionCommande {

    private UUID uuid;
    private String libelle;
    private String description;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

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
