package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldNumberMustBeBigger;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class PrazoEntregaValidations implements AllValidationsAreGood{
    
    // ====== must be bigger than 0 ======
    public Boolean prazoEntregaIsCorrect(Integer prazoEntrega){

        if(prazoEntrega < 1){
            throw new FieldNumberMustBeBigger(" 'prazoEntrega' must be greater than 0");
        }
        return true;
    }

    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        if(orcamentoCreate.getPrazoEntrega() != null){
            this.prazoEntregaIsCorrect(orcamentoCreate.getPrazoEntrega());
        }
        return true;
    }
}