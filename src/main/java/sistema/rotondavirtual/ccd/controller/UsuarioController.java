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

import sistema.rotondavirtual.ccd.persistance.entity.Usuario;
import sistema.rotondavirtual.ccd.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/acceder")
	public ResponseEntity<?> logearUsuario(@RequestBody Usuario usuario, HttpSession session) {
		// Controlar error si no encuentra usuario
		try {
			// lista que trae todos los datos del usuario en caso de existir, y en caso de que no, trae un null
			List<Usuario> usuarioEncontrado = usuarioService.validarUsuario(usuario);
			// si el usuario es nulo, implica que algunas de las credenciales estan mal
			if (usuarioEncontrado == null) {
				return ResponseEntity.notFound().build();
			}
			// en caso de que retorne algo distinto a null, se creara la sesion con el id del usuario y retornara ok con los datos del mismo en un JSON.
			session.setAttribute("id_usuario", usuario.getId_usuario());
			return ResponseEntity.ok(usuarioEncontrado);
		} catch (Exception e) {
			// en caso de alguna excepcion, se retornara bad request.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	public ResponseEntity<?> verUsuarios() {
		// path para traer todos los usuarios
		try {
			return ResponseEntity.ok(usuarioService.listarUsuarios());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
