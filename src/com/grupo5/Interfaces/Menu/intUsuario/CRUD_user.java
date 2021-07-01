package com.grupo5.Interfaces.Menu.intUsuario;

import com.grupo5.Usuarios.Gestor_usuario;

import javax.swing.*;
import java.awt.*;


public class CRUD_user extends JPanel {
    public static Gestor_usuario usuario;

    public CRUD_user(Gestor_usuario user){
        usuario = user;
        setSize(898,620);
        setBounds(0,0,getWidth(), getHeight());
        setBackground(Color.BLUE);

        usuario.print_usu();
        
    }

}
