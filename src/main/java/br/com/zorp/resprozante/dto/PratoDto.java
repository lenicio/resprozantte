package br.com.zorp.resprozante.dto;

import br.com.zorp.resprozante.lista.TipoPrato;

public record PratoDto(String nome, double valor, TipoPrato tipoPrato) {}
