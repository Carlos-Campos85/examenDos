package ExamenDos.examenDos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenDos.examenDos.models.Pelicula;
import ExamenDos.examenDos.repository.PeliculaRepository;

@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	public List<Pelicula> getAllPelicula() {
        return peliculaRepository.findAll();
    }
 
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
 
    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
 
    public Pelicula getPeliculaById(Long id) {
 
        return peliculaRepository.findById(id).orElse(null);
    }

}
