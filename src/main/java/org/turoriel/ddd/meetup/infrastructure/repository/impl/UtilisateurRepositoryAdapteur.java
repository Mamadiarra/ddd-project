package org.turoriel.ddd.meetup.infrastructure.repository.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;
import org.turoriel.ddd.meetup.infrastructure.entite.UtilisateurTable;
import org.turoriel.ddd.meetup.infrastructure.mapper.UtilisateurMappeur;
import org.turoriel.ddd.meetup.infrastructure.repository.JpaUtilisateurRepository;

@Repository
public class UtilisateurRepositoryAdapteur implements UtilisateurRepositoryPort {

  private final JpaUtilisateurRepository jpaUtilisateurRepository;
  private final UtilisateurMappeur utilisateurMappeur;

  public UtilisateurRepositoryAdapteur(
          JpaUtilisateurRepository jpaUtilisateurRepository,
          UtilisateurMappeur utilisateurMappeur) {
    this.jpaUtilisateurRepository = jpaUtilisateurRepository;
    this.utilisateurMappeur = utilisateurMappeur;
  }

  @Override
  public Utilisateur enregistrer(Utilisateur utilisateur) {
    UtilisateurTable utilisateurTable = utilisateurMappeur
            .utilisateurVersUtilisateurTable(utilisateur);
    UtilisateurTable utilisateurTableEnregistrer = jpaUtilisateurRepository.save(utilisateurTable);
    return utilisateurMappeur.utilisateurTableVersUtilisateur(utilisateurTable);
  }

  @Override
  public Utilisateur rechercherParId(UUID identifiant) {
    Optional<UtilisateurTable> optionalUtilisateurTable = jpaUtilisateurRepository
            .findById(identifiant);
    if (optionalUtilisateurTable.isPresent()) {
      UtilisateurTable utilisateurTable = optionalUtilisateurTable.get();
      return utilisateurMappeur.utilisateurTableVersUtilisateur(utilisateurTable);
    }
    return null;
  }

  @Override
  public Optional<Utilisateur> rechercherParIdAvecOptional(UUID identifiant) {
    Optional<UtilisateurTable> optionalUtilisateurTable = jpaUtilisateurRepository
            .findById(identifiant);
    if (optionalUtilisateurTable.isPresent()) {
      UtilisateurTable utilisateurTable = optionalUtilisateurTable.get();
      Utilisateur utilisateur = utilisateurMappeur
              .utilisateurTableVersUtilisateur(utilisateurTable);
      return Optional.of(utilisateur);
    }
    return Optional.empty();
  }
}
