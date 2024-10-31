package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.orcamento_validations;

public class ClienteValidations {
    
    // ====== cannot be null ======
    public Boolean isNotNull(String cliente){

        if(cliente == null){
            throw new RuntimeException("cliente cannot be null");
        }
        return true;
    }

    // ====== between 5 and 30 characters ======
    public Boolean isBetween5And30(String cliente){

        if(cliente.length() < 5 || cliente.length() > 30){
            throw new RuntimeException("cliente length must be between 5 and 30 characters");
        }
        return true;
    }

    // ====== all validations passed ======
    public Boolean allValidationsAreGood(String cliente){

        this.isNotNull(cliente);
        this.isBetween5And30(cliente);

        return true;
    }
}