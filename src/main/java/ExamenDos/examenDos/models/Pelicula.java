package ExamenDos.examenDos.models;

import jakarta.persistence.*;


import java.sql.Timestamp;

@Entity

@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpelicula", nullable = false)
    public Long idPelicula;
    @Column(name = "nombre", nullable = false, length = 45)
    public String nombre;
    @Column(name = "director", nullable = false, length = 45)
    public String director;
    @Column(name = "fechaestreno", nullable = false)
    public Timestamp fechaEstreno;
	
    @ManyToOne
    @JoinColumn(name = "idgenero", nullable = false)
    public Genero genero;
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pelicula(Long idPelicula, String nombre, String director, Timestamp fechaEstreno, Genero genero) {
		super();
		this.idPelicula = idPelicula;
		this.nombre = nombre;
		this.director = director;
		this.fechaEstreno = fechaEstreno;
		this.genero = genero;
	}
	public Long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Timestamp getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Timestamp fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
    
    

}

