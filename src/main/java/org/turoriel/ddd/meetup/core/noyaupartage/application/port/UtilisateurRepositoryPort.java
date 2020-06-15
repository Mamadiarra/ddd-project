package org.turoriel.ddd.meetup.core.noyaupartage.application.port;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.Optional;
import java.util.UUID;
/**
 * <p>Interface pour le port du repository de l'entité {@link Utilisateur}.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public interface UtilisateurRepositoryPort {

  Utilisateur enregistrer(Utilisateur utilisateur);

  Utilisateur rechercherParId(UUID identifiant);

  Optional<Utilisateur> rechercherParIdAvecOptional(UUID identifiant);
}
