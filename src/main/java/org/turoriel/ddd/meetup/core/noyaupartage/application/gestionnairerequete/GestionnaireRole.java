package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairerequete;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireRequete;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;

import java.util.List;
import java.util.UUID;

public class GestionnaireRole implements GestionnaireRequete<UUID, Role> {

    private final RoleRepositoryPort roleRepositoryPort;

    public GestionnaireRole(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public List<Role> lister() {
        return roleRepositoryPort.lister();
    }

    @Override
    public Role requete(UUID critere) {
        return roleRepositoryPort.rechercherRoleParId(critere);
    }
}
