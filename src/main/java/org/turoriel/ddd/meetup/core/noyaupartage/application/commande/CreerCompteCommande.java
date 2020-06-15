package org.turoriel.ddd.meetup.core.noyaupartage.application.commande;

import java.util.List;
import java.util.UUID;

/**
 * <p>Commande pour la création d'un compte.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class CreerCompteCommande {

  private String nom;
  private String prenom;
  private int age;
  private String login;
  private String password;
  private List<UUID> rolesId;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
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

  public List<UUID> getRolesId() {
    return rolesId;
  }

  public void setRolesId(List<UUID> rolesId) {
    this.rolesId = rolesId;
  }
}
