package com.grupo5.Productos;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
    private int id;
    private String name;
    private String description;
    private double cost;
    private double price;
    private ArrayList<Ingrediente> ingredients = new ArrayList();

    public Producto() {
    }

    public Producto(int id, String name, String description, double cost, double price, ArrayList ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
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

    public ArrayList<Ingrediente> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingrediente> ingredients) {
        this.ingredients = ingredients;
    }
    
    
}
