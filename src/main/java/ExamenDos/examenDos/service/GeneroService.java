package ExamenDos.examenDos.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenDos.examenDos.models.Genero;
import ExamenDos.examenDos.repository.GeneroRepository;



@Service
public class GeneroService {
	@Autowired
	private GeneroRepository generoRepository;

	public List<Genero> getAllGenero(){
		return generoRepository.findAll();
	}

	public Genero createGenero(Genero genero){

		return generoRepository.save(genero);

	}
		public void deleteGenero(Long id){
			generoRepository.deleteById(id);
		
	}

	public Genero getGeneroById(Long id){
		return generoRepository.findById(id).orElse(null);
	
		
	}
		
}
