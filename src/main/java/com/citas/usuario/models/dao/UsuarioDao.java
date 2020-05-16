package com.citas.usuario.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citas.libreria.entidades.models.entity.Usuario;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String> {

}
