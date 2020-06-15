package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairerequete;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireRequete;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

import java.util.List;
import java.util.UUID;

public class GestionnairePermission implements GestionnaireRequete<UUID, Permission> {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public GestionnairePermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    @Override
    public List<Permission> lister() {
        return permissionRepositoryPort.lister();
    }

    @Override
    public Permission requete(UUID critere) {
        return permissionRepositoryPort.rechercherParId(critere);
    }
}
