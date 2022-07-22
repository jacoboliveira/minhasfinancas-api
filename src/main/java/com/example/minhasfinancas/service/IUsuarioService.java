package com.example.minhasfinancas.service;

import com.example.minhasfinancas.model.entity.Usuario;

public interface IUsuarioService {

	public Usuario autenticar(String email,String senha);
	
	public Usuario salvar(Usuario usuario);
	
	public void validarEmail(String email);
}
