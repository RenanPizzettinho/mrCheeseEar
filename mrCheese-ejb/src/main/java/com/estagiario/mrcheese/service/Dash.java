package com.estagiario.mrcheese.service;

public class Dash {

    private long emAberto;
    private long entregue;
    private long aprovado;
    private long total;
    private Double valorTotal;
    private long emAberto30Dias;
    private long aprovado30Dias;
    private long entregue30Dias;
    private long total30Dias;


    public long getEmAberto() {
        return emAberto;
    }

    public void setEmAberto(long emAberto) {
        this.emAberto = emAberto;
    }

    public long getEntregue() {
        return entregue;
    }

    public void setEntregue(long entregue) {
        this.entregue = entregue;
    }

    public long getAprovado() {
        return aprovado;
    }

    public void setAprovado(long aprovado) {
        this.aprovado = aprovado;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public long getEmAberto30Dias() {
        return emAberto30Dias;
    }

    public void setEmAberto30Dias(long emAberto30Dias) {
        this.emAberto30Dias = emAberto30Dias;
    }

    public long getAprovado30Dias() {
        return aprovado30Dias;
    }

    public void setAprovado30Dias(long aprovado30Dias) {
        this.aprovado30Dias = aprovado30Dias;
    }

    public long getEntregue30Dias() {
        return entregue30Dias;
    }

    public void setEntregue30Dias(long entregue30Dias) {
        this.entregue30Dias = entregue30Dias;
    }

    public long getTotal30Dias() {
        return total30Dias;
    }

    public void setTotal30Dias(long total30Dias) {
        this.total30Dias = total30Dias;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
