package com.chaimae.absence_app.controllers;

import com.chaimae.absence_app.models.Filiere;
import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
import com.chaimae.absence_app.repositories.FiliereRepo;
import com.chaimae.absence_app.repositories.MatiereRepo;
import com.chaimae.absence_app.repositories.ModuleRepo;
import com.chaimae.absence_app.repositories.NiveauRepo;
import com.chaimae.absence_app.services.FiliereService;
import com.chaimae.absence_app.services.MatiereService;
import com.chaimae.absence_app.services.ModuleService;
import com.chaimae.absence_app.services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cadreAdmin")
public class CadreAdmin {
    @Autowired
    private MatiereRepo matiereRepo;

    @Autowired
    private MatiereService matiereService;
    @ModelAttribute("element")
    public Matiere newMatiere(){
        return new Matiere();
    }
    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private NiveauRepo niveauRepo;

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private FiliereRepo filiereRepo;

    @Autowired
    private FiliereService filiereService;

    @GetMapping("/createElements")
    public String createElements(@RequestParam(value = "query",required = false) String query, Model model){
        List<Matiere> matiereList = null;
        if(query == null){
            matiereList = matiereRepo.findAllByOrderByNom();
        }else{
            matiereList = matiereRepo.findByNomOrCode("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listMatiere", matiereList);
        return "cadreAdmin/createElements";
    }
    @PostMapping("/createElements")
    public String addElement(@ModelAttribute("element") Matiere element, RedirectAttributes redirectAttributes) {
        if(matiereRepo.save(element) != null)
            redirectAttributes.addFlashAttribute("successCreate","element ajouter avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createElements";
    }

    @PostMapping("/deleteElement/{id}")
    public String deleteElement(@PathVariable int id, RedirectAttributes redirectAttributes){
        Matiere matiere = matiereService.delete(id);
        if(matiere != null)
            redirectAttributes.addFlashAttribute("successDelete","element "+matiere.getNom()+" code "+matiere.getCode()+" deleted successfuly");
        else
            redirectAttributes.addFlashAttribute("failedDelete","Something went wrong ! please try again");
        return "redirect:/cadreAdmin/createElements";
    }

    @GetMapping("/updateElement/{id}")
    public String updateElement(@PathVariable int id,Model model) {
        model.addAttribute("element",matiereRepo.findById(id).get());
        return "cadreAdmin/updateElement";
    }
    @PostMapping("/updateElement/{id}")
    public String updateElement(@PathVariable int id,@ModelAttribute("element") Matiere element, RedirectAttributes redirectAttributes){
        element.setIdMatiere(id);
        if(matiereRepo.saveAndFlush(element) != null)
            redirectAttributes.addFlashAttribute("successUpdate","element modifier avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedUpdate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createElements";
    }


//modules

    @ModelAttribute("module")
    public Module newModule(){
        return new Module();
    }
    @GetMapping("/createModules")
    public String createModules(@RequestParam(value = "query",required = false) String query, Model model){
        List<Module> moduleList = null;
        if(query == null){
            moduleList = moduleRepo.findAllByOrderByTitre();
        }else{
            moduleList = moduleRepo.findByTitreOrCode("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listModule", moduleList);

        return "cadreAdmin/createModules";
    }
    @PostMapping("/createModules")
    public String addModule(@ModelAttribute("module") Module module, RedirectAttributes redirectAttributes) {
        if(moduleRepo.save(module) != null)
            redirectAttributes.addFlashAttribute("successCreate","module ajouter avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createModules";
    }

    @PostMapping("/deleteModule/{id}")
    public String deleteModule(@PathVariable int id, RedirectAttributes redirectAttributes){
        Module module = moduleService.delete(id);
        if(module != null)
            redirectAttributes.addFlashAttribute("successDelete","module "+module.getTitre()+" code "+module.getCode()+" deleted successfuly");
        else
            redirectAttributes.addFlashAttribute("failedDelete","Something went wrong ! please try again");
        return "redirect:/cadreAdmin/createModules";
    }

    @GetMapping("/updateModule/{id}")
    public String updateModule(@PathVariable int id,Model model) {
        model.addAttribute("module",moduleRepo.findById(id).get());
        return "cadreAdmin/updateModule";
    }
    @PostMapping("/updateModule/{id}")
    public String updateModule(@PathVariable int id,@ModelAttribute("module") Module module, RedirectAttributes redirectAttributes){
        module.setIdModule(id);
        if(moduleRepo.saveAndFlush(module) != null)
            redirectAttributes.addFlashAttribute("successUpdate","module modifier avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedUpdate","module went wrong ! please try again");

        return "redirect:/cadreAdmin/createModules";
    }


//Niveau

    @ModelAttribute("niveau")
    public Niveau newNiveau(){
        return new Niveau();
    }
    @GetMapping("/createNiveau")
    public String createNiveau(@RequestParam(name = "niveauOption",required = false) Integer niveau,@RequestParam(value = "query",required = false) String query, Model model){
        List<Niveau> niveauList = null;
        if(query == null){
            niveauList = niveauRepo.findAllByOrderByTitre();
        }else{
            niveauList = niveauRepo.findByTitreOrAlias("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listNiveau", niveauList);

        //***************
        List<Module> moduleList = null;
        niveauList = niveauRepo.findAllByOrderByTitre();
        moduleList = moduleRepo.findAllByOrderByTitre();
        model.addAttribute("listNiveau", niveauList);
        model.addAttribute("listModule",moduleList);
      //  Integer niv = Integer.valueOf(niveau);
        if(niveau != null){
            model.addAttribute("niveauOption",niveau);
            model.addAttribute("niveauOptionModules",niveauService.getModulesByNiveauId(niveau));
        }
        //************

        return "cadreAdmin/createNiveau";
    }
    @PostMapping("/createNiveau")
    public String addNiveau(@ModelAttribute("niveau") Niveau niveau, RedirectAttributes redirectAttributes) {
        if(niveauRepo.save(niveau) != null)
            redirectAttributes.addFlashAttribute("successCreate","niveau ajouter avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createNiveau";
    }

    @PostMapping("/deleteNiveau/{id}")
    public String deleteNiveau(@PathVariable int id, RedirectAttributes redirectAttributes){
        Niveau niveau = niveauService.delete(id);
        if(niveau != null)
            redirectAttributes.addFlashAttribute("successDelete","niveau "+niveau.getTitre()+" alias "+niveau.getAlias()+" deleted successfuly");
        else
            redirectAttributes.addFlashAttribute("failedDelete","Something went wrong ! please try again");
        return "redirect:/cadreAdmin/createNiveau";
    }

    @GetMapping("/updateNiveau/{id}")
    public String updateNiveau(@PathVariable int id,Model model) {
        model.addAttribute("niveau",niveauRepo.findById(id).get());
        return "cadreAdmin/updateNiveau";
    }
    @PostMapping("/updateNiveau/{id}")
    public String updateNiveau(@PathVariable int id,@ModelAttribute("niveau") Niveau niveau, RedirectAttributes redirectAttributes){
        niveau.setIdNiveau(id);
        if(niveauRepo.saveAndFlush(niveau) != null)
            redirectAttributes.addFlashAttribute("successUpdate","niveau modifier avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedUpdate","something went wrong ! please try again");

        return "redirect:/cadreAdmin/createNiveau";
    }

    // assign modules to niveau

    @PostMapping("/assign-modules")
    public String  assignModulesToNiveau(@RequestParam("selectedNiveau") Integer niveauId, @RequestParam("selectedModules[]") int[] modulesIds){
        Niveau niveau = niveauService.getNiveauById(niveauId.intValue());
        List<Module> modules = moduleService.getModulesByIds(modulesIds);

        niveau.setModules(modules);
        System.out.println("Modules size : "+niveau.getModules().size());
        niveauService.saveNiveau(niveau);

        return "redirect:/cadreAdmin/createNiveau";
    }

    //Filiere

    @ModelAttribute("filiere")
    public Filiere newFiliere(){
        return new Filiere();
    }
    @GetMapping("/createFiliere")
    public String createFiliere(@RequestParam(value = "query",required = false) String query, Model model){
        List<Filiere> filiereList = null;
        if(query == null){
            filiereList = filiereRepo.findAllByOrderByTitre();
        }else{
            filiereList = filiereRepo.findByTitreOrCode("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listFiliere", filiereList);

        return "cadreAdmin/createFiliere";
    }
    @PostMapping("/createFiliere")
    public String addFiliere(@ModelAttribute("filiere") Filiere filiere, RedirectAttributes redirectAttributes) {
        if(filiereRepo.save(filiere) != null)
            redirectAttributes.addFlashAttribute("successCreate","filiere ajouter avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createFiliere";
    }

    @PostMapping("/deleteFiliere/{id}")
    public String deleteFiliere(@PathVariable int id, RedirectAttributes redirectAttributes){
        Filiere filiere = filiereService.delete(id);
        if(filiere != null)
            redirectAttributes.addFlashAttribute("successDelete","niveau "+filiere.getTitre()+" code "+filiere.getCode()+" deleted successfuly");
        else
            redirectAttributes.addFlashAttribute("failedDelete","Something went wrong ! please try again");
        return "redirect:/cadreAdmin/createFiliere";
    }

    @GetMapping("/updateFiliere/{id}")
    public String updateFiliere(@PathVariable int id,Model model) {
        model.addAttribute("filiere",filiereRepo.findById(id).get());
        return "cadreAdmin/updateFiliere";
    }
    @PostMapping("/updateFiliere/{id}")
    public String updateFiliere(@PathVariable int id,@ModelAttribute("filiere") Filiere filiere, RedirectAttributes redirectAttributes){
        filiere.setIdFiliere(id);
        if(filiereRepo.saveAndFlush(filiere) != null)
            redirectAttributes.addFlashAttribute("successUpdate","filiere modifier avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedUpdate","something went wrong ! please try again");

        return "redirect:/cadreAdmin/createFiliere";
    }
}
