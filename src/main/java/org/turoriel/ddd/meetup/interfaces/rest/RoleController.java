package org.turoriel.ddd.meetup.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.GestionnaireRequete;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.CreerRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.ModifierRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation.SupprimerRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerRoleCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.ModifierRoleCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.SupprimerRoleCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.CreerRoleCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.ModifierRoleCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairecommande.SupprimerRoleCommandeGestionnaire;
import org.turoriel.ddd.meetup.core.noyaupartage.application.gestionnairerequete.GestionnaireRole;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.PermissionRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final GestionnaireCommande<CreerRoleCommande> gestionnaireCreerRole;
    private final GestionnaireCommande<ModifierRoleCommande> gestionnaireModifierRole;
    private final GestionnaireCommande<SupprimerRoleCommande> gestionnaireSupprimerRole;
    private final GestionnaireRequete<UUID, Role> gestionnaireRoleGestionnaireRequete;

    public RoleController(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {

        CreerRole creerRole = new CreerRole(roleRepositoryPort, permissionRepositoryPort);
        this.gestionnaireCreerRole = new CreerRoleCommandeGestionnaire(creerRole);

        this.gestionnaireRoleGestionnaireRequete = new GestionnaireRole(roleRepositoryPort);

        ModifierRole modifierRole = new ModifierRole(roleRepositoryPort, permissionRepositoryPort);
        gestionnaireModifierRole = new ModifierRoleCommandeGestionnaire(modifierRole);

        SupprimerRole supprimerRole = new SupprimerRole(roleRepositoryPort, permissionRepositoryPort);
        gestionnaireSupprimerRole = new SupprimerRoleCommandeGestionnaire(supprimerRole);
    }

    @GetMapping("/liste-role")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> listePermission() {
        return gestionnaireRoleGestionnaireRequete.lister();
    }

    @PostMapping("/creer-role")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerRole(@RequestBody CreerRoleCommande commande) {
        gestionnaireCreerRole.execute(commande);
    }

    @PutMapping("/modifier-role/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifierRole(@RequestBody ModifierRoleCommande commande, @PathVariable UUID roleId) {

        Role role = gestionnaireRoleGestionnaireRequete.requete(roleId);

        if (role != null) {
            commande.setUuid(roleId);
            gestionnaireModifierRole.execute(commande);
        }

    }

    @GetMapping("/afficher-role/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public Role afficherPermission(@PathVariable UUID roleId) {
        return gestionnaireRoleGestionnaireRequete.requete(roleId);
    }

    @DeleteMapping("/supprimer-role/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerRole(@PathVariable UUID roleId) {
        Role role = gestionnaireRoleGestionnaireRequete.requete(roleId);

        if (role != null) {
            SupprimerRoleCommande commande = new SupprimerRoleCommande();
            commande.setLibelle(role.getLibelle());

            List<UUID> permissionsId = new ArrayList<>();
            role.getPermissions().forEach(permission -> { permissionsId.add(permission.getId()); });

            commande.setPermissionsId(permissionsId);
            gestionnaireSupprimerRole.execute(commande);

        }
    }

}
