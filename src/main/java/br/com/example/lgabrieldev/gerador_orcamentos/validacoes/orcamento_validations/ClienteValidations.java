package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldCannotBeNullException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class ClienteValidations implements AllValidationsAreGood{
    
    // ====== cannot be null ======
    public Boolean isNotNull(String cliente){

        if(cliente == null){
            throw new FieldCannotBeNullException(" 'cliente' cannot be null");
        }
        return true;
    }

    // ====== between 5 and 30 characters ======
    public Boolean isBetween5And30(String cliente){

        if(cliente.length() < 5 || cliente.length() > 30){
            throw new FieldLengthIsWrongException(" 'cliente' length must be between 5 and 30 characters");
        }
        return true;
    }

    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate){
        String cliente = orcamentoCreate.getCliente();

        this.isNotNull(cliente);
        this.isBetween5And30(cliente);

        return true;
    }
}