package com.cenfotec.lab5.lab5.controller;

import com.cenfotec.lab5.lab5.domain.Persona;
import com.cenfotec.lab5.lab5.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @RequestMapping("/persona")
    public String persona(Model model) {
        model.addAttribute("persona", personaService.getAll());
        return "persona";
    }

    @RequestMapping(value = "/agregarPersona", method = RequestMethod.GET)
    public String navegarPaginaAgregar(Model model){
        model.addAttribute(new Persona());
        return "agregarPersona";
    }

    @RequestMapping(value = "/agregarPersona", method = RequestMethod.POST)
    public String accionPaginaAgregar(Persona persona, BindingResult result, Model model){
        persona.setDob(Date.from(Instant.now()));
        personaService.savePersona(persona);
        return "persona";
    }
 /*------------------------------------------------------------------------------------*/
    @RequestMapping(value = "/editarPersona/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Persona> personaToEdit = personaService.getById(id);
        if (personaToEdit.isPresent()){
            model.addAttribute("personaToEdit", personaToEdit);
            return "editarPersona";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarPersona/{id}", method = RequestMethod.POST)
    public String guardarCambios(Persona persona, BindingResult result,Model model,
                                 @PathVariable int id) {
        persona.setDob(Date.from(Instant.now()));
        personaService.updatePersona(persona);
        return "exito";
    }


    @RequestMapping(value = "/borrarPersona/{id}")
    public String borrar(Model model, @PathVariable int id){
        personaService.deletePersona(id);

        return "exito";
    }
    
    
    
}
