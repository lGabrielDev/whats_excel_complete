package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

import br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces.AllValidationsAreGoodForString;

public class ObservacoesValidations implements AllValidationsAreGoodForString{
    
    // ====== 200 characters max ======
    public Boolean isBetween5And45(String obervacoes){
        if(obervacoes != null){
            if(obervacoes.length() > 200){
                throw new RuntimeException("obervacoes length cannot be bigger than 200 characters");
            }
        }
        return true;
    }

    // ====== all validations passed ======
    @Override
    public Boolean allValidationsAreGood(String campo) {
        
        this.isBetween5And45(campo);

        return true;
    }
}
