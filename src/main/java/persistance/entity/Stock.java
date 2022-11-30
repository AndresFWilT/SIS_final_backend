package persistance.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="id_producto", nullable=false)
	private Producto id_producto_stock_fk;
	
	@Id
	@Column(length=10)
	private String id_stock;
	
	@Column(length = 1024, nullable = false)
	private String cantidad_en_stock;
	
	@Column(length = 3, nullable = false)
	private String min_en_stock;
	
	@Column(nullable = false)
	@DateTimeFormat(style="S-")
	private Date fecha_restock;

	public Producto getId_producto_stock_fk() {
		return id_producto_stock_fk;
	}

	public void setId_producto_stock_fk(Producto id_producto_stock_fk) {
		this.id_producto_stock_fk = id_producto_stock_fk;
	}

	public String getId_stock() {
		return id_stock;
	}

	public void setId_stock(String id_stock) {
		this.id_stock = id_stock;
	}

	public String getCantidad_en_stock() {
		return cantidad_en_stock;
	}

	public void setCantidad_en_stock(String cantidad_en_stock) {
		this.cantidad_en_stock = cantidad_en_stock;
	}

	public String getMin_en_stock() {
		return min_en_stock;
	}

	public void setMin_en_stock(String min_en_stock) {
		this.min_en_stock = min_en_stock;
	}

	public Date getFecha_restock() {
		return fecha_restock;
	}

	public void setFecha_restock(Date fecha_restock) {
		this.fecha_restock = fecha_restock;
	}
	
}
