package org.turoriel.ddd.meetup.core.noyaupartage.application.port;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;
/**
 * <p>Interface pour le port du repository de l'entité {@link Compte}.</p> *
 *
 * @author Christian Amani 2020-05-27
 */

public interface CompteRepositoryPort {

  void enregistrer(Compte compte);
}
