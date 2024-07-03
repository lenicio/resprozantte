package br.com.zorp.resprozante.model;

import br.com.zorp.resprozante.lista.TipoPrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Prato {
  private long id;
  private String nome;
  private double valor;
  private TipoPrato tipoPrato;
}
