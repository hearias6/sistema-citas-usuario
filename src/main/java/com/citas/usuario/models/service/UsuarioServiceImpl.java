package com.citas.usuario.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citas.libreria.entidades.models.entity.Usuario;
import com.citas.usuario.models.dao.UsuarioDao;

import brave.Tracer;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private Tracer trace;
	
	@Autowired 
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario consultarUsuario(String username) {
		try {
			trace.currentSpan().tag("error.mensaje", "Validandao el id del usuario.");
			return usuarioDao.findById(username).orElse(null);
		} catch (Exception e) {
			String mensajeError = "Error en service consultar usuario " + e.getMessage();
			trace.currentSpan().tag("error.mensaje", mensajeError);
			return null;
		}
	}

	@Override
	public List<Usuario> usuarios() {
		return usuarioDao.findAll();
	}

	@Override
	public Usuario actualizar(Usuario usuario, String username) {
		
		Usuario usuarioDb = usuarioDao.findById(username).orElse(null);
		
		if(usuarioDb == null) {
			String mensajeError = "Error en service actualizar usuario, no existe el usuario " + username;
			trace.currentSpan().tag("error.mensaje", mensajeError);
			return null;
		}
		
		usuarioDb.setIntentos(usuario.getIntentos());
		usuarioDb.setEstado(usuario.getEstado());
		
		usuarioDao.save(usuarioDb);
		
		return usuarioDb;
	}

	
	
}
