package sistema.rotondavirtual.ccd.persistance.mapper;

import java.util.List;

import javax.transaction.Transactional;

import sistema.rotondavirtual.ccd.persistance.entity.Usuario;

public interface IUsuarioMapper {

		// Encontrar a un usuario por su id
		@Transactional
		List<Usuario> encontrarUsuario(String id_usuario);
		
		
}
