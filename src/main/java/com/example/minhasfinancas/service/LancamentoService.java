package com.example.minhasfinancas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.minhasfinancas.enums.StatusLancamento;
import com.example.minhasfinancas.exceptions.RegraNegocioException;
import com.example.minhasfinancas.model.entity.Lancamento;
import com.example.minhasfinancas.model.repository.LancamentoRepository;

@Service
public class LancamentoService implements ILancamentoService{
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Override
	public Lancamento salvar(Lancamento lancamento) {
		validar(lancamento);
		lancamento.setStatus(StatusLancamento.PENDENTE);
		return lancamentoRepository.save(lancamento);
	}

	@Override
	@Transactional
	public Lancamento atualizar(Lancamento lancamento) {
		Objects.requireNonNull(lancamento.getId());
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public void deletar(Lancamento lancamento) {
		Objects.requireNonNull(lancamento);
		lancamentoRepository.delete(lancamento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lancamento> buscar(Lancamento lancamento) {
		Example example = Example.of(lancamento,ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return lancamentoRepository.findAll(example);
	}

	@Override
	public void atualizarStatus(Lancamento lancamento, StatusLancamento status) {
		lancamento.setStatus(status);
		atualizar(lancamento);
	}

	@Override
	public void validar(Lancamento lancamento) {
		if(lancamento.getDescricao() == null || lancamento.getDescricao().trim().equals("")) {
			throw new RegraNegocioException("Informe uma descrição válida");
		}
		
		if(lancamento.getMes()==null|| lancamento.getMes() < 1 || lancamento.getMes()>12) {
			throw new RegraNegocioException("Informe um mês válido");
		}
		
		if(lancamento.getAno()==null|| lancamento.getAno().toString().length()!=4)  {
			throw new RegraNegocioException("Informe um ano válido");
		}
		
		if(lancamento.getUsuario()==null|| lancamento.getUsuario().getId()==null)  {
			throw new RegraNegocioException("Informe um usuário");
		}		
		
		if(lancamento.getValor()==null|| lancamento.getValor().compareTo(BigDecimal.ZERO) < 1)  {
			throw new RegraNegocioException("Informe um valor válido");
		}		
		
		if(lancamento.getTipo()==null)  {
			throw new RegraNegocioException("Informe o tipo de lancamento");
		}
	}

}
