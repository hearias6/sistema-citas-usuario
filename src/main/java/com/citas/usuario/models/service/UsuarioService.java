package com.citas.usuario.models.service;

import java.util.List;

import com.citas.libreria.entidades.models.entity.Usuario;

public interface UsuarioService {
	Usuario consultarUsuario(String username);
	List<Usuario> usuarios();
	Usuario actualizar(Usuario usuario, String username);
}
