package br.com.example.lgabrieldev.gerador_orcamentos.models.item;

public class ItemCreate {
   
    //attributes
    private String descricao;
    private String acabamento;
    private String medidas;
    private Double valorUnit;
    private Integer quantity;

    //constructors
    public ItemCreate(){}

    //getters and setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }   
}
