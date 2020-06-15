package org.turoriel.ddd.meetup.infrastructure.mapper;

import org.springframework.stereotype.Service;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;
import org.turoriel.ddd.meetup.infrastructure.entite.PermissionTable;

@Service
public class PermissionMappeur {

    public PermissionTable permissionVersTable(Permission permission) {
        return new PermissionTable(permission);
    }

    public Permission tableVersPermission(PermissionTable table) {
        Permission permission = new Permission(
                table.getLibelle(),
                table.getDescription()
        );
        permission.setId(table.getId());

        return permission;
    }
}
