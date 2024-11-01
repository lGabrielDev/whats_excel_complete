package br.com.example.lgabrieldev.gerador_orcamentos;

import org.springframework.stereotype.Service;
import br.com.example.lgabrieldev.gerador_orcamentos.criar_orcamento.GeradorOrcamentos;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.Orcamento;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.GeneralValidations;

@Service
public class OrcamentoService {
    
    //attributes
    private GeneralValidations generalValidations;
    private GeradorOrcamentos geradorOrcamentos;

    //constructors
    public OrcamentoService(GeneralValidations generalValidations, GeradorOrcamentos geradorOrcamentos){
        this.generalValidations = generalValidations;
        this.geradorOrcamentos = geradorOrcamentos;
    }


    // ======================= CREATE =======================
    public String createOrcamento(OrcamentoCreate orcamentoCreate){
        
        //orcamento validations
        this.generalValidations.validateAllAttributes(orcamentoCreate);

        
        //criar orcamento
        Orcamento dadosOrcamento = new Orcamento(orcamentoCreate);
       


        return  this.geradorOrcamentos.criarOrcamento(dadosOrcamento);
    }
}
