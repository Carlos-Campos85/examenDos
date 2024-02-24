package ExamenDos.examenDos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ExamenDos.examenDos.models.Genero;
import ExamenDos.examenDos.service.GeneroService;

@Controller
@RequestMapping("/genero")
public class GeneroController {
	@Autowired
    private GeneroService generoService;

    //Listar
    @GetMapping("/listagenero")
    public String getAllGenero(Model model) {
        List<Genero> listGenero = generoService.getAllGenero();
        return "generoList";
    }

    //Ingresar Genero
    @GetMapping("/register")
    public String register() {
        return "generoRegister";
    }

    //Ingresar datos
    @PostMapping("/register")
    public String createGenero(@RequestParam("nombre") String nombre, Model model) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoService.createGenero(genero);
        List<Genero> listGenero = generoService.getAllGenero();
        model.addAttribute("genero", listGenero);
        return "generarList";
    }

    @GetMapping("/edit/{id}")
    public String getGeneroByID(@RequestParam Long idgenero, Model model) {
        Genero genero = generoService.getGeneroById(idgenero);
        model.addAttribute("genero", genero);
        return "generoEdit";
    }

    @PostMapping("/edit")
    public String editGenero(@RequestParam("idgenero") Long idgenero, @RequestParam("nombre") String nombre, Model model) {
        Genero genero = generoService.getGeneroById(idgenero);
        genero.setNombre(nombre);

        generoService.createGenero(genero);
        List<Genero> listGenero = generoService.getAllGenero();
        model.addAttribute("genero", listGenero);
        return "generarList";

    }

    @GetMapping("/delete/{id}")
    public String deleteGenero(@PathVariable Long idgenero, Model model) {
        generoService.deleteGenero(idgenero);
        List<Genero> listGenero = generoService.getAllGenero();
        model.addAttribute("genero", listGenero);
        return "generarList";
    }


}