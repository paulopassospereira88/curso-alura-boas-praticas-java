package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    public ResponseEntity<String> solicitar(@RequestBody @Valid Adocao adocao) {
        try {
            this.adocaoService.solicitar(adocao);
            return ResponseEntity.ok("Adoção solicitada com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    public ResponseEntity<String> aprovar(@RequestBody @Valid Adocao adocao) {
        this.adocaoService.aprovar(adocao);
        return ResponseEntity.ok("Adoção aprovada com sucesso!");
    }

    @PutMapping("/reprovar")
    public ResponseEntity<String> reprovar(@RequestBody @Valid Adocao adocao) {
        this.adocaoService.reprovar(adocao);
        return ResponseEntity.ok("Adoção reprovada com sucesso!");
    }

}
