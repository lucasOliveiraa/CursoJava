package br.com.javaweb.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.javaweb.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
	USUARIOS.put("lucas_prog@hotmail.com", new Usuario("lucas_prog@hotmail.com","1234"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
