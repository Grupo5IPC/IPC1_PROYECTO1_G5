package com.grupo5.Clientes;

import java.util.ArrayList;
import java.io.Serializable;

public class Gestor_cliente implements Serializable{

    ArrayList<Cliente> clientes = new ArrayList();

    public boolean insertarCliente(int id, String nombre, String direccion, int telefono, String nit) {
        Cliente user = new Cliente(id, nombre, direccion, telefono, nit);
        if (clientes.add(user)) {
            return true;
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void printClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.print(clientes.get(i).getId() + ",");
            System.out.print(clientes.get(i).getNombre() + ",");
            System.out.print(clientes.get(i).getDireccion() + ",");
            System.out.print(clientes.get(i).getTelefono() + ",");
            System.out.println(clientes.get(i).getNit());

        }
    }
public ArrayList<Cliente> getClientes(){
        return clientes;
}

public boolean buscarCliente(int id){
    boolean state = false;
    int i = 0;
    //System.out.println(clientes.size());
    while (state == false && i < clientes.size()) {
        if (clientes.get(i).getId() == id) {
            state = true;
            System.out.print("\nNombre: " + clientes.get(i).getNombre());
            System.out.print("\nDirección: " + clientes.get(i).getDireccion());
            System.out.print("\nTelefono: " + clientes.get(i).getTelefono());
            System.out.println("\nNit: " + clientes.get(i).getNit());
            System.out.println("\n");
            return true;
        } else {
            i++;
        }
    }
    return false;
}
    public boolean verificarCliente(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public Cliente getCliente(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < clientes.size()) {
            if ((clientes.get(i).getId() == id)) {
                state = true;
                return clientes.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public void printClienteSolo(int id) {
        int aux = id - 1;
        System.out.print("\nNombre: " + clientes.get(aux).getNombre());
        System.out.print("\nDirección: " + clientes.get(aux).getDireccion());
        System.out.print("\nTelefono: " + clientes.get(aux).getTelefono());
        System.out.println("\nNit: " + clientes.get(aux).getNit());
        System.out.println("\n");
    }
    
    public int eliminarCliente(int id) {
        boolean state = false;
        int i = 0;
        int modo = 0;
        if (clientes== null || clientes.isEmpty()){
            modo =1;
            return modo;
        }
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                clientes.remove(i);
                modo = 2;
                System.out.println("Cliente con id " + (i+1) + " eliminado");
                return modo;
            } else {
                i++;
            }
        }
        return modo;
    }
}
