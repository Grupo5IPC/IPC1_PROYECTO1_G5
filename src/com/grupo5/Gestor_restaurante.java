package com.grupo5;

import java.io.Serializable;
import java.util.ArrayList;

public class Gestor_restaurante implements Serializable {
   public  ArrayList<Restaurante> restaurante = new ArrayList();
    public boolean inicializar(String nombre, String direccion, int numero, String tipo){
        Restaurante res = new Restaurante(nombre,direccion,numero,tipo);
        restaurante.add(res);
        return true;
    }
    public boolean inicializar2(Restaurante res){

        restaurante.add(res);
        return true;
    }
    public boolean editar(String nombre, String direccion, int numero, String tipo){
        Restaurante res = new Restaurante(nombre,direccion,numero,tipo);
        restaurante.set(0,res);
        return true;
    }
    public ArrayList<Restaurante> getRes(){
        return restaurante;
    }
}
