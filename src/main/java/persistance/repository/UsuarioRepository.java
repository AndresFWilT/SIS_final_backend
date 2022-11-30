package persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import persistance.entity.Usuario;
import persistance.mapper.IUsuarioMapper;

public class UsuarioRepository implements IUsuarioMapper {

	//Inyección de independencias
	private JdbcTemplate jdbcTemplate;
		
	@Autowired
	public UsuarioRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate	=	jdbcTemplate;
	}
	
	@Override
	public List<Usuario> validarUsuario(String correo_usuario) {
		return jdbcTemplate.query("SELECT u.correo_usuario, u.contrasena_usuario FROM USUARIO u WHERE u.correo_usuario = '"+correo_usuario+"'",BeanPropertyRowMapper.newInstance(Usuario.class));
	}

	public List<Usuario> listarUsuarios() {
		return jdbcTemplate.query("SELECT u.id_usuario, u.correo_usuario, u.telefono_usuario FROM usuario u", BeanPropertyRowMapper.newInstance(Usuario.class));
	}

}
