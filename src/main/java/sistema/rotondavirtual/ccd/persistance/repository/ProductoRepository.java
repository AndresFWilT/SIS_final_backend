package sistema.rotondavirtual.ccd.persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sistema.rotondavirtual.ccd.persistance.entity.Producto;
import sistema.rotondavirtual.ccd.persistance.mapper.IProductoMapper;

@Repository
public class ProductoRepository implements IProductoMapper {

	// Inyección de independencias
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String agregarProducto(Producto producto) {
		System.out.println(producto.getTipo_producto().getId_tipo_producto());
		String insert = "INSERT INTO PRODUCTO VALUES ('"+producto.getId_producto()+"','"+producto.getTipo_producto().getId_tipo_producto()+"','"+producto.getPlato().getId_plato()+"','"+producto.getNombre_producto()+"','"+producto.getTiempo_preparacion()+"',"+producto.getCosto_producto()+")";
		int query = jdbcTemplate.update(insert);
		if (query == 0) {
			return null;
		}
		return "ok";
	}
	
	public List<Producto> listarProductos() {
		return jdbcTemplate.query("SELECT * FROM PRODUCTO",
				BeanPropertyRowMapper.newInstance(Producto.class)); 
	}

}
