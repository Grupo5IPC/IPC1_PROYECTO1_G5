package com.grupo5.Usuarios;

import java.util.ArrayList;

public class Gestor_usuario {
    ArrayList<Usuario> usuarios = new ArrayList();

    public boolean Ins_usu(int Id, String nombre, String pass) {
        Usuario user = new Usuario(Id, nombre, pass);
        if (usuarios.add(user)) {
            return true;
        }
        return false;
    }
    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void print_usu() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.print(usuarios.get(i).getId() + ",");
            System.out.print(usuarios.get(i).getUsuario() + ",");
            System.out.println(usuarios.get(i).getPassword());

        }
    }

    public boolean verificar(int id) {
        boolean state = false;
        int i = 0;
        while(state == false  && i< usuarios.size()){
            if (usuarios.get(i).getId() == id){
                state = true;
                return true;
            }else{
                i++;
            }
        }
        return false;
    }
    
    public void printUsuarioSolo(int id) {
        int aux = id - 1;
        System.out.print("\nUsuario: " + usuarios.get(aux).getUsuario());
        System.out.print("\nPassword: " + usuarios.get(aux).getPassword());
        System.out.println("\n");
    }
    
    public void eliminarUsuario(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < usuarios.size()) {
            if (usuarios.get(i).getId() == id) {
                state = true;
                usuarios.remove(i);
                System.out.println("Usuario con id " + (i+1) + " eliminado");
            } else {
                i++;
            }
        }
    }
    
/*
    public boolean verificar_exis(String usu) {
        for (int i = 0; i < 10; i++) {
            if (usuarios[i] != null) {
                if ((usuarios[i].getUsuario().equals(usu))) {
                    return true;
                }
            }
        }
        return false;
    }



    public String buscar_nombre_USU(String nom) {
        String nombre = "";
        for (int i = 0; i < 10; i++) {

            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(nom)) {
                    nombre = usuarios[i].getUsuario();
                    break;
                }
            }
        }
        return nombre;
    }



 */

}
