package com.grupo5.Facturas;
import com.grupo5.Productos.Producto;

public class Detalle {
    private int idFactura;
    private Producto Producto;

    public Detalle(int id, Producto producto){
        setIdFactura(id);
        setProducto(producto);
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto producto) {
        this.Producto = producto;
    }
}
