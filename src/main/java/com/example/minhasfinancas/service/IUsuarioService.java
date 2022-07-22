package com.example.minhasfinancas.service;

import java.util.Optional;

import com.example.minhasfinancas.model.entity.Usuario;

public interface IUsuarioService {

	public Usuario autenticar(String email,String senha);
	
	public Usuario salvar(Usuario usuario);
	
	public void validarEmail(String email);
	
	public Optional<Usuario> findById(Long id);
}
