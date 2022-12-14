package sistema.rotondavirtual.ccd.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import sistema.rotondavirtual.ccd.persistance.entity.Producto;
import sistema.rotondavirtual.ccd.persistance.repository.ProductoRepository;

@Service
public class ProductoService {

	// Retorna el objeto
	// Lógica del negocio

	private ProductoRepository productoRepository;

	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public String agregarProducto(Producto producto) {
		LocalDateTime time = LocalDateTime.now();
		producto.setTiempo_preparacion(time.toString());
		if (productoRepository.agregarProducto(producto).equals("ok")) {
			return "ok";
		}
		return null;
	}

	public List<Producto> obtenerProductos() {
		List<Producto> productos = productoRepository.listarProductos();
		if(!productos.isEmpty()) {
			return productos;
		}
		return null;
	}

}
