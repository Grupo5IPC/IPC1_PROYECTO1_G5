package com.grupo5.Productos;

import com.grupo5.Usuarios.Usuario;

import java.util.ArrayList;

public class Gestor_Producto {

    ArrayList<Producto> productos = new ArrayList();

    public Ingrediente createIngrediente(int id, String nombre, int cantidad, String unidades) {
        Ingrediente ingrediente = new Ingrediente(id, nombre, cantidad, unidades);
        return ingrediente;
    }

    public boolean insertarProducto(int id, String nombre, String descripcion, double costo, double precio, Ingrediente ingredientes) {
        // usar antes de crear un producto el crear ingrediente y luego usar como parametro el ingrediente devuelto
        // esto para ahorrar el tener que crear arreglos temporales y para que la extraccion de datos se haga mas facil
        Producto producto = new Producto(id, nombre, descripcion, costo, precio, ingredientes);
        //
        if (productos.add(producto)) {
            return true;
        }
        return false;
    }
// lo hice rapido se puede usar el metodo .forEach si lo prefieren

    public void printProductos() {

        for (int i = 0; i < productos.size(); i++) {
            System.out.print(productos.get(i).getId() + ",");
            System.out.print(productos.get(i).getNombre() + ",");
            System.out.print(productos.get(i).getDescripcion() + ",");
            System.out.print(productos.get(i).getCosto() + ",");
            System.out.print(productos.get(i).getPrecio());
            System.out.println("");
            System.out.println("Ingredientes del producto " + productos.get(i).getId());
            System.out.print(productos.get(i).getIngredientes().getId() + ",");
            System.out.print(productos.get(i).getIngredientes().getNombre() + ",");
            System.out.print(productos.get(i).getIngredientes().getCantidad() + ",");
            System.out.print(productos.get(i).getIngredientes().getUnidades());
            System.out.println("");

        }
    }

    public boolean verificarProducto(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public Producto getProductos(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                return productos.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public int getId_nombre(String nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getNombre().compareTo(nombre) == 0) {
                state = true;
                return productos.get(i).getId();
            } else {
                i++;
            }
        }
        return 0;

    }
}
