package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGoodForString;

public class DescricaoValidations implements AllValidationsAreGoodForString {
    
     // ====== cannot be null ======
     public Boolean isNotNull(String descricao){

        if(descricao == null){
            throw new RuntimeException("descricao cannot be null");
        }
        return true;
    }

    // ====== between 5 and 45 characters ======
    public Boolean isBetween5And45(String cliente){

        if(cliente.length() < 5 || cliente.length() > 45){
            throw new RuntimeException("descricao length must be between 5 and 45 characters");
        }
        return true;
    }


    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(String descricao) {
        this.isNotNull(descricao);
        this.isBetween5And45(descricao);

        return true;
    }
 
}
