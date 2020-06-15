package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerRoleCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CreerRole {

    private final RoleRepositoryPort roleRepositoryPort;
    private final PermissionRepositoryPort permissionRepositoryPort;

    public CreerRole(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public void creer(CreerRoleCommande commande) {

        Set<Permission> permissionsList = new HashSet<>();

        permissionsList = commande.getPermissionsId().stream()
                .map(permissionRepositoryPort::rechercherParId).collect(Collectors.toSet());

        Role role = new Role(commande.getLibelle(), permissionsList);

        roleRepositoryPort.creer(role);

    }

}
