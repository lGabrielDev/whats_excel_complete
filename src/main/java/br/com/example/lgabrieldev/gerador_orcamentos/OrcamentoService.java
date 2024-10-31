package br.com.example.lgabrieldev.gerador_orcamentos;

import org.springframework.stereotype.Service;

import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.Orcamento;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemDescricaoValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ClienteValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.DescricaoValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ObservacoesValidations;

@Service
public class OrcamentoService {
    

    // ======================= CREATE =======================
    public Orcamento createOrcamento(OrcamentoCreate orcamentoCreate){
        
        //orcamento validations
        ClienteValidations clienteValidations = new ClienteValidations();
        clienteValidations.allValidationsAreGood(orcamentoCreate.getCliente());
        
        DescricaoValidations descricaoValidations = new DescricaoValidations();
        descricaoValidations.allValidationsAreGood(orcamentoCreate.getDescricao());

        ObservacoesValidations observacoesValidations = new ObservacoesValidations();
        observacoesValidations.allValidationsAreGood(orcamentoCreate.getObservacoes());
        
        //items validations
        ItemDescricaoValidations itemDescricaoValidations = new ItemDescricaoValidations();
        itemDescricaoValidations.allValidationsAreGood(orcamentoCreate);


        Orcamento orcamento = new Orcamento(orcamentoCreate);
        
        return orcamento;
    }
}
