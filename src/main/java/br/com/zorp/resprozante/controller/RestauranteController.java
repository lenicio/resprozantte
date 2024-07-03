package br.com.zorp.resprozante.controller;

import br.com.zorp.resprozante.dto.RestauranteDto;
import br.com.zorp.resprozante.model.Restaurante;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

  Restaurante restaurante = new Restaurante();


  @PutMapping
  public Restaurante editaRestaurante(@RequestBody RestauranteDto restauranteDto) {
    restaurante.setNome(restauranteDto.nome());
    restaurante.setEndereco(restauranteDto.endereco());
    return restaurante;
  }




}
