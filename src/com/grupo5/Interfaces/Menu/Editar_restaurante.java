package com.grupo5.Interfaces.Menu;

import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Gestor_restaurante;
import com.grupo5.Interfaces.Menu.intUsuario.CRUD_user;
import com.grupo5.Log;
import com.grupo5.Logdeacciones;
import com.grupo5.Usuarios.Gestor_usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Editar_restaurante extends JDialog {
    public static Gestor_restaurante restaurante;
    public static Gestor_usuario usuario;
    public static Log log;
    public static Logdeacciones logdeacciones;

    public JLabel title;
    public CRUD_user Crud_usuario;
    public JButton acep;
    public JPanel Parent;
    public Colors c = new Colors();
    public Color azul = new Color(42, 52, 67);
    public Color fondo = new Color(157, 207, 255);

    public Editar_restaurante(Gestor_usuario usuario,Gestor_restaurante res, boolean modal, Log log, Logdeacciones logdeacciones) {
        this.usuario = usuario;
        this.log = log;
        this.logdeacciones = logdeacciones;
        Parent = new JPanel();
        restaurante = res;
        setUndecorated(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });



        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(550, 430);
        setBounds(0, 0, 550 , 430);
        setAlwaysOnTop(true);

        //this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setModal(modal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(fondo);
        setLayout(null);
        setLocationRelativeTo(null);
        labels();
        Parent.setBounds(0,0, this.getWidth(),this.getHeight() );
        Parent.setLayout(null);
        Parent.setBackground(fondo);
        add(Parent);


    }

    void labels() {
        Fuentes fuente = new Fuentes();
        title = new JLabel("Editar datos del restaurante");
        title.setFont(fuente.fuente(fuente.RobotoBold,1, 22));
        title.setBounds(100,30,380,60);
        title.setForeground(c.fondo);
        Parent.add(title);
        JLabel cerrar = new JLabel("x");
        cerrar.setFont(fuente.fuente(fuente.RobotoBold, 1,14));
        cerrar.setForeground(c.fondo);
        cerrar.setBounds((int)this.getSize().getWidth()-15,0,30,30);
        Parent.add(cerrar);
        JLabel nombre = new JLabel("Nombre:");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));

        nombre.setBounds(100, 100, 100, 60);
        nombre.setForeground(c.fondo);
        Parent.add(nombre);
        JLabel password = new JLabel("Direccion:");
        password.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));

        password.setBounds(100, 190, 100, 60);
        password.setForeground(c.fondo);
        Parent.add(password);

        JLabel telefono = new JLabel("Telefono:");
        telefono.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));

        telefono.setBounds(100, 280, 100, 60);
        telefono.setForeground(c.fondo);
        Parent.add(telefono);

        JTextField username = new JTextField("Nombre del restaurante");
        username.setBackground(fondo);
        username.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setBounds(210, 110, 200, 40);
        username.setForeground(c.fondo);
        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                username.setText("");
            }
        });
        Parent.add(username);
        JSeparator separador = new JSeparator();
        separador.setBackground(c.fondo);
        separador.setOrientation(0);
        separador.setForeground(c.fondo);
        separador.setBounds(210, 155, 200, 5);
        Parent.add(separador);

        JTextField txtpass = new JTextField(" Direccion:");
        txtpass.setBackground(fondo);
        txtpass.setForeground(c.fondo);
        txtpass.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        txtpass.setBorder(BorderFactory.createEmptyBorder());
        txtpass.setBounds(210, 200, 200, 40);
        txtpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtpass.setText("");
            }
        });
        Parent.add(txtpass);
        JSeparator separador2 = new JSeparator();
        separador2.setBackground(c.azul);
        separador2.setOrientation(0);
        separador2.setForeground(c.fondo);
        separador2.setBounds(210, 245, 200, 5);
        Parent.add(separador2);


        JTextField txttele = new JTextField(" Telefono:");
        txttele.setBackground(fondo);
        txttele.setForeground(c.fondo);
        txttele.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        txttele.setBorder(BorderFactory.createEmptyBorder());
        txttele.setBounds(210, 290, 200, 40);
        txttele.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txttele.setText("");
            }
        });
        Parent.add(txttele);
        JSeparator separador3 = new JSeparator();
        separador3.setBackground(c.azul);
        separador3.setOrientation(0);
        separador3.setForeground(c.fondo);
        separador3.setBounds(210, 335, 200, 5);
        Parent.add(separador3);



        JButton aceptar = new JButton("Agregar");
        aceptar.setBackground(azul);
        aceptar.setBounds(username.getX() + 30, 360, 140, 45);
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
                if (verifyNum(txttele.getText()) == false){
                    JOptionPane.showConfirmDialog(Parent,"Alguno de los campos es incorrecto","Numero Incorrecto", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                }else{
                    restaurante.editar(username.getText(),txtpass.getText(),Integer.parseInt(txttele.getText()), "json");
                    logdeacciones.addlog(usuario.getSesion()+": Edito restaurante");

                    JOptionPane.showConfirmDialog(Parent,  "Los datos del restaurante fueron actualizados","Actualizacion" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    cerrar2();
                }

            }
        });
        Parent.add(aceptar);
    }

    void cerrar2(){
        this.dispose();
    }
    boolean verifyNum(String txt){
        try{
            int res = Integer.parseInt(txt);
            log.addCuerpo("DASHBOARD: El numero no es valido");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


