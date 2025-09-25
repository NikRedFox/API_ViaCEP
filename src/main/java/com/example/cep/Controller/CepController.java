package com.example.cep.Controller;

import com.example.cep.model.Cep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cep")

public class CepController {

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable String cep){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/"+cep+"/json/";
        Cep endereco = restTemplate.getForObject(url, Cep.class);
        return ResponseEntity.ok(endereco);
    }
}
