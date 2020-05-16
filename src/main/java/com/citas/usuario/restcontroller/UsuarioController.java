package com.citas.usuario.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citas.libreria.entidades.models.entity.Usuario;
import com.citas.usuario.models.service.UsuarioService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@HystrixCommand(fallbackMethod = "errorConsultarUsuario")
	@GetMapping("/{username}")
	private Usuario consultarUsuario(
			@PathVariable("username") String username) {
		return usuarioService.consultarUsuario(username);
	}

	private Usuario errorConsultarUsuario(String username) {
		Usuario usuario = new Usuario("demo.", 0, 0, new Date(), "12345");
		return usuario;
	}
	
	@GetMapping("/")
	private List<Usuario> usuarios(){
		return usuarioService.usuarios();
	}

	@PutMapping("/actualizar/{username}")
	private Usuario actualizar(
			@PathVariable String username, @RequestBody Usuario usuario) {
		return usuarioService.actualizar(usuario, username);
	}
	
}
