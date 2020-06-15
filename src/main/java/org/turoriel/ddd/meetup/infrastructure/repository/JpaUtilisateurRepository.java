package org.turoriel.ddd.meetup.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turoriel.ddd.meetup.infrastructure.entite.UtilisateurTable;

import java.util.UUID;

public interface JpaUtilisateurRepository extends JpaRepository<UtilisateurTable, UUID> {

}
