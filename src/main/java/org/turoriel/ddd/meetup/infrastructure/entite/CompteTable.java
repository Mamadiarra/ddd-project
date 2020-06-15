package org.turoriel.ddd.meetup.infrastructure.entite;

import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.objetvaleur.EtatCompte;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CompteTable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private EtatCompte etatCompte;

    @OneToOne
    private UtilisateurTable utilisateurTable;

    public CompteTable(Compte compte) {
        this.login = compte.getLogin();
        this.password = compte.getPassword();
        this.etatCompte = compte.getEtatCompte();
    }

    public CompteTable() {
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

    public EtatCompte getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(EtatCompte etatCompte) {
        this.etatCompte = etatCompte;
    }

    public UtilisateurTable getUtilisateurTable() {
        return utilisateurTable;
    }

    public void setUtilisateurTable(UtilisateurTable utilisateurTable) {
        this.utilisateurTable = utilisateurTable;
    }
}
