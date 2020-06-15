package org.turoriel.ddd.meetup.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;
import org.turoriel.ddd.meetup.infrastructure.entite.PermissionTable;
import org.turoriel.ddd.meetup.infrastructure.mapper.PermissionMappeur;
import org.turoriel.ddd.meetup.infrastructure.repository.JpaPermissionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PermissionRepositoryPortAdapteur implements PermissionRepositoryPort {

    private final JpaPermissionRepository jpaPermissionRepository;
    private final PermissionMappeur permissionMappeur;

    public PermissionRepositoryPortAdapteur(JpaPermissionRepository jpaPermissionRepository, PermissionMappeur permissionMappeur) {
        this.jpaPermissionRepository = jpaPermissionRepository;
        this.permissionMappeur = permissionMappeur;
    }

    @Override
    public List<Permission> lister() {
        List<PermissionTable> permissionsTable = jpaPermissionRepository.findAll();

        return permissionsTable.stream().map(permissionMappeur::tableVersPermission).collect(Collectors.toList());

    }

    @Override
    public void modifier(Permission permission) {
        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        permissionTable.setId(permission.getId());
        jpaPermissionRepository.save(permissionTable);

    }

    @Override
    public void supprimer(Permission permission) {
        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        permissionTable.setId(permission.getId());
        jpaPermissionRepository.delete(permissionTable);
    }

    @Override
    public Permission rechercherParId(UUID id) {
        Optional<PermissionTable> permissionTable = jpaPermissionRepository.findById(id);
        return permissionTable.map(permissionMappeur::tableVersPermission).orElse(null);
    }

    @Override
    public void creer(Permission permission) {
        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        jpaPermissionRepository.save(permissionTable);
    }
}
