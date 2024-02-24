package ExamenDos.examenDos.controllers;

import java.sql.Timestamp;
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
import ExamenDos.examenDos.models.Pelicula;
import ExamenDos.examenDos.service.PeliculaService;
import ExamenDos.examenDos.service.GeneroService;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
	
	@Autowired
    private PeliculaService peliculaService;

    @Autowired
    private GeneroService generoService;
	
	@GetMapping("/peliculalist")
    public String getAllPelicula(Model model) {
    	
        List<Pelicula> listPelicula = peliculaService.getAllPelicula();
        
        model.addAttribute("peliculas",listPelicula);
        
        return "peliculaList";
    }

    @GetMapping("/register")
    public String register() {
    	return "registrarPelicula";
    }


    @PostMapping("/register")
public String createPelicula(@RequestParam("nombre") String nombre,
                             @RequestParam("director") String director,
                             @RequestParam("fechaEstreno") String fechaEstreno,
                             @RequestParam("genero") Long generoId, // Cambio aquí
                             Model model) {
    Pelicula pelicula = new Pelicula();
    pelicula.setNombre(nombre);
    pelicula.setDirector(director);
    pelicula.setFechaEstreno(Timestamp.valueOf(fechaEstreno + " 00:00:00"));

    // Obtener el Genero correspondiente al ID seleccionado en el formulario
    Genero genero = generoService.getGeneroById(generoId);

    // Asignar el Genero a la Pelicula
    pelicula.setGenero(genero);

    peliculaService.createPelicula(pelicula);

    List<Pelicula> listPelicula = peliculaService.getAllPelicula();
    model.addAttribute("pelicula", listPelicula);
    return "peliculaList";
}
    

@GetMapping("/edit/{idPelicula}")
public String getPeliculaID(@PathVariable Long idPelicula, Model model) {
    Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
    model.addAttribute("pelicula", pelicula);
    return "peliculaEdit";
}

@PostMapping("/edit")
public String editPelicula(@RequestParam("idPelicula") Long idPelicula,
                           @RequestParam("nombre") String nombre,
                           @RequestParam("director") String director,
                           @RequestParam("fechaEstreno") String fechaEstreno,
                           Model model) {
    Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
    pelicula.setNombre(nombre);
    pelicula.setDirector(director);
    pelicula.setFechaEstreno(Timestamp.valueOf(fechaEstreno + " 00:00:00"));
    peliculaService.createPelicula(pelicula);
    List<Pelicula> listPelicula = peliculaService.getAllPelicula();
    model.addAttribute("pelicula", listPelicula);
    return "peliculaList";
}
   
   
    @GetMapping("/delete/{idPelicula}")
    public String deletePelicula(@PathVariable Long idPelicula, Model model) {
        peliculaService.deletePelicula(idPelicula);
        List<Pelicula> listPelicula = peliculaService.getAllPelicula();
        model.addAttribute("pelicula", listPelicula);
        return "peliculaList";
    }

}