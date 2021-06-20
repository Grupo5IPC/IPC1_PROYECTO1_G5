package com.grupo5.Productos;

import java.io.Serializable;
import java.util.ArrayList;

public class Gestor_Producto implements Serializable {

    ArrayList<Producto> productos = new ArrayList();

    public Ingrediente createIngrediente(String nombre, int cantidad, String unidades) {
        Ingrediente ingrediente = new Ingrediente(nombre, cantidad, unidades);
        return ingrediente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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

    public int contProductos() {
        int cont = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos != null) {
                cont++;
            }
        }
        return cont;
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

    public void printProductoSolo(int id) {
        int aux = id - 1;
        System.out.print(productos.get(aux).getId() + ",");
        System.out.print(productos.get(aux).getNombre() + ",");
        System.out.print(productos.get(aux).getDescripcion() + ",");
        System.out.print(productos.get(aux).getCosto() + ",");
        System.out.print(productos.get(aux).getPrecio());
        System.out.println("");
        System.out.println("Ingredientes del producto " + productos.get(aux).getId());
        System.out.print(productos.get(aux).getIngredientes().getNombre() + ",");
        System.out.print(productos.get(aux).getIngredientes().getCantidad() + ",");
        System.out.print(productos.get(aux).getIngredientes().getUnidades());
        System.out.println("");
    }

    public String getNombre_id(int id) {
        boolean state = false;
        String nombre = "";
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                nombre = productos.get(i).getNombre();
                return nombre;
            } else {
                i++;
            }
        }
        return nombre;
    }

    public boolean buscarProducto(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                System.out.println("");
                System.out.print(productos.get(i).getId() + ",");
                System.out.print(productos.get(i).getNombre() + ",");
                System.out.print(productos.get(i).getDescripcion() + ",");
                System.out.print(productos.get(i).getCosto() + ",");
                System.out.print(productos.get(i).getPrecio());
                System.out.println("");
                System.out.println("Ingredientes del producto " + productos.get(i).getId());
                System.out.println(productos.get(i).getIngredientes().getNombre().length());
                for (int j = 0; j < productos.get(i).getIngredientes().getNombre().length(); j++) {
                    System.out.print(productos.get(i).getIngredientes().getNombre() + ",");
                    System.out.print(productos.get(i).getIngredientes().getCantidad() + ",");
                    System.out.print(productos.get(i).getIngredientes().getUnidades());
                }

                System.out.println("");
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public void eliminarProducto(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                productos.remove(i);
                System.out.println("Producto con id " + (i + 1) + " eliminado");
            } else {
                i++;
            }
        }
    }
}
