package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import persistance.entity.Usuario;
import persistance.repository.UsuarioRepository;

public class UsuarioService {

	// Retorna el objeto
	// Lógica del negocio

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Object encontrarPorCorreo(Usuario usuario) {
		if (usuarioRepository.validarUsuario(usuario.getCorreo_usuario()).isEmpty()) {
			if (usuarioRepository.validarUsuario(usuario.getCorreo_usuario()).get(1)
					.equals(usuario.getContrasena_usuario())) {
				return usuarioRepository.validarUsuario(usuario.getCorreo_usuario());
			}
		}
		return null;
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

}
