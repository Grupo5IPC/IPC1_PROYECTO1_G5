package com.grupo5.Usuarios;

import java.util.ArrayList;

public class Gestor_usuario {

    ArrayList<Usuario> usuarios = new ArrayList();

    public boolean Ins_usu(String nombre, String pass) {
        Usuario user = new Usuario(nombre, pass);
        if (usuarios.add(user)) {
            return true;
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void print_usu() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.print(usuarios.get(i).getUsuario() + ",");
            System.out.println(usuarios.get(i).getPassword());

        }
    }

    public boolean verificar(String nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < usuarios.size()) {
            if (usuarios.get(i).getUsuario().equals(nombre)) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public void printUsuarioSolo(String nombre) {
        int i = 0;
        while (i < usuarios.size()) {
            if (usuarios.get(i).getUsuario().equals(nombre)) {
                System.out.print("\nUsuario: " + usuarios.get(i).getUsuario());
                System.out.print("\nPassword: " + usuarios.get(i).getPassword());
                System.out.println("\n");
            }else{
                i++;
            }
        }
    }
            
    public void eliminarUsuario(String nombre) {
        int i = 0;
        while (i < usuarios.size()) {
            if (usuarios.get(i).getUsuario().equals(nombre)) {
                usuarios.remove(i);
                System.out.println("Usuario con username " + nombre + " eliminado");
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
