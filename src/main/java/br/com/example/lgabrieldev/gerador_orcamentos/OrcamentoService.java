package br.com.example.lgabrieldev.gerador_orcamentos;

import org.springframework.stereotype.Service;

import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.Orcamento;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.GeneralValidations;

@Service
public class OrcamentoService {
    
    //attributes
    private GeneralValidations generalValidations;

    //constructors
    public OrcamentoService(GeneralValidations generalValidations){
        this.generalValidations = generalValidations;
    }


    // ======================= CREATE =======================
    public Orcamento createOrcamento(OrcamentoCreate orcamentoCreate){
        
        //orcamento validations
        this.generalValidations.validateAllAttributes(orcamentoCreate);

        Orcamento orcamento = new Orcamento(orcamentoCreate);
        
        return orcamento;
    }
}
