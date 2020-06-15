package org.turoriel.ddd.meetup.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turoriel.ddd.meetup.infrastructure.entite.RoleTable;

import java.util.UUID;

public interface JpaRoleRepository extends JpaRepository<RoleTable, UUID> {
}
