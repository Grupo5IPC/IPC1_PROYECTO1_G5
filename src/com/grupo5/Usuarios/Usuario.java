package com.grupo5.Usuarios;

public class Usuario {
    private String Usuario;
    private String Password;

    public Usuario(String usuario, String password){
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
}
