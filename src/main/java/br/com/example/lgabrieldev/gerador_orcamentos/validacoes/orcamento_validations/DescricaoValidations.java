package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldCannotBeNullException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class DescricaoValidations implements AllValidationsAreGood {
    
     // ====== cannot be null ======
     public Boolean isNotNull(String descricao){

        if(descricao == null){
            throw new FieldCannotBeNullException(" 'descricao' cannot be null");
        }
        return true;
    }

    // ====== between 5 and 45 characters ======
    public Boolean isBetween5And45(String cliente){

        if(cliente.length() < 5 || cliente.length() > 45){
            throw new FieldLengthIsWrongException(" 'descricao' length must be between 5 and 45 characters");
        }
        return true;
    }


    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        String descricao = orcamentoCreate.getDescricao();

        this.isNotNull(descricao);
        this.isBetween5And45(descricao);

        return true;
    }
 
}
