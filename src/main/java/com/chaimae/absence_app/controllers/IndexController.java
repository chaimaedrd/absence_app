package com.chaimae.absence_app.controllers;

import com.chaimae.absence_app.dto.UserRegistrationDto;
import com.chaimae.absence_app.models.*;
import com.chaimae.absence_app.repositories.CompteRepo;
import com.chaimae.absence_app.repositories.RoleRepo;
import com.chaimae.absence_app.repositories.UtilisateurRepo;
import com.chaimae.absence_app.services.CompteService;
import com.chaimae.absence_app.services.RoleService;
import com.chaimae.absence_app.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    private CompteService compteService;
    @Autowired
    private CompteRepo compteRepo;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepo roleRepo;

    @ModelAttribute("userRegisterDto")
    public UserRegistrationDto newUserRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("hello");
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginPost(@ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto, RedirectAttributes redirectAttributes){
        Utilisateur utilisateur = utilisateurRepo.findByEmail(userRegistrationDto.getEmail()).orElse(null);
        if(utilisateur != null && utilisateur.getComptes().get(0).getPassword().equals(userRegistrationDto.getPassword())){
            if(utilisateur.getComptes().get(0).getRoles().stream().toList().get(0).getNomRole().equals("cadreAdministrateur")){
                return "redirect:/cadreAdmin/createElements";
            }
            else{
                return "register";
            }
        }
        System.out.println(userRegistrationDto);
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto, RedirectAttributes redirectAttributes) {

        System.out.println(userRegistrationDto);
        if(userRegistrationDto.getRole().equals("etudiant")){
            Etudiant etudiant = new Etudiant(userRegistrationDto.getNom(),userRegistrationDto.getPrenom(),userRegistrationDto.getEmail(),userRegistrationDto.getTelephone(),userRegistrationDto.getNomArabe(),userRegistrationDto.getPrenomArabe(),userRegistrationDto.getCne(),userRegistrationDto.getDateNaissance());
            utilisateurRepo.save(etudiant);
            Compte compte = new Compte(userRegistrationDto.getEmail(),userRegistrationDto.getPassword(),etudiant);
            compteRepo.save(compte);


        } else if (userRegistrationDto.getRole().equals("enseignant")) {
            Enseignant enseignant = new Enseignant(userRegistrationDto.getNom(),userRegistrationDto.getPrenom(),userRegistrationDto.getEmail(),userRegistrationDto.getTelephone(),userRegistrationDto.getNomArabe(),userRegistrationDto.getPrenomArabe(), userRegistrationDto.getSpecialiste());
            utilisateurRepo.save(enseignant);
            Compte compte = new Compte(userRegistrationDto.getEmail(),userRegistrationDto.getPassword(),enseignant);
            compteRepo.save(compte);


        } else if (userRegistrationDto.getRole().equals("cadreAdministratif")) {
            CadreAdministrateur cadreAdministrateur = new CadreAdministrateur(userRegistrationDto.getNom(),userRegistrationDto.getPrenom(),userRegistrationDto.getEmail(),userRegistrationDto.getTelephone(),userRegistrationDto.getNomArabe(),userRegistrationDto.getPrenomArabe(),userRegistrationDto.getGrade());
            utilisateurRepo.save(cadreAdministrateur);
            Compte compte = new Compte(userRegistrationDto.getEmail(),userRegistrationDto.getPassword(),cadreAdministrateur);
            compteRepo.save(compte);

        }

        Role role = new Role(userRegistrationDto.getRole());
        if(roleRepo.save(role) != null )
            redirectAttributes.addFlashAttribute("successCreate","Register avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");
        return "redirect:/register";
    }

    @GetMapping("/index")

    public String index() {
        return "index";
    }

    @GetMapping("/cadreAdminHome")

    public String cadreAdminHome() {
        return "cadreAdminHome";
    }

}
