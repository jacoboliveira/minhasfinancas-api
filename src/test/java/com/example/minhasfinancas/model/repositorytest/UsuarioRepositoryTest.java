package com.example.minhasfinancas.model.repositorytest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.minhasfinancas.model.entity.Usuario;
import com.example.minhasfinancas.model.repository.UsuarioRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenario
		Usuario usuario = Usuario.builder()
				.nome("usuario")
				.email("usuario@email.com")
				.build();
		usuarioRepository.save(usuario);
		//ação
		boolean result = usuarioRepository.existsByEmail("usuario@email.com");
		//verificação
		Assertions.assertTrue(result);
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		usuarioRepository.deleteAll();
		boolean result = usuarioRepository.existsByEmail("usuario@email.com");
		
		Assertions.assertFalse(result);
		
	}
}
