package com.grupo5.Productos;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String name;
    private String description;
    private double cost;
    private double price;
    private Ingrediente ingredients;

    public Producto() {
    }
    
    public Producto(int Id, String nombre, String descripcion, double costo, double precio, Ingrediente ingredientes){
        setId(Id);
        setName(nombre);
        setDescription(descripcion);
        setCost(costo);
        setPrice(precio);
        setIngredients(ingredientes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ingrediente getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingrediente ingredients) {
        this.ingredients = ingredients;
    }
}
