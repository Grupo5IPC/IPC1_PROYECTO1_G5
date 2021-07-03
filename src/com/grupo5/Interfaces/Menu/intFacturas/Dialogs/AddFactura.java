package com.grupo5.Interfaces.Menu.intFacturas.Dialogs;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.Colors;
import com.grupo5.Interfaces.Menu.intFacturas.CRUD_factura;
import com.grupo5.Interfaces.Menu.intUsuario.CRUD_user;
import com.grupo5.Usuarios.Gestor_usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.geom.*;

public class AddFactura extends JDialog {

    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;
    public JLabel title;
    public CRUD_factura Crud_factura;
    public JButton acep;
    public JPanel Parent;
    public Colors c = new Colors();
    public Color azul = new Color(42, 52, 67);
    public Color fondo = new Color(157, 207, 255);

    public AddFactura(Gestor_Factura invoice, Gestor_cliente client, boolean modal) {
        Parent = new JPanel();
        factura = invoice;
        cliente = client;
        setUndecorated(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });

        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(550, 350);
        setBounds(100, 0, 550, 550);
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
        title = new JLabel("Agregar Factura");
        title.setFont(fuente.fuente(fuente.RobotoBold, 1, 25));
        title.setBounds(160, 30, 200, 60);
        title.setForeground(c.fondo);
        Parent.add(title);
        JLabel cerrar = new JLabel("x");
        cerrar.setFont(fuente.fuente(fuente.RobotoBold, 1, 14));
        cerrar.setForeground(c.fondo);
        cerrar.setBounds((int) this.getSize().getWidth() - 15, 0, 30, 30);
        Parent.add(cerrar);

        JLabel Id = new JLabel("Id");
        Id.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Id.setBounds(100, 100, 100, 60);
        Id.setForeground(c.fondo);
        Parent.add(Id);

        JLabel nombre = new JLabel("Cliente");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        nombre.setBounds(100, 190, 100, 60);
        nombre.setForeground(c.fondo);
        Parent.add(nombre);

        JLabel Direccion = new JLabel("Fecha");
        Direccion.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Direccion.setBounds(100, 280, 100, 60);
        Direccion.setForeground(c.fondo);
        Parent.add(Direccion);

        JLabel Telefono = new JLabel("Productos");
        Telefono.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Telefono.setBounds(100, 370, 100, 60);
        Telefono.setForeground(c.fondo);
        Parent.add(Telefono);

        //-------------------------------------------------------------------------------------------
        JTextField IdClient = new JTextField(" Id de la factura");
        IdClient.setBackground(fondo);
        IdClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        IdClient.setBorder(BorderFactory.createEmptyBorder());
        IdClient.setBounds(210, 110, 200, 40);
        IdClient.setForeground(c.fondo);
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
        separador.setForeground(c.fondo);
        separador.setBounds(210, 155, 200, 5);
        Parent.add(separador);

        JComboBox NombreClient = new JComboBox(cliente.getClientes().toArray());
        NombreClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SelectClient = (String) NombreClient.getSelectedItem();
            }
        });

        NombreClient.setBackground(fondo);
        NombreClient.setForeground(c.fondo);
        NombreClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        NombreClient.setBorder(BorderFactory.createEmptyBorder());
        NombreClient.setBounds(210, 200, 200, 40);

        Parent.add(NombreClient);
        JSeparator separador2 = new JSeparator();
        separador2.setBackground(c.azul);
        separador2.setOrientation(0);
        separador2.setForeground(c.fondo);
        separador2.setBounds(210, 245, 200, 5);
        Parent.add(separador2);

        JTextField FechaFact = new JTextField(" Fecha");
        FechaFact.setBackground(fondo);
        FechaFact.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        FechaFact.setBorder(BorderFactory.createEmptyBorder());
        FechaFact.setBounds(210, 290, 200, 40);
        FechaFact.setForeground(c.fondo);
        FechaFact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FechaFact.setText("");
            }
        });
        Parent.add(FechaFact);
        JSeparator separador3 = new JSeparator();
        separador3.setBackground(c.azul);
        separador3.setOrientation(0);
        separador3.setForeground(c.textoSecundario);
        separador3.setBounds(210, 335, 200, 5);
        Parent.add(separador3);

        JComboBox ProductsFact = new JComboBox(factura.getFacturas().toArray());
        ProductsFact.setBackground(c.azul);
        ProductsFact.setForeground(c.textoSecundario);
        ProductsFact.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        ProductsFact.setBorder(BorderFactory.createEmptyBorder());
        ProductsFact.setBounds(210, 200, 200, 40);

        Parent.add(ProductsFact);
        JSeparator separador4 = new JSeparator();
        separador4.setBackground(c.azul);
        separador4.setOrientation(0);
        separador4.setForeground(c.textoSecundario);
        separador4.setBounds(210, 425, 200, 5);
        Parent.add(separador4);

        //-------------------------------------------------------------------------------------------
        JButton aceptar = new JButton("Agregar");
        aceptar.setBackground(azul);
        aceptar.setBounds(Telefono.getX() + 130, Telefono.getY() + 110, 140, 45);
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
                if (factura.buscarFactura(Buscar) == true) {
                    JOptionPane.showConfirmDialog(Parent, "La Factura ya existe, intente con otro Id", "Factura Incorrecta", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                } else {
                    int IdParse = Integer.parseInt(IdClient.getText());
                    /*factura.insertarFactura(IdParse, NombreClient.get, FechaFact.getText(), ProductsFact);
                    JOptionPane.showConfirmDialog(Parent, "El cliente se registro correctamente", "Cliente Ingresado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    cerrar2();*/
                }

            }
        });
        Parent.add(aceptar);
    }

    void cerrar2() {
        this.dispose();
    }
}
