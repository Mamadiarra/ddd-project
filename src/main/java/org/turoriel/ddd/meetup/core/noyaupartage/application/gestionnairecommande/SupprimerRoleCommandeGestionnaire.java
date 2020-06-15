package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.SupprimerRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.SupprimerRoleCommande;

public class SupprimerRoleCommandeGestionnaire implements GestionnaireCommande<SupprimerRoleCommande> {

    private final SupprimerRole supprimerRole;

    public SupprimerRoleCommandeGestionnaire(SupprimerRole supprimerRole) {
        this.supprimerRole = supprimerRole;
    }

    @Override
    public void execute(SupprimerRoleCommande commande) {
        supprimerRole.supprimer(commande);
    }

}
