package org.turoriel.ddd.meetup.core.noyaupartage.application.port;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionRepositoryPort {

    Permission rechercherParId(UUID uuid);

    void creer(Permission permission);

    List<Permission> lister();

    void modifier(Permission permission);

    void supprimer(Permission permission);
}
