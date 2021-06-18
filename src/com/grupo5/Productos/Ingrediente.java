package com.grupo5.Productos;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private int Id;
    private String Nombre;
    private int Cantidad;
    private String Unidades;

    public Ingrediente(){
        
    }
    
    public Ingrediente(int id, String nombre,int cantidad, String unidades ){
        setId(id);
        setNombre(nombre);
        setCantidad(cantidad);
        setUnidades(unidades);
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
