package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_PEDIDO")
public class Producto_pedido implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_producto_pedido_pk", nullable=false)
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_pedido_producto_pk", nullable=false)
	private Pedido pedido;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
