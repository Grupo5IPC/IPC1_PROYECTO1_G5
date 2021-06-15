package com.grupo5;
import com.grupo5.Usuarios.*;
import com.grupo5.Productos.*;
import com.grupo5.Clientes.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        // Aqui ira el menu, la carga de los jsons iniciales, etc. ver el grupo xd
        Gestor_usuario user = new Gestor_usuario();
        Gestor_cliente cliente = new Gestor_cliente();
        Gestor_Producto producto = new Gestor_Producto();
        // en la instancia de la clase opciones se pide un entero que es el modo
        // el modo es la seleccion entre json o bin
        Opciones op = new Opciones(cliente,user,producto, 1);
    }
}
