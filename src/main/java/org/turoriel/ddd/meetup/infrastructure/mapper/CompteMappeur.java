package org.turoriel.ddd.meetup.infrastructure.mapper;

import org.springframework.stereotype.Service;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;
import org.turoriel.ddd.meetup.infrastructure.entite.CompteTable;

@Service
public class CompteMappeur {

    public CompteTable compteVersTable(Compte compte) {
        return new CompteTable(compte);
    }

    public Compte tableVersCompte(CompteTable table) {
        Compte compte = new Compte();
        compte.setId(table.getId());
        compte.setEtatCompte(table.getEtatCompte());
        compte.setLogin(table.getLogin());
        compte.setPassword(table.getPassword());

        // compte.setUtilisateur();
        return compte;
    }
}
