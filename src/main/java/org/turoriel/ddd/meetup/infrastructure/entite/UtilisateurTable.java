package org.turoriel.ddd.meetup.infrastructure.entite;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class UtilisateurTable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private int age;

    @OneToOne
    private CompteTable compteTable;

    @ManyToMany
    private Set<RoleTable> rolesTable = new HashSet<>();

    public UtilisateurTable() {}

    public UtilisateurTable(Utilisateur utilisateur) {
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.age = utilisateur.getAge();
    }

    public UtilisateurTable(String firstname, String lastname, int age) {
        this.nom = firstname;
        this.prenom = lastname;
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

    public CompteTable getCompteTable() {
        return compteTable;
    }

    public void setCompteTable(CompteTable compteTable) {
        this.compteTable = compteTable;
    }

    public Set<RoleTable> getRolesTable() {
        return rolesTable;
    }

    public void setRolesTable(Set<RoleTable> rolesTable) {
        this.rolesTable = rolesTable;
    }
}
