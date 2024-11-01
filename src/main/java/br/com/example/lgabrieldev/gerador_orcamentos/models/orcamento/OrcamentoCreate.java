package br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento;

import java.util.ArrayList;
import java.util.List;
import br.com.example.lgabrieldev.gerador_orcamentos.models.item.ItemCreate;

public class OrcamentoCreate {
    
    //attributes
    private String cliente;
    private String descricao;
    private String observacoes;
    private Integer prazoEntrega;
    private Double sinal;
    private Integer parcelas;
    private List<ItemCreate> items;

    //constructors
    public OrcamentoCreate(){
        this.items = new ArrayList<>();
    }

    //getters and setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(Integer prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public List<ItemCreate> getItems() {
        return items;
    }

    public void setItems(List<ItemCreate> items) {
        this.items = items;
    }


    public Double getSinal() {
        return sinal;
    }


    public void setSinal(Double sinal) {
        this.sinal = sinal;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
