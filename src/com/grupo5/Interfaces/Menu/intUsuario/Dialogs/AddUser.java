package com.grupo5.Interfaces.Menu.intUsuario.Dialogs;

import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.Colors;
import com.grupo5.Interfaces.Menu.intUsuario.CRUD_user;
import com.grupo5.Usuarios.Gestor_usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddUser extends JPanel {
    public static Gestor_usuario usuario;

    public JLabel title;
    public CRUD_user Crud_usuario;
    public JButton acep;
    public JPanel Parent;
    public Colors c = new Colors();
    public Color azul = new Color(42, 52, 67);

    public AddUser(Gestor_usuario user, JPanel parent) {

        Parent = parent;
        usuario = user;
        setLayout(null);
        //this.setSize( (int) this.getParent().getSize().getWidth(), (int) this.getParent().getSize().getHeight());
        setBounds(0, 0, 898, 300);

        labels();
        this.setBackground(azul);


        System.out.println(parent.getName());

        this.setVisible(true);

        //setBackground(Color.cyan);


    }

    void labels() {
        Fuentes fuente = new Fuentes();

        JLabel nombre = new JLabel("Username");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        ;
        nombre.setBounds(100, 100, 100, 60);
        nombre.setForeground(c.textoSecundario);
        add(nombre);
        JLabel password = new JLabel("Password");
        password.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        ;
        password.setBounds(100, 190, 100, 60);
        password.setForeground(c.textoSecundario);
        add(password);

        JTextField username = new JTextField(" Nombre de usuario");
        username.setBackground(c.azul);
        username.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setBounds(210, 110, 200, 40);
        username.setForeground(c.textoSecundario);
        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                username.setText("");
            }
        });
        add(username);
        JSeparator separador = new JSeparator();
        separador.setBackground(c.azul);
        separador.setOrientation(0);
        separador.setForeground(c.textoSecundario);
        separador.setBounds(210, 155, 200, 5);
        add(separador);

        JTextField txtpass = new JTextField(" Password");
        txtpass.setBackground(c.azul);
        txtpass.setForeground(c.textoSecundario);
        txtpass.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        txtpass.setBorder(BorderFactory.createEmptyBorder());
        txtpass.setBounds(210, 200, 200, 40);
        txtpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtpass.setText("");
            }
        });
        add(txtpass);
        JSeparator separador2 = new JSeparator();
        separador2.setBackground(c.azul);
        separador2.setOrientation(0);
        separador2.setForeground(c.textoSecundario);
        separador2.setBounds(210, 245, 200, 5);
        add(separador2);

        JButton aceptar = new JButton("Agregar");
        aceptar.setBackground(azul);
        aceptar.setBounds(username.getX() + 30, 270, 140, 45);
        aceptar.setFont(fuente.fuente(fuente.RobotoBold, 0, 16));
        aceptar.setForeground(c.textoSecundario);
        aceptar.setBorder(BorderFactory.createLineBorder(c.textoSecundario));
        aceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aceptar.setForeground(c.texto);
                aceptar.setBackground(c.fondo);
                aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                aceptar.setBackground(azul);
                aceptar.setForeground(c.textoSecundario);
                aceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                aceptar.setBackground(azul);
                aceptar.setForeground(c.textoSecundario);
                aceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                cerrar();
            }
        });
        add(aceptar);

    }

    void cerrar() {
        Crud_usuario = new CRUD_user(usuario);
        Crud_usuario.setVisible(true);
        Crud_usuario.setForeground(c.textoSecundario);
        Crud_usuario.setBounds(2, 0, 898, 550);
        System.out.println(Parent.getName());
        System.out.println(Parent.getParent().getName());
        Parent.remove(this);
        Parent.revalidate();
        Parent.repaint();
    }

/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AddUser();
            }
        });
    }
    */

}


