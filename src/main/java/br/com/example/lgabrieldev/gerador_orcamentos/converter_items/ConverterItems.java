package br.com.example.lgabrieldev.gerador_orcamentos.converter_items;

import java.util.ArrayList;
import java.util.List;

import br.com.example.lgabrieldev.gerador_orcamentos.models.item.Item;
import br.com.example.lgabrieldev.gerador_orcamentos.models.item.ItemCreate;

public class ConverterItems {
    
    public List<Item> converterItems(List<ItemCreate> itemsCreate){

        List<Item> listaConvertida = new ArrayList<>();

        for(int i = 0; i<itemsCreate.size(); i++){
            Item item = new Item(
                itemsCreate.get(i).getDescricao(),
                itemsCreate.get(i).getAcabamento(),
                itemsCreate.get(i).getMedidas(),
                itemsCreate.get(i).getValorUnit(),
                itemsCreate.get(i).getQuantity()
            );
            item.setId(i+1l);

            listaConvertida.add(item);
        }

        return listaConvertida;
    }
}
