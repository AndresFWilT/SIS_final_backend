package sistema.rotondavirtual.ccd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.rotondavirtual.ccd.persistance.entity.Usuario;
import sistema.rotondavirtual.ccd.persistance.repository.UsuarioRepository;

@Service
public class UsuarioService {

	// Retorna el objeto
	// Lógica del negocio

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> validarUsuario(Usuario usuario) {
		List<Usuario> usuarioEncontrado = usuarioRepository.encontrarUsuario(usuario.getId_usuario());
		if (!usuarioEncontrado.isEmpty()) {
			if (usuarioEncontrado.get(0).getContrasena_usuario().equals(usuario.getContrasena_usuario())) {
				return usuarioEncontrado;
			}
		}
		return null;
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

}
