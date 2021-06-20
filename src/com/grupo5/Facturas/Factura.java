package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;

import java.io.Serializable;

public class Factura implements Serializable {
    // e
    private int id;
    private Cliente client;
    private String date;
    private Detalle products;
    public Factura(int id, Cliente cliente, String fecha, Detalle detalle){
        setId(id);
        setClient(cliente);
        setDate(fecha);
        setProducts(detalle);
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public com.grupo5.Facturas.Detalle getProducts() {
        return products;
    }

    public void setProducts(com.grupo5.Facturas.Detalle products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
