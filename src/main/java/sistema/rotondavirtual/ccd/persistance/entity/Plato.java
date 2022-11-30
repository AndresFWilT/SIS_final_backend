package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLATO")
public class Plato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="id_plato_prod_fk")
	private Set<Producto> productos;
	
	@Id
	@Column(length=10)
	private String id_plato;
	
	@Column(length = 50, nullable = false)
	private String descripcion_plato;

	public String getId_plato() {
		return id_plato;
	}

	public void setId_plato(String id_plato) {
		this.id_plato = id_plato;
	}

	public String getDescripcion_plato() {
		return descripcion_plato;
	}

	public void setDescripcion_plato(String descripcion_plato) {
		this.descripcion_plato = descripcion_plato;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
