package org.turoriel.ddd.meetup.core.noyaupartage.application.casutilisation;

import org.turoriel.ddd.meetup.core.noyaupartage.application.commande.CreerCompteCommande;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.CompteRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.RoleRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Compte;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Role;
import org.turoriel.ddd.meetup.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>Cas d'utilisation pour la création d'un utilisateur et de son compte.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class CreerCompte {

    private final UtilisateurRepositoryPort utilisateurPortRepository;
    private final RoleRepositoryPort roleRepositoryPort;
    private final CompteRepositoryPort compteRepositoryPort;

    public CreerCompte(
            UtilisateurRepositoryPort utilisateurPortRepository,
            RoleRepositoryPort roleRepositoryPort,
            CompteRepositoryPort compteRepositoryPort) {

        this.utilisateurPortRepository = utilisateurPortRepository;
        this.roleRepositoryPort = roleRepositoryPort;
        this.compteRepositoryPort = compteRepositoryPort;
    }

    public void cree(CreerCompteCommande commande) {
        String nom = commande.getNom();
        String prenom = commande.getPrenom();
        int age = commande.getAge();
        Utilisateur utilisateur = new Utilisateur(nom, prenom, age);
        List<UUID> rolesId = commande.getRolesId();
        List<Role> roles = rolesId.stream()
                .map(roleId -> roleRepositoryPort.rechercherRoleParId(roleId))
                .collect(Collectors.toList());
        for (Role role : roles) {
            utilisateur.ajouterRole(role);
        }
        utilisateur = utilisateurPortRepository.enregistrer(utilisateur);
        String login = commande.getLogin();
        String password = commande.getPassword();
        Compte compte = utilisateur.creerCompte(login, password);
        compteRepositoryPort.enregistrer(compte);
    }
}
