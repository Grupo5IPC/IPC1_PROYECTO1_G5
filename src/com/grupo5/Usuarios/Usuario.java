package com.grupo5.Usuarios;

public class Usuario {
    private int Id;
    private String Usuario;
    private String Password;

    public Usuario(int Id, String usuario, String password){
        setId(Id);
        setUsuario(usuario);
        setPassword(password);
    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
