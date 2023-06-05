package com.chaimae.absence_app.controllers;

import com.chaimae.absence_app.models.*;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.repositories.*;
import com.chaimae.absence_app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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

    @Autowired
    private CoordinationRepo coordinationRepo;

    @Autowired
    private CoordinationService coordinationService;


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
    public String createModules(@RequestParam(name = "moduleOption",required = false) Integer module,@RequestParam(value = "query",required = false) String query, Model model){
        List<Module> moduleList = null;
        if(query == null){
            moduleList = moduleRepo.findAllByOrderByTitre();
        }else{
            moduleList = moduleRepo.findByTitreOrCode("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listModule", moduleList);

        //***************
        List<Matiere> matiereList = null;
        moduleList = moduleRepo.findAllByOrderByTitre();
        matiereList = matiereRepo.findAllByOrderByNom();
        model.addAttribute("listModule", moduleList);
        model.addAttribute("listMatiere",matiereList);
        if(module != null){
            model.addAttribute("moduleOption",module);
            model.addAttribute("moduleOptionMatieres",moduleService.getMatieresByModuleId(module));
        }
        //************

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

    @PostMapping("/assign-elements")
    public String  assignElementsToModule(@RequestParam("selectedModule") Integer moduleId, @RequestParam("selectedElements[]") int[] elementsIds){
        Module module = moduleService.getModuleById(moduleId.intValue());
        for(Matiere m : matiereService.getMatieresByIds(elementsIds)){
            m.setModule(module);
            matiereRepo.save(m);
        }
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
        for(Module m : moduleService.getModulesByIds(modulesIds)){
            m.setNiveau(niveau);
            moduleRepo.save(m);
        }

        return "redirect:/cadreAdmin/createNiveau";
    }

    //Filiere

    @ModelAttribute("filiere")
    public Filiere newFiliere(){
        return new Filiere();
    }
    @GetMapping("/createFiliere")
    public String createFiliere(@RequestParam(name = "filiereOption",required = false) Integer filiere,@RequestParam(value = "query",required = false) String query, Model model){
        List<Filiere> filiereList = null;
        if(query == null){
            filiereList = filiereRepo.findAllByOrderByTitre();
        }else{
            filiereList = filiereRepo.findByTitreOrCode("%"+query+"%");
        }
        model.addAttribute("query", query);
        model.addAttribute("listFiliere", filiereList);

        //***************
        List<Niveau> niveauList = null;
        filiereList = filiereRepo.findAllByOrderByTitre();
        niveauList = niveauRepo.findAllByOrderByTitre();
        model.addAttribute("listFiliere", filiereList);
        model.addAttribute("listNiveau",niveauList);
        if(filiere != null){
            model.addAttribute("filiereOption",filiere);
            model.addAttribute("filiereOptionNiveaux",filiereService.getNiveauxByFiliereId(filiere));
        }
        //************

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

    @PostMapping("/assign-niveaux")
    public String  assignNiveauxToFiliere(@RequestParam("selectedFiliere") Integer filiereId, @RequestParam("selectedNiveaux[]") int[] niveauxIds){
        Filiere filiere = filiereService.getFiliereById(filiereId.intValue());
        //**********************
        for(Niveau n : niveauService.getNiveauxByIds(niveauxIds)){
            n.setFiliere(filiere);
            niveauRepo.save(n);
        }

        return "redirect:/cadreAdmin/createFiliere";
    }

    //coordination

    @Autowired
    private EnseignantRepo enseignantRepo;

    @ModelAttribute("coordination")
    public Coordination newCoordination(){
        return new Coordination();
    }
    @GetMapping("/createCoordination")
    public String createCoordination(@RequestParam(value = "query",required = false) String query, Model model){

        //****
        List<Filiere> filiereList = null;
        filiereList = filiereRepo.findAllByOrderByTitre();
        model.addAttribute("listFiliere", filiereList);
        //****
        //****
        List<Enseignant> EnseignantList = null;
        EnseignantList = enseignantRepo.findAllByOrderByNom();
        model.addAttribute("listUtilisateur", EnseignantList);
        //****
        List<Coordination> coordinationList = null;
        if(query == null){
            coordinationList = coordinationRepo.findAllByOrderByDateDebut();
        }else{
            coordinationList = coordinationRepo.findByDateDebutOrDateFin("%"+query+"%");
        }

        model.addAttribute("query", query);
        model.addAttribute("listCoordination", coordinationList);
        return "cadreAdmin/createCoordination";
    }
    @PostMapping("/createCoordination")
    public String addCoordination(@ModelAttribute("coordination") Coordination coordination, RedirectAttributes redirectAttributes,Model model) {
        //Filiere fil = filiereService.getFiliereById(coordination.getFiliere().getIdFiliere());
        //coordination.setFiliere(fil);
        if(coordinationRepo.save(coordination) != null)
            redirectAttributes.addFlashAttribute("successCreate","coordination ajouter avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedCreate","Something went wrong ! please try again");

        return "redirect:/cadreAdmin/createCoordination";
    }

    @PostMapping("/deleteCoordination/{id}")
    public String deleteCoordination(@PathVariable int id, RedirectAttributes redirectAttributes){
        Coordination coordination = coordinationService.delete(id);
        if(coordination != null)
            redirectAttributes.addFlashAttribute("successDelete","coordination debut: "+coordination.getDateDebut()+" fin: "+coordination.getDateFin()+" deleted successfuly");
        else
            redirectAttributes.addFlashAttribute("failedDelete","Something went wrong ! please try again");
        return "redirect:/cadreAdmin/createCoordination";
    }

    @GetMapping("/updateCoordination/{id}")
    public String updateCoordination(@PathVariable int id,Model model) {
        //****
        List<Filiere> filiereList = null;
        filiereList = filiereRepo.findAllByOrderByTitre();
        model.addAttribute("listFiliere", filiereList);
        //****
        //****
        List<Enseignant> EnseignantList = null;
        EnseignantList = enseignantRepo.findAllByOrderByNom();
        model.addAttribute("listUtilisateur", EnseignantList);
        //****
        model.addAttribute("coordination",coordinationRepo.findById(id).get());
        return "cadreAdmin/updateCoordination";
    }
    @PostMapping("/updateCoordination/{id}")
    public String updateCoordination(@PathVariable int id,@ModelAttribute("coordination") Coordination coordination, RedirectAttributes redirectAttributes){
        coordination.setIdCoordination(id);
        if(coordinationRepo.saveAndFlush(coordination) != null)
            redirectAttributes.addFlashAttribute("successUpdate","coordination modifier avec success"); // message d une duree de vie egale a une seule requette http
        else
            redirectAttributes.addFlashAttribute("failedUpdate","something went wrong ! please try again");

        return "redirect:/cadreAdmin/createCoordination";
    }
}
