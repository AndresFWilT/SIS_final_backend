package persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CENTRO_COMERCIAL")
public class Centro_comercial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="centro_comercial")
	private Set<Restaurante> restaurantes;
	
	@Id
	@Column(length=5)
	private String id_comercial;
	
	@Column(length = 2, nullable = false)
	private String estado_comercial;
	
	@Column(length = 30, nullable = false)
	private String nombre_cc;
	
	@Column(length = 50, nullable = false)
	private String ubicacion_cc;
	
	@Column(length = 50, nullable = false)
	private String direccion_cc;

	public String getId_comercial() {
		return id_comercial;
	}

	public void setId_comercial(String id_comercial) {
		this.id_comercial = id_comercial;
	}

	public Set<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(Set<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public String getEstado_comercial() {
		return estado_comercial;
	}

	public void setEstado_comercial(String estado_comercial) {
		this.estado_comercial = estado_comercial;
	}

	public String getNombre_cc() {
		return nombre_cc;
	}

	public void setNombre_cc(String nombre_cc) {
		this.nombre_cc = nombre_cc;
	}

	public String getUbicacion_cc() {
		return ubicacion_cc;
	}

	public void setUbicacion_cc(String ubicacion_cc) {
		this.ubicacion_cc = ubicacion_cc;
	}

	public String getDireccion_cc() {
		return direccion_cc;
	}

	public void setDireccion_cc(String direccion_cc) {
		this.direccion_cc = direccion_cc;
	}
	
}
