package org.turoriel.ddd.meetup.infrastructure.mapper;

import org.springframework.stereotype.Service;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;
import org.turoriel.ddd.meetup.infrastructure.entite.CompteTable;
import org.turoriel.ddd.meetup.infrastructure.entite.RoleTable;
import org.turoriel.ddd.meetup.infrastructure.entite.UtilisateurTable;

import java.util.HashSet;
import java.util.Set;

@Service
public class UtilisateurMappeur {

  private final CompteMappeur compteMappeur;
  private final RoleMappeur roleMappeur;

  public UtilisateurMappeur(CompteMappeur compteMappeur, RoleMappeur roleMappeur) {
    this.compteMappeur = compteMappeur;
    this.roleMappeur = roleMappeur;
  }

  public UtilisateurTable utilisateurVersUtilisateurTable(Utilisateur utilisateur) {
    UtilisateurTable utilisateurTable = new UtilisateurTable(utilisateur);

    Compte compte = utilisateur.getCompte();
    CompteTable compteTable = compteMappeur.compteVersTable(compte);
    utilisateurTable.setCompteTable(compteTable);

    Set<Role> roles = utilisateur.getRoles();
    Set<RoleTable> roleTables = new HashSet<>();
    roles.forEach(role -> roleTables.add( roleMappeur.roleVersTable(role) ));
    utilisateurTable.setRolesTable(roleTables);


    // TODO : Convertisseur des autres tables
    return utilisateurTable;
  }

  public Utilisateur utilisateurTableVersUtilisateur(UtilisateurTable table) {

    Utilisateur utilisateur = new Utilisateur(
            table.getNom(),
            table.getPrenom(),
            table.getAge()
    );
    Set<Role> roles = new HashSet<>();
    table.getRolesTable().forEach(roleTable -> {
      roles.add(roleMappeur.tableVersRole(roleTable));
    });
    utilisateur.setRoles(roles);
    utilisateur.setCompte(compteMappeur.tableVersCompte(table.getCompteTable()));

    return utilisateur;
    // TODO : Convertisseur des autres tables

  }
}
