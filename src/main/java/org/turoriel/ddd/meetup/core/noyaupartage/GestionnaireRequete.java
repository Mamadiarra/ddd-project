package org.turoriel.ddd.meetup.core.noyaupartage;

import java.util.List;

/**
 *
 */
public interface GestionnaireRequete<C,R> {

  List<R> lister();

  R requete(C critere);

}
