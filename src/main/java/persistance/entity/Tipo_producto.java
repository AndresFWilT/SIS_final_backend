package persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_PRODUCTO")
public class Tipo_producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="tipo_producto")
	private Set<Producto> productos;
	
	@Id
	@Column(length=10)
	private String id_tipo_producto;
	
	@Column(length = 50, nullable = false)
	private String descripcion_tipo_prod;

	public String getId_tipo_producto() {
		return id_tipo_producto;
	}

	public void setId_tipo_producto(String id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public String getDescripcion_tipo_prod() {
		return descripcion_tipo_prod;
	}

	public void setDescripcion_tipo_prod(String descripcion_tipo_prod) {
		this.descripcion_tipo_prod = descripcion_tipo_prod;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
}
