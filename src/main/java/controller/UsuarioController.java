package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import persistance.entity.Usuario;
import service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/acceder")
	public ResponseEntity<?> logearUsuario(@RequestBody Usuario usuario, HttpSession session) {
		// Controlar error si no encuentra usuario
		System.out.println(usuario);
		try {
			if (usuarioService.encontrarPorCorreo(usuario) == null) {
				return ResponseEntity.notFound().build();
			}
			session.setAttribute("correo_usuario", usuario.getCorreo_usuario());
			return ResponseEntity.ok(usuarioService.encontrarPorCorreo(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuarioService.encontrarPorCorreo(usuario));
		}
	}
	
	@GetMapping
	public ResponseEntity<?> verUsuarios() {
		try {
			return ResponseEntity.ok(usuarioService.listarUsuarios());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
