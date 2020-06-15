package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.CreerRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerRoleCommande;

public class CreerRoleCommandeGestionnaire implements GestionnaireCommande<CreerRoleCommande> {

    private final CreerRole creerRole;

    public CreerRoleCommandeGestionnaire(CreerRole creerRole) {
        this.creerRole = creerRole;
    }

    @Override
    public void execute(CreerRoleCommande commande) {
        creerRole.creer(commande);
    }
}
