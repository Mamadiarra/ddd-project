package org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * <p>Entité domaine représentant un rôle.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class Role implements Serializable {

  protected UUID id;
  protected String libelle;
  private Set<Permission> permissions = new HashSet<>();

  public Role() {}

  public Role(String libelle, Set<Permission> permissions) {
    this.libelle = libelle;
    this.permissions = permissions;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(
          Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public void ajouterPermission(Permission permission) {
    permissions.add(permission);
  }

  public void retirerPermission(Permission permission) {
    permissions.remove(permission);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Role)) {
      return false;
    }
    Role role = (Role) o;
    return id.equals(role.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, libelle,permissions);
  }

}
