package br.com.example.lgabrieldev.gerador_orcamentos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.Orcamento;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;



@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    
    //attributes
    private OrcamentoService orcamentoService;

    //constructors
    public OrcamentoController(OrcamentoService orcamentoService){
        this.orcamentoService = orcamentoService;
    }

    // ================= POST =================
    @PostMapping("")
    public ResponseEntity<Orcamento> createOrcamento(@RequestBody OrcamentoCreate orcamentoCreate){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.orcamentoService.createOrcamento(orcamentoCreate));
    }
}
