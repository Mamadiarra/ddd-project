package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.ModifierPermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.ModifierPermissionCommande;

public class ModifierPermissionCommandeGestionnaire implements GestionnaireCommande<ModifierPermissionCommande> {

    private final ModifierPermission modifierPermission;

    public ModifierPermissionCommandeGestionnaire(ModifierPermission modifierPermission) {
        this.modifierPermission = modifierPermission;
    }

    @Override
    public void execute(ModifierPermissionCommande commande) {
        modifierPermission.modifier(commande);
    }
}
