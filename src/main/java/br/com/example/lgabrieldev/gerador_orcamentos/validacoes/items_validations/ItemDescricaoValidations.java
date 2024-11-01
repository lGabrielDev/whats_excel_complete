package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldCannotBeNullException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.models.item.ItemCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;


@Component
public class ItemDescricaoValidations implements AllValidationsAreGood {

     // ====== cannot be null ======
     public Boolean isNotNull(ItemCreate itemCreate, Integer itemId){

        if(itemCreate.getDescricao() == null){
            throw new FieldCannotBeNullException(String.format(" 'descricao' cannot be null --> item #%d está errado ", itemId));
        }
        return true;
    }

    // ====== between 5 and 80 characters ======
    public Boolean isBetween5And45(ItemCreate itemCreate, Integer itemId){

        if(itemCreate.getDescricao().length() < 5 || itemCreate.getDescricao().length() > 80){
            throw new FieldLengthIsWrongException(String.format(" 'descricao' length must be between 5 and 80 characters --> item #%d está errado", itemId));
        }
        return true;
    }

 
    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        List<ItemCreate> items = orcamentoCreate.getItems();
        
        for(Integer i = 0; i < items.size(); i++){
            this.isNotNull(items.get(i), (i+1));
            this.isBetween5And45(items.get(i), (i+1));
        }
        return true;
    }

}
