package org.turoriel.ddd.meetup.core.noyaupartage.application.port;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;

import java.util.List;
import java.util.UUID;

/**
 * <p>Interface pour le port du repository de l'entité {@link Role}.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public interface RoleRepositoryPort {

  List<Role> lister();

  Role rechercherRoleParId(UUID roleId);

  void creer(Role role);

  void modifier(Role role);

  void supprimer(Role role);
}
