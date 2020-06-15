package org.turoriel.ddd.meetup.infrastructure.mapper;

import org.springframework.stereotype.Service;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;
import org.turoriel.ddd.meetup.infrastructure.entite.PermissionTable;
import org.turoriel.ddd.meetup.infrastructure.entite.RoleTable;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleMappeur {

    private final PermissionMappeur permissionMappeur;

    public RoleMappeur(PermissionMappeur permissionMappeur) {
        this.permissionMappeur = permissionMappeur;
    }

    public RoleTable roleVersTable(Role role) {

        RoleTable roleTable = new RoleTable(role);

        Set<Permission> permissions = role.getPermissions();
        Set<PermissionTable> permissionTables = new HashSet<>();
        permissions.forEach(permission -> {
            PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
            permissionTable.setId(permission.getId());

            permissionTables.add(permissionTable);
        });

        roleTable.setPermissionsTable(permissionTables);
        return roleTable;
    }

    public Role tableVersRole(RoleTable roleTable) {

        System.out.println(roleTable.toString());

        Set<PermissionTable> permissionTables = roleTable.getPermissionsTable();
        Set<Permission> permissions = new HashSet<>();
        permissionTables.forEach(permissionTable -> {
            permissions.add(permissionMappeur.tableVersPermission(permissionTable));
        });

        Role role = new Role(roleTable.getLibelle(), permissions);
        role.setId(roleTable.getId());

        return role;
    }

}
