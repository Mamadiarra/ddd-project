package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.ModifierPermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.SupprimerPermissionCommande;

public class SupprimerPermissionCommandeGestionnaire implements GestionnaireCommande<SupprimerPermissionCommande> {

    private final ModifierPermission.SupprimerPermission supprimerPermission;

    public SupprimerPermissionCommandeGestionnaire(ModifierPermission.SupprimerPermission supprimerPermission) {
        this.supprimerPermission = supprimerPermission;
    }


    @Override
    public void execute(SupprimerPermissionCommande commande) {
        supprimerPermission.supprimer(commande);
    }
}
