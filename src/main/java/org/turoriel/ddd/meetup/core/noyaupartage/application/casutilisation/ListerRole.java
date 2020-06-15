package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;

import java.util.List;

public class ListerRole {

    private final RoleRepositoryPort roleRepositoryPort;

    public ListerRole(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    public List<Role> lister() {
        return roleRepositoryPort.lister();
    }

}
