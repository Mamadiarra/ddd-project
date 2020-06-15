package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.ModifierPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.SupprimerPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

public class ModifierPermission {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public ModifierPermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public void modifier(ModifierPermissionCommande commande) {

        Permission permission = new Permission(
                commande.getLibelle(),
                commande.getDescription()
        );

        permission.setId(commande.getUuid());

        permissionRepositoryPort.modifier(permission);
    }

    public static class SupprimerPermission {

        private final PermissionRepositoryPort permissionRepositoryPort;

        public SupprimerPermission(PermissionRepositoryPort permissionRepositoryPort) {
            this.permissionRepositoryPort = permissionRepositoryPort;
        }

        public void supprimer(SupprimerPermissionCommande commande) {

            Permission permission = new Permission(
                    commande.getLibelle(),
                    commande.getDescription()
            );

            permission.setId(commande.getUuid());

            permissionRepositoryPort.supprimer(permission);
        }

    }
}
