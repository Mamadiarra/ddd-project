package org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.exception.CompteDejaExistant;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * <p>Entité domaine représentant l'utilisateur.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class Utilisateur implements Serializable {

  private UUID id;
  private String nom;
  private String prenom;
  private int age;
  private Compte compte;
  private Set<Role> roles = new HashSet<>();

  public Utilisateur() {
  }

  public Utilisateur(String nom, String prenom, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

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

  public Compte getCompte() {
    return compte;
  }

  public void setCompte(Compte compte) {
    this.compte = compte;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public void ajouterRole(Role role) {
    roles.add(role);
  }

  public void retirerRole(Role role) {
    roles.remove(role);
  }

  /**
   * <p>Créer un compte pour l'utilisateur, si l'utilisateur possède un compte alors l'exception
   * {@link CompteDejaExistant} est levée.</p>
   *
   * @param login Pseudo de l'utilisateur
   * @param password  Mot de passe de l'utilisateur
   * @return Retourne le compte nouvellement créer de l'utilisateur
   */
  public Compte creerCompte(String login, String password) {
    if (this.compte == null) {
      this.compte = new Compte(login, password);
      this.compte.setUtilisateur(this);
      return compte;
    }
    throw new CompteDejaExistant();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Utilisateur)) {
      return false;
    }
    Utilisateur that = (Utilisateur) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, age, compte,roles);
  }
}
