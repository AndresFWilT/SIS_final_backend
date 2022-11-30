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
