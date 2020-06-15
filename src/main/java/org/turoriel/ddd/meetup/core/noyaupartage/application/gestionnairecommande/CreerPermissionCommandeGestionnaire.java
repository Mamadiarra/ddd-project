package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.CreerPermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerPermissionCommande;

public class CreerPermissionCommandeGestionnaire implements GestionnaireCommande<CreerPermissionCommande> {

    private final CreerPermission creerPermission;

    public CreerPermissionCommandeGestionnaire(CreerPermission creerPermission) {
        this.creerPermission = creerPermission;
    }

    @Override
    public void execute(CreerPermissionCommande commande) {
        creerPermission.creer(commande);
    }
}
