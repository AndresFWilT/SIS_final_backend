package persistance.mapper;

import java.util.List;

import javax.transaction.Transactional;

import persistance.entity.Usuario;

public interface IUsuarioMapper {

		// Encontrar a un paciente por su id
		@Transactional
		public List<Usuario> validarUsuario(String correo_usuario);
		
		
}
