package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;

public class Factura {
    // e
    private int id;
    private Cliente Cliente;
    private String Fecha;
    private Detalle Detalle;
    public Factura(int id, Cliente cliente, String fecha, Detalle detalle){
        setId(id);
        setCliente(cliente);
        setFecha(fecha);
        setDetalle(detalle);
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        this.Cliente = cliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }

    public com.grupo5.Facturas.Detalle getDetalle() {
        return Detalle;
    }

    public void setDetalle(com.grupo5.Facturas.Detalle detalle) {
        Detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
