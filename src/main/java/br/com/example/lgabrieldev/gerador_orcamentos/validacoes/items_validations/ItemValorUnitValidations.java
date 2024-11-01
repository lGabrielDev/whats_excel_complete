package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.models.item.ItemCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGood;


@Component
public class ItemValorUnitValidations implements AllValidationsAreGood{
    
    // ========= cannot be null =========
    public Boolean isNotNull(ItemCreate itemCreate, Integer itemId){

        if(itemCreate.getValorUnit() == null){
            throw new RuntimeException(String.format(" 'valorUnit' cannot be null --> item #%d está errado ", itemId));
        }
        return true;
    }

    // ====== must be a positive number =====
    public Boolean isAPositiveNumber(ItemCreate itemCreate, Integer itemId){

        if(itemCreate.getValorUnit() <= 0){
            throw new RuntimeException(String.format(" 'valorUnit' must be a bigger than 0 --> item #%d está errado", itemId));
        }
        return true;
    }


    // ====== all validations are good =====
    @Override
    public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate) {
        List<ItemCreate> items = orcamentoCreate.getItems();
        
        for(Integer i = 0; i < items.size(); i++){
            this.isNotNull(items.get(i), (i+1));
            this.isAPositiveNumber(items.get(i), (i+1));
        }
        return true;
    }

}
