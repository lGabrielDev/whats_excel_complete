package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldCannotBeNullException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.ItemsLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.models.item.ItemCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;

@Component
public class ItemsLengthValidations implements AllValidationsAreGood{


    // ============== cannot be null ==============
    public Boolean itemListIsNotNull(List<ItemCreate> items){

        if(items == null){
            throw new FieldCannotBeNullException(" item list cannot be null. Add some items (between 1-6)");
        }

        return true;
    }


    // ============== orcamento must have between 1 and 6 items ==============
    public Boolean itemListHasBetween1And6Items(List<ItemCreate> items){

        // if(items == null){
        //     throw new ItemsLengthIsWrongException("item list cannot be null. Add some items (between 1-6)");
        // }

        if(items.size() < 1 || items.size() > 6){
            throw new ItemsLengthIsWrongException(" item list size must be between 1 and 6");
        }

        return true;
    }
    
    
    // ======== all validations are good ========
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        this.itemListIsNotNull(orcamentoCreate.getItems());
        this.itemListHasBetween1And6Items(orcamentoCreate.getItems());

        return true;
    }
    
}
