package com.example.minhasfinancas.api.dto;

import java.math.BigDecimal;

import com.example.minhasfinancas.model.entity.Usuario;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LancamentoDTO {

	private Long id;
	private String descricao;
	private Integer mes;
	private Integer ano;
	private BigDecimal valor;
	private Usuario usuario;
	private String tipo;
	private String status;
}
