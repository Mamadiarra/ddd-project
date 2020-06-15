package org.turoriel.ddd.meetup.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turoriel.ddd.meetup.infrastructure.entite.CompteTable;

import java.util.UUID;

public interface JpaCompteRepository extends JpaRepository<CompteTable, UUID> {
}
