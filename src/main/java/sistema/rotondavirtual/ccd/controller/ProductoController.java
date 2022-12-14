package sistema.rotondavirtual.ccd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.rotondavirtual.ccd.persistance.entity.Producto;
import sistema.rotondavirtual.ccd.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	private ProductoService productoService;

	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> logearUsuario(@RequestBody Producto producto, HttpSession session) {
		// Controlar error si no persiste al producto
		try {
			// agregar el producto
			String respuesta = productoService.agregarProducto(producto);
			// si el producto no persiste, entonces hubo un error al guardar
			if (respuesta.equals("ok")) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Objeto creado");
			}
			// en caso de que retorne algo distinto
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			// en caso de alguna excepcion, se retornara bad request.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<?> obtenerProductos() {
		// Controlar error si no persiste al producto
		try {
			// agregar el producto
			List<Producto> productos = productoService.obtenerProductos();
			// si el producto no persiste, entonces hubo un error al guardar
			if (!productos.isEmpty()) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(productos);
			}
			// en caso de que retorne algo distinto
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			// en caso de alguna excepcion, se retornara bad request.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
