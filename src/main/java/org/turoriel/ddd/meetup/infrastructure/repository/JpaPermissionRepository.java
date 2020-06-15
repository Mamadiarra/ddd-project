package org.turoriel.ddd.meetup.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turoriel.ddd.meetup.infrastructure.entite.PermissionTable;

import java.util.UUID;

public interface JpaPermissionRepository extends JpaRepository<PermissionTable, UUID> {
}
