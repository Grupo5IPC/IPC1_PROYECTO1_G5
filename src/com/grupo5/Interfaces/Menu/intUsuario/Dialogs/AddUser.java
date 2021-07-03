package com.grupo5.Interfaces.Menu.intUsuario.Dialogs;

import javax.swing.*;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Gestor_restaurante;
import com.grupo5.Interfaces.Menu.Colors;
import com.grupo5.Interfaces.Menu.intUsuario.CRUD_user;
import com.grupo5.Log;
import com.grupo5.Logdeacciones;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.geom.*;

public class addUser extends JDialog {
    public static Gestor_usuario usuario;
    public static Log log;
    public static Logdeacciones logdeacciones;
    public static Gestor_restaurante Nuevo;

    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;
    public JLabel title;
    public CRUD_user Crud_usuario;
    public JButton acep;
    public JPanel Parent;
    public Colors c = new Colors();
    public Color azul = new Color(42, 52, 67);
    public Color fondo = new Color(157, 207, 255);

    public addUser(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes, Gestor_restaurante nuev, boolean modal, Log log, Logdeacciones logdeacciones) {
        this.log = log;
        this.logdeacciones = logdeacciones;
        Nuevo = nuev;
        usuario = usuarios;
        producto = productos;
        factura = facturas;
        cliente = clientes;
        Parent = new JPanel();

        setUndecorated(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });



        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(550, 350);
        setBounds(0, 0, 550 , 350);
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
        title = new JLabel("Agregar Usuario");
        title.setFont(fuente.fuente(fuente.RobotoBold,1, 25));
        title.setBounds(160,30,200,60);
        title.setForeground(c.fondo);
        Parent.add(title);
        JLabel cerrar = new JLabel("x");
        cerrar.setFont(fuente.fuente(fuente.RobotoBold, 1,14));
        cerrar.setForeground(c.fondo);
        cerrar.setBounds((int)this.getSize().getWidth()-15,0,30,30);
        Parent.add(cerrar);
        JLabel nombre = new JLabel("Username");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));

        nombre.setBounds(100, 100, 100, 60);
        nombre.setForeground(c.fondo);
        Parent.add(nombre);
        JLabel password = new JLabel("Password");
        password.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));

        password.setBounds(100, 190, 100, 60);
        password.setForeground(c.fondo);
        Parent.add(password);

        JTextField username = new JTextField(" Nombre de usuario");
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

        JTextField txtpass = new JTextField(" Password");
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
                if (usuario.verificarExistencia(username.getText()) == true){
                    log.addCuerpo("USERS: El usuario "+username.getText()+" ya existe");
                    JOptionPane.showConfirmDialog(Parent,"El nombre de usuario ya existe, seleccione otro","Usuario Incorrecto", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                }else{
                    usuario.Ins_usu(username.getText(), txtpass.getText());
                   logdeacciones.addlog(usuario.getSesion()+" : Agregar usuario "+ username.getText());
                    JOptionPane.showConfirmDialog(Parent,  "El usuario se registro correctamente","Usuario Ingresado" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    cerrar2();
                }

            }
        });
        Parent.add(aceptar);
    }
    void cerrar2(){
        this.dispose();
    }
}
