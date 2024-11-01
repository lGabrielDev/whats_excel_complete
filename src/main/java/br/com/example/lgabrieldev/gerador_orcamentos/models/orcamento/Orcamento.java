package br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import br.com.example.lgabrieldev.gerador_orcamentos.converter_items.ConverterItems;
import br.com.example.lgabrieldev.gerador_orcamentos.models.item.Item;

public class Orcamento {
    
    //attributes
    private Long id;
    private LocalDate dataEnvio;
    private String cliente;
    private String descricao;
    private String observacoes;
    private List<Item> items;
    private Integer prazoEntrega;
    private Double sinal;

    //constructors
    public Orcamento (){
        this.dataEnvio = LocalDate.now();
        this.sinal = 0d;
        this.prazoEntrega = 0;
    }

    public Orcamento(Long id, String cliente, String descricao, String observacoes, Integer prazoEntrega) {
        this.id = id;
        this.dataEnvio = LocalDate.now();
        this.cliente = cliente;
        this.descricao = descricao;
        this.observacoes = observacoes;
        this.prazoEntrega = prazoEntrega;
        this.sinal = 0d;
        this.items = new ArrayList<>();
    }

    public Orcamento(OrcamentoCreate orcamentoCreate) {
        this.items = new ArrayList<>();
        this.dataEnvio = LocalDate.now();
        this.cliente = orcamentoCreate.getCliente();
        this.descricao = orcamentoCreate.getDescricao();
        this.observacoes = orcamentoCreate.getObservacoes();
        this.prazoEntrega = orcamentoCreate.getPrazoEntrega();
        this.sinal = orcamentoCreate.getSinal();

        ConverterItems converterItems = new ConverterItems();
        this.items = converterItems.converterItems(orcamentoCreate.getItems());
    }


    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDataEnvio() {
        DateTimeFormatter formatacaoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatacaoPadrao.format(this.dataEnvio);
    }
    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
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
        return this.prazoEntrega;
    }
    public void setPrazoEntrega(Integer prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getSinal() {
        return sinal;
    }

    public void setSinal(Double sinal) {
        this.sinal = sinal;
    }

    public Double getValorTotal(){
        return this.items.stream().mapToDouble((item) -> item.getValorTotal()).sum();
    }

    
}
