package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MENU")
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_producto_menu_pk", nullable=false)
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_restaurante_menu_pk", nullable=false)
	private Restaurante restaurante;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
