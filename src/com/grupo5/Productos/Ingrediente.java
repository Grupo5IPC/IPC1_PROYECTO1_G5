package com.grupo5.Productos;

public class Ingrediente {
    private int Id;
    private String Nombre;
    private int Cantidad;
    private int Unidades;

    public Ingrediente(int id, String nombre,int cantidad, int unidades ){
        setId(id);
        setNombre(nombre);
        setCantidad(cantidad);
        setUnidades(unidades);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int unidades) {
        Unidades = unidades;
    }
}
