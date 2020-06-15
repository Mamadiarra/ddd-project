package org.turoriel.ddd.meetup.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;
import org.turoriel.ddd.meetup.infrastructure.entite.PermissionTable;
import org.turoriel.ddd.meetup.infrastructure.entite.RoleTable;
import org.turoriel.ddd.meetup.infrastructure.mapper.RoleMappeur;
import org.turoriel.ddd.meetup.infrastructure.repository.JpaRoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RoleRepositoryPortAdapteur implements RoleRepositoryPort {

    private final JpaRoleRepository jpaRoleRepository;
    private final RoleMappeur roleMappeur;

    public RoleRepositoryPortAdapteur(JpaRoleRepository jpaRoleRepository, RoleMappeur roleMappeur) {
        this.jpaRoleRepository = jpaRoleRepository;
        this.roleMappeur = roleMappeur;
    }

    @Override
    public List<Role> lister() {
        List<RoleTable> rolesTable = jpaRoleRepository.findAll();
        return rolesTable.stream().map(roleMappeur::tableVersRole).collect(Collectors.toList());
    }

    @Override
    public Role rechercherRoleParId(UUID roleId) {
        Optional<RoleTable> roleTable = jpaRoleRepository.findById(roleId);

        return roleTable.map(roleMappeur::tableVersRole).orElse(null);
    }

    @Override
    public void creer(Role role) {
        RoleTable roleTable = roleMappeur.roleVersTable(role);
        jpaRoleRepository.save(roleTable);
    }

    @Override
    public void modifier(Role role) {
        RoleTable roleTable = roleMappeur.roleVersTable(role);
        roleTable.setId(role.getId());

        jpaRoleRepository.save(roleTable);
    }

    @Override
    public void supprimer(Role role) {
        RoleTable roleTable = roleMappeur.roleVersTable(role);
        roleTable.setId(role.getId());

        jpaRoleRepository.delete(roleTable);
    }
}
