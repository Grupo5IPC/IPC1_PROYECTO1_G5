package com.grupo5.Clientes;

public class Cliente {
    private int Id;
    private String Nombre;
    private String Direccion;
    private int Telefono;
    private String Nit;
    public Cliente(int id, String nombre, String direccion, int telefono, String nit){
        setId(id);
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setNit(nit);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
    }
}
