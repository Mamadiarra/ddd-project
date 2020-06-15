package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.CreerCompte;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerCompteCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.CompteRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.UtilisateurRepositoryPort;

/**
 * @author Christian Amani 2020-05-27
 */
public class CreerCompteCommandeGestionnaire implements GestionnaireCommande<CreerCompteCommande> {

  private final CreerCompte creerCompte;

  public CreerCompteCommandeGestionnaire(
      UtilisateurRepositoryPort utilisateurPortRepository,
      RoleRepositoryPort roleRepositoryPort,
      CompteRepositoryPort compteRepositoryPort) {
    creerCompte = new CreerCompte(utilisateurPortRepository, roleRepositoryPort,
        compteRepositoryPort);
  }

  @Override
  public void execute(CreerCompteCommande commande) {
    creerCompte.cree(commande);
  }
}
