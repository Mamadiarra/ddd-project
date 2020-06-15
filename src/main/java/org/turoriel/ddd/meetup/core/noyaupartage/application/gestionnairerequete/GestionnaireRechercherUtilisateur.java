package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairerequete;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireRequete;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class GestionnaireRechercherUtilisateur implements GestionnaireRequete<UUID, Utilisateur> {

  private final UtilisateurRepositoryPort utilisateurRepositoryPort;

  public GestionnaireRechercherUtilisateur(
      UtilisateurRepositoryPort utilisateurRepositoryPort) {
    this.utilisateurRepositoryPort = utilisateurRepositoryPort;
  }

  @Override
  public List<Utilisateur> lister() {
    return null;
  }

  @Override
  public Utilisateur requete(UUID critere) {
    return utilisateurRepositoryPort.rechercherParId(critere);
  }
}
