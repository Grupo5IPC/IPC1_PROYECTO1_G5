package com.grupo5.Interfaces.Menu.intCliente.Dialogs;

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

public class AddClient extends JDialog {
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

    public AddClient(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes, Gestor_restaurante nuev, boolean modal, Log log, Logdeacciones logdeacciones) {
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
        setBounds(0, 0, 550, 350);
        setAlwaysOnTop(true);

        //this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setModal(modal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(fondo);
        setLayout(null);
        setLocationRelativeTo(null);
        labels();
        Parent.setBounds(0, 0, this.getWidth(), this.getHeight());
        Parent.setLayout(null);
        Parent.setBackground(fondo);
        add(Parent);

    }

    void labels() {
        Fuentes fuente = new Fuentes();
        title = new JLabel("Agregar Cliente");

        JLabel cerrar = new JLabel("x");
        cerrar.setFont(fuente.fuente(fuente.RobotoBold, 0, 12));
        cerrar.setForeground(c.textoSecundario);
        cerrar.setBounds((int) this.getSize().getWidth() - 20, 20, 30, 30);
        Parent.add(cerrar);

        JLabel Id = new JLabel("Id");
        Id.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Id.setBounds(100, 100, 100, 60);
        Id.setForeground(c.textoSecundario);
        Parent.add(Id);

        JLabel nombre = new JLabel("Nombre");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        nombre.setBounds(100, 190, 100, 60);
        nombre.setForeground(c.textoSecundario);
        Parent.add(nombre);

        JLabel Direccion = new JLabel("Dirección");
        Direccion.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Direccion.setBounds(100, 280, 100, 60);
        Direccion.setForeground(c.textoSecundario);
        Parent.add(Direccion);

        JLabel Telefono = new JLabel("Telefono");
        Telefono.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Telefono.setBounds(100, 370, 100, 60);
        Telefono.setForeground(c.textoSecundario);
        Parent.add(Telefono);

        JLabel Nit = new JLabel("NIT");
        Nit.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Nit.setBounds(100, 460, 100, 60);
        Nit.setForeground(c.textoSecundario);
        Parent.add(Nit);
        //-------------------------------------------------------------------------------------------

        JTextField IdClient = new JTextField(" Id del cliente");
        IdClient.setBackground(c.azul);
        IdClient.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        IdClient.setBorder(BorderFactory.createEmptyBorder());
        IdClient.setBounds(210, 110, 200, 40);
        IdClient.setForeground(c.textoSecundario);
        IdClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IdClient.setText("");
            }
        });
        Parent.add(IdClient);
        JSeparator separador = new JSeparator();
        separador.setBackground(c.azul);
        separador.setOrientation(0);
        separador.setForeground(c.textoSecundario);
        separador.setBounds(210, 155, 200, 5);
        Parent.add(separador);

        JTextField NombreClient = new JTextField(" Nombre");
        NombreClient.setBackground(c.azul);
        NombreClient.setForeground(c.textoSecundario);
        NombreClient.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        NombreClient.setBorder(BorderFactory.createEmptyBorder());
        NombreClient.setBounds(210, 200, 200, 40);
        NombreClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NombreClient.setText("");
            }
        });
        Parent.add(NombreClient);
        JSeparator separador2 = new JSeparator();
        separador2.setBackground(c.azul);
        separador2.setOrientation(0);
        separador2.setForeground(c.textoSecundario);
        separador2.setBounds(210, 245, 200, 5);
        Parent.add(separador2);

        JTextField DirClient = new JTextField(" Dirección");
        DirClient.setBackground(c.azul);
        DirClient.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        DirClient.setBorder(BorderFactory.createEmptyBorder());
        DirClient.setBounds(210, 290, 200, 40);
        DirClient.setForeground(c.textoSecundario);
        DirClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DirClient.setText("");
            }
        });
        Parent.add(DirClient);
        JSeparator separador3 = new JSeparator();
        separador3.setBackground(c.azul);
        separador3.setOrientation(0);
        separador3.setForeground(c.textoSecundario);
        separador3.setBounds(210, 335, 200, 5);
        Parent.add(separador3);

        JTextField TelClient = new JTextField(" Teléfono");
        TelClient.setBackground(c.azul);
        TelClient.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        TelClient.setBorder(BorderFactory.createEmptyBorder());
        TelClient.setBounds(210, 380, 200, 40);
        TelClient.setForeground(c.textoSecundario);
        TelClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelClient.setText("");
            }
        });
        Parent.add(TelClient);
        JSeparator separador4 = new JSeparator();
        separador4.setBackground(c.azul);
        separador4.setOrientation(0);
        separador4.setForeground(c.textoSecundario);
        separador4.setBounds(210, 425, 200, 5);
        Parent.add(separador4);

        JTextField NitClient = new JTextField(" NIT");
        NitClient.setBackground(c.azul);
        NitClient.setFont(fuente.fuente(fuente.RobotoBold, 0, 15));
        NitClient.setBorder(BorderFactory.createEmptyBorder());
        NitClient.setBounds(210, 470, 200, 40);
        NitClient.setForeground(c.textoSecundario);
        NitClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NitClient.setText("");
            }
        });
        Parent.add(NitClient);
        JSeparator separador5 = new JSeparator();
        separador5.setBackground(c.azul);
        separador5.setOrientation(0);
        separador5.setForeground(c.textoSecundario);
        separador5.setBounds(210, 515, 200, 5);
        Parent.add(separador5);

        //-------------------------------------------------------------------------------------------
        JButton aceptar = new JButton("Agregar");
        aceptar.setBackground(azul);
        aceptar.setBounds(NitClient.getX() + 30, 270, 140, 45);
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
                int Buscar = Integer.parseInt(Id.getText());
                if (cliente.buscarCliente(Buscar) == true) {
                    log.addCuerpo("USERS: El cliente "+nombre+" ya existe");

                    JOptionPane.showConfirmDialog(Parent, "El cliente ya existe, intente con otro Id", "Cliente Incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                } else {
                    int IdParse = Integer.parseInt(Id.getText());
                    int TelParse = Integer.parseInt(Telefono.getText());
                    cliente.insertarCliente(IdParse, nombre.getText(), Direccion.getText(), TelParse, Nit.getText());
                    logdeacciones.addlog(usuario.getSesion()+" : Agregar cliente "+ nombre.getText());

                    JOptionPane.showConfirmDialog(Parent, "El cliente se registro correctamente", "Cliente Ingresado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    cerrar2();
                }

            }
        });
        Parent.add(aceptar);
    }

    void cerrar2() {
        this.dispose();
    }
}
