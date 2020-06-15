package org.turoriel.ddd.meetup.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.CompteRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;

@Repository
public class CompteRepositoryPortAdapteur implements CompteRepositoryPort {

  @Override
  public void enregistrer(Compte compte) {

  }
}
