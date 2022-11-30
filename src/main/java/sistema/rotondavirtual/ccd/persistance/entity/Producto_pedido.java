package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_PEDIDOS")
public class Producto_pedido implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_producto", nullable=false)
	private Producto id_producto_pedido_pk;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_pedido", nullable=false)
	private Pedido id_pedido_producto_pk;

	public Producto getId_producto_pedido_pk() {
		return id_producto_pedido_pk;
	}

	public void setId_producto_pedido_pk(Producto id_producto_pedido_pk) {
		this.id_producto_pedido_pk = id_producto_pedido_pk;
	}

	public Pedido getId_pedido_producto_pk() {
		return id_pedido_producto_pk;
	}

	public void setId_pedido_producto_pk(Pedido id_pedido_producto_pk) {
		this.id_pedido_producto_pk = id_pedido_producto_pk;
	}
	
}
