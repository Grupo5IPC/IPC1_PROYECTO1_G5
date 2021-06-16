package com.grupo5.Productos;

public class Producto {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private double costo;
    private double precio;
    private Ingrediente Ingredientes;

    public Producto(int id, String nombre, String descripcion, double costo, double precio, Ingrediente ingredientes){
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCosto(costo);
        setPrecio(precio);
        setIngredientes(ingredientes);
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Ingrediente getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(Ingrediente ingredientes) {
        Ingredientes = ingredientes;
    }
}
