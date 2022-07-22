package com.example.minhasfinancas.model.repositorytest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.minhasfinancas.exceptions.RegraNegocioException;
import com.example.minhasfinancas.model.entity.Usuario;
import com.example.minhasfinancas.model.repository.UsuarioRepository;
import com.example.minhasfinancas.service.IUsuarioService;
import com.example.minhasfinancas.service.UsuarioService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	UsuarioRepository usuarioRepository;	
	@Test
	public void deveValidarEmail() {
		//cenario
		usuarioRepository.deleteAll();
		
		//acao
		usuarioService.validarEmail("email@email.com");
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		
		RegraNegocioException thrown = Assertions.assertThrows(RegraNegocioException.class, () -> {
			//cenario
			Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
			
			usuarioRepository.save(usuario);
			
			usuarioService.validarEmail("email@email.com");
		}, "NumberFormatException was expected");
		
		Assertions.assertEquals("Já existe um usuário cadastrado com este e-mail", thrown.getMessage());
		
	}
}
