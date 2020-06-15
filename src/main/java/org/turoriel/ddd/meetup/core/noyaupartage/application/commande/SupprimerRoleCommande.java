package org.turoriel.ddd.meetup.core.noyaupartage.application.commande;

import java.util.List;
import java.util.UUID;

public class SupprimerRoleCommande {

    private UUID uuid;
    private String libelle;
    private List<UUID> permissionsId;

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

    public List<UUID> getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(List<UUID> permissionsId) {
        this.permissionsId = permissionsId;
    }
}
