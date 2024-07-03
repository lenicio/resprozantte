package br.com.zorp.resprozante.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Restaurante {
  private String nome;
  private String endereco;
  private List<Prato> pratos;
  private long idPrato;

  public Restaurante() {
    pratos = new ArrayList<>();
    idPrato = 0;
  }


  public void adicionaPrato(Prato prato) {
    pratos.add(prato);
    idPrato++;
  }


  public void removePrato(Prato prato) {
    pratos.remove(prato);
  }

}
