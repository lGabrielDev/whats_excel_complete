package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class ObservacoesValidations implements AllValidationsAreGood{
    
    // ====== 200 characters max ======
    public Boolean isBetween5And200(String obervacoes){
        if(obervacoes != null){
            if(obervacoes.length() < 5 ||obervacoes.length() > 200){
                throw new FieldLengthIsWrongException(" 'obervacoes' length must be between be 5 and 200 characters");
            }
        }
        return true;
    }

    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        String observacoes = orcamentoCreate.getObservacoes();
        this.isBetween5And200(observacoes);

        return true;
    }
}
