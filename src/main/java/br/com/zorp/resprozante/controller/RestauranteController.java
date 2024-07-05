package br.com.zorp.resprozante.controller;

import br.com.zorp.resprozante.dto.PratoDto;
import br.com.zorp.resprozante.dto.RestauranteDto;
import br.com.zorp.resprozante.model.Prato;
import br.com.zorp.resprozante.model.Restaurante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurante")
@CrossOrigin(origins = "*")
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

    Map<String, String> resposta = new HashMap<>();
    resposta.put("mensagem", "O ID não foi encontrado!");

    return ResponseEntity.status(404).body(resposta);
  }


  @DeleteMapping("/prato")
  public ResponseEntity<Object> deletaPrato(@RequestParam long id) {
    Map<String, String> resposta = new HashMap<>();

    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        restaurante.removePrato(prato);
        resposta.put("mensagem", "Prato removido com sucesso!");
        return ResponseEntity.status(200).body(resposta);
      }
    }

    resposta.put("memsagem", "O ID Não existe!");
    return ResponseEntity.status(404).body(resposta);
  }


  @PutMapping("/prato")
  public ResponseEntity<Object> editaPrato(@RequestParam long id, @RequestBody PratoDto pratoDto) {

    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        prato.setNome(pratoDto.nome());
        prato.setValor(pratoDto.valor());
        prato.setTipoPrato(pratoDto.tipoPrato());
        return ResponseEntity.status(200).body(prato);
      }
    }

    Map<String, String> resposta = new HashMap<>();
    resposta.put("memsagem", "O ID Não existe!");
    return ResponseEntity.status(404).body(resposta);


  }

}
