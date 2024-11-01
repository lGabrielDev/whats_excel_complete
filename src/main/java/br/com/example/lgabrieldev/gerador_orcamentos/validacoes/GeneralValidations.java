package br.com.example.lgabrieldev.gerador_orcamentos.validacoes;

import org.springframework.stereotype.Component;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemAcabamentoValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemDescricaoValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemMedidasValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemQuantityValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.items_validations.ItemValorUnitValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ClienteValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.DescricaoValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ItemsLengthValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ObservacoesValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.ParcelasValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.PrazoEntregaValidations;
import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations.SinalValidations;

@Component
public class GeneralValidations {

    //attributes
    private ClienteValidations clienteValidations;
    private DescricaoValidations descricaoValidations;
    private ObservacoesValidations observacoesValidations;
    private ItemsLengthValidations itemsLengthValidations;
    private SinalValidations sinalValidations;
    private ParcelasValidations parcelasValidations;
    private PrazoEntregaValidations prazoEntregaValidations;
    
    private ItemDescricaoValidations itemDescricaoValidations;
    private ItemAcabamentoValidations itemAcabamentoValidations;
    private ItemMedidasValidations itemMedidasValidations;
    private ItemValorUnitValidations itemValorUnitValidations;
    private ItemQuantityValidations itemQuantityValidations;

    //constructors -> Injecao de dependencia
    public GeneralValidations(ClienteValidations clienteValidations, DescricaoValidations descricaoValidations,
            ObservacoesValidations observacoesValidations, ItemsLengthValidations itemsLengthValidations,
            ItemDescricaoValidations itemDescricaoValidations, ItemAcabamentoValidations itemAcabamentoValidations,
            ItemMedidasValidations itemMedidasValidations, ItemValorUnitValidations itemValorUnitValidations,
            ItemQuantityValidations itemQuantityValidations, SinalValidations sinalValidations, ParcelasValidations parcelasValidations,
            PrazoEntregaValidations prazoEntregaValidations) {
        this.clienteValidations = clienteValidations;
        this.descricaoValidations = descricaoValidations;
        this.observacoesValidations = observacoesValidations;
        this.itemsLengthValidations = itemsLengthValidations;
        this.itemDescricaoValidations = itemDescricaoValidations;
        this.itemAcabamentoValidations = itemAcabamentoValidations;
        this.itemMedidasValidations = itemMedidasValidations;
        this.itemValorUnitValidations = itemValorUnitValidations;
        this.itemQuantityValidations = itemQuantityValidations;
        this.sinalValidations = sinalValidations;
        this.parcelasValidations = parcelasValidations;
        this.prazoEntregaValidations = prazoEntregaValidations;
    }
    
    public Boolean validateAllAttributes(OrcamentoCreate orcamentoCreate){
        this.clienteValidations.allValidationsAreGood(orcamentoCreate);
        this.descricaoValidations.allValidationsAreGood(orcamentoCreate);
        this.observacoesValidations.allValidationsAreGood(orcamentoCreate);
        this.itemsLengthValidations.allValidationsAreGood(orcamentoCreate);
        this.sinalValidations.allValidationsAreGood(orcamentoCreate);
        this.parcelasValidations.allValidationsAreGood(orcamentoCreate);
        this.prazoEntregaValidations.allValidationsAreGood(orcamentoCreate);
        
        //items validations
        this.itemDescricaoValidations.allValidationsAreGood(orcamentoCreate);
        this.itemAcabamentoValidations.allValidationsAreGood(orcamentoCreate);
        this.itemMedidasValidations.allValidationsAreGood(orcamentoCreate);
        this.itemValorUnitValidations.allValidationsAreGood(orcamentoCreate);
        this.itemQuantityValidations.allValidationsAreGood(orcamentoCreate);
        return true;
    }
}
