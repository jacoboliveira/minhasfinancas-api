package com.example.minhasfinancas.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.minhasfinancas.api.dto.LancamentoDTO;
import com.example.minhasfinancas.enums.TipoLancamento;
import com.example.minhasfinancas.model.entity.Lancamento;
import com.example.minhasfinancas.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
		
	}
	
	private Lancamento converter(LancamentoDTO dto) {
		Lancamento lancamento = new Lancamento();
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setAno(dto.getAno());
		lancamento.setMes(dto.getMes());
		lancamento.setValor(dto.getValor());
		lancamento.setUsuario(dto.getUsuario());
		lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
		return lancamento;
	}
