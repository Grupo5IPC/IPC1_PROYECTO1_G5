package com.grupo5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.grupo5.Clientes.Cliente;
import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Factura;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Productos.Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.grupo5.Usuarios.Usuario;
import java.lang.reflect.*;

import java.io.FileWriter;
import java.util.ArrayList;

public class Serializacion {
    public Gestor_restaurante restaurante;
    public Gestor_usuario usuario;
    public Gestor_Producto producto;
    public Gestor_cliente cliente;
    public Gestor_Factura factura;
    public void serializar(Gestor_restaurante restaurante, Gestor_usuario usuario, Gestor_Producto producto ,Gestor_cliente cliente,Gestor_Factura factura){
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.cliente = cliente;
        this.producto = producto;
        this.factura = factura;
        try {
            Type listType = new TypeToken<ArrayList<Restaurante>>() {}.getType();
            Gson gson7 = new GsonBuilder().setPrettyPrinting().create();
            ArrayList<Restaurante> array7 = restaurante.getRes();
            String g7 = gson7.toJson(array7.toArray());

            System.out.println(g7);

            FileWriter writer7 = new FileWriter("config.json", false);
            writer7.write(g7);
            writer7.close();

            // Serializar usuarios
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ArrayList<Usuario> array = usuario.getArray();
            String g = gson.toJson(array);

            FileWriter writer1 = new FileWriter("users.json", false);
            writer1.write(g);
            writer1.close();
            //System.out.println(g);

            // Serializar clientes
            ArrayList<Cliente> clientes = cliente.getClientes();
            String g2 = gson.toJson(clientes);
            FileWriter writer2 = new FileWriter("clients.json", false);
            writer2.write(g2);
            writer2.close();
            //System.out.println(g2);

            // Serializar productos
            ArrayList<Producto> array2 = producto.getProductos();
            String g3 = gson.toJson(array2);
            FileWriter writer3 = new FileWriter("products.json", false);
            writer3.write(g3);
            writer3.close();
            //System.out.println(g3);

            // Serializar facturas
            ArrayList<Factura> array4 = factura.getFacturas();
            String g4 = gson.toJson(array4.toArray());
            FileWriter writer4 = new FileWriter("invoices.json", false);
            writer4.write(g4);
            writer4.close();
            //System.out.println(g4);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Serializacion");
        }
    }
}
