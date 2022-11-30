package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable=false)
	private Usuario id_usuario_ped_fk;
	
	@OneToOne(mappedBy="id_pedido_fac_fk")
	private Factura factura;
	
	@OneToMany(mappedBy="id_pedido_producto_pk")
	private Set<Producto_pedido> producto_pedidos;
	
	@Id
	@Column(length = 10)
	private String id_pedido;
	
	@Column(length = 2, nullable = false)
	private String estado_pedido;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date tiempo_estimado_pedido;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date tiempo_confirmacion_pedido;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date fecha_pedido;

	public Usuario getId_usuario_ped_fk() {
		return id_usuario_ped_fk;
	}

	public void setId_usuario_ped_fk(Usuario id_usuario_ped_fk) {
		this.id_usuario_ped_fk = id_usuario_ped_fk;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Set<Producto_pedido> getProducto_pedidos() {
		return producto_pedidos;
	}

	public void setProducto_pedidos(Set<Producto_pedido> producto_pedidos) {
		this.producto_pedidos = producto_pedidos;
	}

	public String getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(String id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}

	public Date getTiempo_estimado_pedido() {
		return tiempo_estimado_pedido;
	}

	public void setTiempo_estimado_pedido(Date tiempo_estimado_pedido) {
		this.tiempo_estimado_pedido = tiempo_estimado_pedido;
	}

	public Date getTiempo_confirmacion_pedido() {
		return tiempo_confirmacion_pedido;
	}

	public void setTiempo_confirmacion_pedido(Date tiempo_confirmacion_pedido) {
		this.tiempo_confirmacion_pedido = tiempo_confirmacion_pedido;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	
}
