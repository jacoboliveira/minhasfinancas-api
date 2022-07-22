package com.example.minhasfinancas.service;

import java.util.List;

import com.example.minhasfinancas.enums.StatusLancamento;
import com.example.minhasfinancas.model.entity.Lancamento;

public interface ILancamentoService {

	Lancamento salvar(Lancamento lancamento);
	Lancamento atualizar(Lancamento lancamento);
	void deletar(Lancamento lancamento);
	List<Lancamento> buscar(Lancamento lancamento);
	void atualizarStatus(Lancamento lancamento,StatusLancamento status);
	void validar(Lancamento lancamento);
}
