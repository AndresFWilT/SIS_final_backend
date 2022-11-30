package persistance.entity;

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
@Table(name = "PRODUCTO")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_producto", nullable=false)
	private Tipo_producto id_tipo_producto_prod_fk;
	
	@ManyToOne
	@JoinColumn(name="id_plato", nullable=false)
	private Centro_comercial id_plato_prod_fk;
	
	@OneToMany(mappedBy="producto")
	private Set<Producto_pedido> producto_pedidos;
	
	@OneToMany(mappedBy="producto")
	private Set<Menu> menus;
	
	@OneToOne(mappedBy="producto")
	private Stock stock;
	
	@Id
	@Column(length=10)
	private String id_producto;
	
	@Column(length = 50, nullable = false)
	private String nombre_producto;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date tiempo_preparacion;
	
	@Column(nullable = false)
	private int costo_producto;

	public Tipo_producto getId_tipo_producto_prod_fk() {
		return id_tipo_producto_prod_fk;
	}

	public void setId_tipo_producto_prod_fk(Tipo_producto id_tipo_producto_prod_fk) {
		this.id_tipo_producto_prod_fk = id_tipo_producto_prod_fk;
	}

	public Centro_comercial getId_plato_prod_fk() {
		return id_plato_prod_fk;
	}

	public void setId_plato_prod_fk(Centro_comercial id_plato_prod_fk) {
		this.id_plato_prod_fk = id_plato_prod_fk;
	}
	
	public Set<Producto_pedido> getProducto_pedidos() {
		return producto_pedidos;
	}

	public void setProducto_pedidos(Set<Producto_pedido> producto_pedidos) {
		this.producto_pedidos = producto_pedidos;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Date getTiempo_preparacion() {
		return tiempo_preparacion;
	}

	public void setTiempo_preparacion(Date tiempo_preparacion) {
		this.tiempo_preparacion = tiempo_preparacion;
	}

	public int getCosto_producto() {
		return costo_producto;
	}

	public void setCosto_producto(int costo_producto) {
		this.costo_producto = costo_producto;
	}
	
	
}
