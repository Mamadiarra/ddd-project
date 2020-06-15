package org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.objetvaleur.EtatCompte;
import org.turoriel.ddd.meetup.infrastructure.entite.CompteTable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>Entité domaine représentant les information d'un compte.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class Compte implements Serializable {

  private UUID id;
  private String login;
  private String password;
  private Utilisateur utilisateur;
  private EtatCompte etatCompte;

  public Compte() {
    this.etatCompte = EtatCompte.ATTENTE_CONFIRMATION;
  }

  public Compte(String login, String password) {
    this.login = login;
    this.password = password;
    this.etatCompte = EtatCompte.ATTENTE_CONFIRMATION;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(
          Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public EtatCompte getEtatCompte() {
    return etatCompte;
  }

  public void setEtatCompte(
          EtatCompte etatCompte) {
    this.etatCompte = etatCompte;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Compte)) {
      return false;
    }
    Compte compte = (Compte) o;
    return id.equals(compte.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, utilisateur, etatCompte);
  }
}