package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

public class CreerPermission {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public CreerPermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public void creer(CreerPermissionCommande commande) {

        Permission permission = new Permission(
                commande.getLibelle(),
                commande.getDescription()
        );
        permissionRepositoryPort.creer(permission);
    }
}
