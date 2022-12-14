package sistema.rotondavirtual.ccd.persistance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_producto;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_producto_prod_fk", nullable=false)
	private Tipo_producto tipo_producto;
	
	@ManyToOne
	@JoinColumn(name="id_plato_prod_fk", nullable=false)
	private Plato plato;
	
	@OneToMany(mappedBy="producto")
	private Set<Producto_pedido> producto_pedidos;
	
	@OneToMany(mappedBy="producto")
	private Set<Menu> menus;
	
	@OneToOne(mappedBy="producto")
	private Stock stock;
	
	@Column(length = 50, nullable = false)
	private String nombre_producto;
	
	@Column(nullable = false)
	private String tiempo_preparacion;
	
	@Column(nullable = false)
	private int costo_producto;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Tipo_producto getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(Tipo_producto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
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

	public String getTiempo_preparacion() {
		return tiempo_preparacion;
	}

	public void setTiempo_preparacion(String time) {
		this.tiempo_preparacion = time;
	}

	public int getCosto_producto() {
		return costo_producto;
	}

	public void setCosto_producto(int costo_producto) {
		this.costo_producto = costo_producto;
	}
	
	
}
