package org.turoriel.ddd.meetup.core.noyaupartage;

/**
 * @param <T>
 */
public interface GestionnaireCommande<T> {

  void execute(T commande);
}
