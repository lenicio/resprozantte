package br.com.zorp.resprozante.controller;

import br.com.zorp.resprozante.dto.PratoDto;
import br.com.zorp.resprozante.dto.RestauranteDto;
import br.com.zorp.resprozante.model.Prato;
import br.com.zorp.resprozante.model.Restaurante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


  @PostMapping("/prato")
  public Prato adicionaPrato(@RequestBody PratoDto pratoDto) {

    return restaurante.adicionaPrato(
        new Prato(
            restaurante.getIdPrato(),
            pratoDto.nome(),
            pratoDto.valor(),
            pratoDto.tipoPrato()
        ));
  }


  @GetMapping("/pratos")
  public List<Prato> listaPrato() {
    return restaurante.getPratos();
  }


  @GetMapping("/prato")
  public ResponseEntity<Object> buscaPrato(@RequestParam long id) {
    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        return ResponseEntity.ok(prato);
      }
    }

    return ResponseEntity.notFound().build();
  }




}
