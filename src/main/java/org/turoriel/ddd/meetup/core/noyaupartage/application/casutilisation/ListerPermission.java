package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

import java.util.List;

public class ListerPermission {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public ListerPermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public List<Permission> lister() {
        return permissionRepositoryPort.lister();
    }

}
