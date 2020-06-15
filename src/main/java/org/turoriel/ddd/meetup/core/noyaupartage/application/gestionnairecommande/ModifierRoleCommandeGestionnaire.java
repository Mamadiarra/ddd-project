package org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande;

import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.ModifierRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.ModifierRoleCommande;

public class ModifierRoleCommandeGestionnaire implements GestionnaireCommande<ModifierRoleCommande> {

    private final ModifierRole modifierRole;

    public ModifierRoleCommandeGestionnaire(ModifierRole modifierRole) {
        this.modifierRole = modifierRole;
    }

    @Override
    public void execute(ModifierRoleCommande commande) {
        modifierRole.modifier(commande);
    }
}
