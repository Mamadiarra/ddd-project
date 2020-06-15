package org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>Entité domaine représentant une permission.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class Permission implements Serializable {

  private UUID id;
  private String libelle;
  private String description;

  public Permission() {}

  public Permission(String libelle, String description) {
    this.libelle = libelle;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Permission)) {
      return false;
    }
    Permission that = (Permission) o;
    return id.equals(that.id) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, libelle, description);
  }
}
