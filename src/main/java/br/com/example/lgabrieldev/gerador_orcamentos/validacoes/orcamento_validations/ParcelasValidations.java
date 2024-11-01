package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldNumberMustBeBigger;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class ParcelasValidations implements AllValidationsAreGood{
    
    // ====== must be bigger than 1 ======
    public Boolean parcelasIsGreaterThan1(Integer parcelas){

        if(parcelas <= 1){
            throw new FieldNumberMustBeBigger(" 'parcelas' must be greater than 1x");
        }
        return true;
    }

    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {

        if(orcamentoCreate.getParcelas() != null){
            this.parcelasIsGreaterThan1(orcamentoCreate.getParcelas());
        }
        return true;
    }
}