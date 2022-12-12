package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_fac_fk", nullable=false)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="id_pedido_fac_fk", nullable=false)
	private Pedido pedido;
	
	@Id
	@Column(length = 10)
	private String id_factura;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date fecha_factura;
	
	@Column(length = 1024, nullable = false)
	private String total_factura;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getId_factura() {
		return id_factura;
	}

	public void setId_factura(String id_factura) {
		this.id_factura = id_factura;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public String getTotal_factura() {
		return total_factura;
	}

	public void setTotal_factura(String total_factura) {
		this.total_factura = total_factura;
	}
	
}
