package org.turoriel.ddd.meetup.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireRequete;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.CreerPermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.ModifierPermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.ModifierPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.SupprimerPermissionCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.CreerPermissionCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.ModifierPermissionCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.SupprimerPermissionCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairerequete.GestionnairePermission;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Permission;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PermissionController {

    private final GestionnaireCommande<CreerPermissionCommande> gestionnaireCreerPermission;
    private final GestionnaireCommande<ModifierPermissionCommande> gestionnaireModifierPermission;
    private final GestionnaireCommande<SupprimerPermissionCommande> gestionnaireSupprimerPermission;
    private final GestionnaireRequete<UUID, Permission> gestionnairePermissionGestionnaireRequete;

    public PermissionController(PermissionRepositoryPort permissionRepositoryPort) {

        CreerPermission creerPermission = new CreerPermission(permissionRepositoryPort);
        this.gestionnaireCreerPermission = new CreerPermissionCommandeGestionnaire(creerPermission);

        this.gestionnairePermissionGestionnaireRequete = new GestionnairePermission(permissionRepositoryPort);

        ModifierPermission modifierPermission = new ModifierPermission(permissionRepositoryPort);
        gestionnaireModifierPermission = new ModifierPermissionCommandeGestionnaire(modifierPermission);

        ModifierPermission.SupprimerPermission supprimerPermission = new ModifierPermission.SupprimerPermission(permissionRepositoryPort);
        gestionnaireSupprimerPermission = new SupprimerPermissionCommandeGestionnaire(supprimerPermission);
    }

    @PostMapping("/creer-permission")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerPermission(@RequestBody CreerPermissionCommande commande) {
        gestionnaireCreerPermission.execute(commande);
    }

    @GetMapping("/liste-permission")
    @ResponseStatus(HttpStatus.OK)
    public List<Permission> listePermission() {
        return gestionnairePermissionGestionnaireRequete.lister();
    }

    @PutMapping("modifier-permission/{permissionId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifierPermission(@RequestBody ModifierPermissionCommande commande, @PathVariable UUID permissionId) {

        Permission permission = gestionnairePermissionGestionnaireRequete.requete(permissionId);

        if (permission != null) {
            commande.setUuid(permissionId);
            gestionnaireModifierPermission.execute(commande);
        }

    }

    @DeleteMapping("supprimer-permission/{permissionId}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerPermission(@PathVariable UUID permissionId) {

        Permission permission = gestionnairePermissionGestionnaireRequete.requete(permissionId);

        if (permission != null) {
            SupprimerPermissionCommande commande = new SupprimerPermissionCommande();
            commande.setUuid(permission.getId());
            commande.setLibelle(permission.getLibelle());
            commande.setDescription(permission.getDescription());
            gestionnaireSupprimerPermission.execute(commande);
        }
    }

}
