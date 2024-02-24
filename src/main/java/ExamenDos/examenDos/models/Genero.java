package ExamenDos.examenDos.models;
import jakarta.persistence.*;


@Entity

@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenero", nullable = false)
    private Long idGenero;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero(Long idGenero, String nombre) {
		super();
		this.idGenero = idGenero;
		this.nombre = nombre;
	}
	public Genero() {
		super();
		// TODO Auto-generated constructor stub
	}


}
