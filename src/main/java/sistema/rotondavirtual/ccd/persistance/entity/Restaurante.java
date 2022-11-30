package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@JoinColumn(name="id_comercial", referencedColumnName = "id_comercial",nullable=false)
	@ManyToOne
	private Centro_comercial id_comercial_res_fk;
	
	@OneToMany(mappedBy="id_restaurante_menu_pk")
	private Set<Menu> menus;
	
	@Id
	@Column(length=5)
	private String id_restaurante;
	
	@Column(length = 40, nullable = false)
	private String nombre_restaurante;
	
	@Column(length = 30, nullable = false)
	private String local_restaurante;
	
	@Column(length = 2, nullable = false)
	private String estado_restaurante;

	public Centro_comercial getCc() {
		return id_comercial_res_fk;
	}

	public void setCc(Centro_comercial id_comercial_res_fk) {
		this.id_comercial_res_fk = id_comercial_res_fk;
	}

	public Centro_comercial getId_comercial_res_fk() {
		return id_comercial_res_fk;
	}

	public void setId_comercial_res_fk(Centro_comercial id_comercial_res_fk) {
		this.id_comercial_res_fk = id_comercial_res_fk;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public String getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(String id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}

	public String getLocal_restaurante() {
		return local_restaurante;
	}

	public void setLocal_restaurante(String local_restaurante) {
		this.local_restaurante = local_restaurante;
	}

	public String getEstado_restaurante() {
		return estado_restaurante;
	}

	public void setEstado_restaurante(String estado_restaurante) {
		this.estado_restaurante = estado_restaurante;
	}
	
}
