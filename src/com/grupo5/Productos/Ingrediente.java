package com.grupo5.Productos;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private String Nombre;
    private int Cantidad;
    private String Unidades;

    public Ingrediente(){
        
    }
    
    public Ingrediente(String nombre,int cantidad, String unidades ){
        setNombre(nombre);
        setCantidad(cantidad);
        setUnidades(unidades);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getUnidades() {
        return Unidades;
    }

    public void setUnidades(String Unidades) {
        this.Unidades = Unidades;
    }

}
