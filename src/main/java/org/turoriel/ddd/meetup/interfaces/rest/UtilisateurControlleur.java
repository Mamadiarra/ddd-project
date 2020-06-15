package org.turoriel.ddd.meetup.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerCompteCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.CreerCompteCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.CompteRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.UtilisateurRepositoryPort;

@RestController
@RequestMapping("/api")
public class UtilisateurControlleur {

  private final GestionnaireCommande<CreerCompteCommande> gestionnaireCreerCompte;

  public UtilisateurControlleur(
          UtilisateurRepositoryPort utilisateurRepository,
          RoleRepositoryPort roleRepository,
          CompteRepositoryPort compteRepository) {
    gestionnaireCreerCompte = new CreerCompteCommandeGestionnaire(utilisateurRepository,
            roleRepository, compteRepository);
  }

  @PostMapping("/creer-compte")
  @ResponseStatus(HttpStatus.CREATED)
  public void creerCompte(@RequestBody CreerCompteCommande commande) {
    gestionnaireCreerCompte.execute(commande);
  }
}
