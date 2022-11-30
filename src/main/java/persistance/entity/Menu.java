package persistance.entity;

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
	@JoinColumn(name="id_producto", nullable=false)
	private Producto id_producto_menu_pk;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_restaurante", nullable=false)
	private Restaurante id_restaurante_menu_pk;

	public Producto getId_producto_menu_pk() {
		return id_producto_menu_pk;
	}

	public void setId_producto_menu_pk(Producto id_producto_menu_pk) {
		this.id_producto_menu_pk = id_producto_menu_pk;
	}

	public Restaurante getId_restaurante_menu_pk() {
		return id_restaurante_menu_pk;
	}

	public void setId_restaurante_menu_pk(Restaurante id_restaurante_menu_pk) {
		this.id_restaurante_menu_pk = id_restaurante_menu_pk;
	}
	
	
}
