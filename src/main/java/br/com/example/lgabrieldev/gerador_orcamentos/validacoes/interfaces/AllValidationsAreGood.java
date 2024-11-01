package br.com.example.lgabrieldev.gerador_orcamentos.validacoes.interfaces;

import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.OrcamentoCreate;

public interface AllValidationsAreGood {

      //method final para verificar se todas as validacoes passaram
      public Boolean allValidationsAreGood(OrcamentoCreate orcamentoCreate);
}
