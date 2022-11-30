package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="id_usuario_ped_fk")
	private Set<Pedido> pedidos;
	
	@OneToMany(mappedBy="id_usuario_fac_fk")
	private Set<Factura> facturas;
	
	@Id
	@Column(length = 10)
	private String id_usuario;
	
	@Column(length = 10, nullable = false)
	private String telefono_usuario;
	
	@Column(length = 50, nullable = false)
	private String correo_usuario;
	
	@Column(length = 20, nullable = false)
	private String contrasena_usuario;
	
	@Column(length = 2, nullable = false)
	private String estado_usuario;
	
	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public String getCorreo_usuario() {
		return correo_usuario;
	}

	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}

	public String getContrasena_usuario() {
		return contrasena_usuario;
	}

	public void setContrasena_usuario(String contrasena_usuario) {
		this.contrasena_usuario = contrasena_usuario;
	}

	public String getEstado_usuario() {
		return estado_usuario;
	}

	public void setEstado_usuario(String estado_usuario) {
		this.estado_usuario = estado_usuario;
	}

}
