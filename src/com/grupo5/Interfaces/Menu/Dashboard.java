package com.grupo5.Interfaces.Menu;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Gestor_restaurante;
import com.grupo5.Interfaces.Menu.intUsuario.Dialogs.updateUser;
import com.grupo5.Log;
import com.grupo5.Logdeacciones;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JPanel {
    public static Gestor_restaurante Nuevo;
    public static Gestor_usuario usuario;
    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;
    public static Log log;
    public static Logdeacciones logdeacciones;

    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);
    public Color paneles = new Color(37, 42, 64);

    public Dashboard(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes, Gestor_restaurante nuev, Log log, Logdeacciones logdeacciones) {
        this.log = log;
        this.logdeacciones = logdeacciones;
        Nuevo = nuev;
        usuario = usuarios;
        producto = productos;
        factura = facturas;
        cliente = clientes;
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);
        setPaneles();
        revalidate();
        repaint();

    }

    public JLabel nombre;
    public JLabel direccion;
    public JLabel telefono;

    void setPaneles() {
        Fuentes fuente = new Fuentes();
        JPanel infoRes = new JPanel(null);
        infoRes.setBounds(50, 20, 260, 140);
        infoRes.setBackground(paneles);
        add(infoRes);

        nombre = new JLabel(Nuevo.restaurante.get(0).getNombre());
        nombre.setForeground(Color.lightGray);
        nombre.setFont(new Font("Nirmala UI", 0, 14));
        nombre.setBounds(20, 5, 260, 30);
        nombre.setHorizontalAlignment(SwingConstants.LEFT);
        infoRes.add(nombre);
        direccion = new JLabel(Nuevo.restaurante.get(0).getDireccion());
        direccion.setForeground(nombre.getForeground());
        direccion.setFont(nombre.getFont());
        direccion.setBounds(20, 40, 140, 30);
        infoRes.add(direccion);
        telefono = new JLabel(String.valueOf(Nuevo.restaurante.get(0).getNumero()));
        telefono.setForeground(texto);
        telefono.setFont(new Font("Nirmala UI", 1, 20));
        telefono.setBounds(20, 60, 140, 60);
        infoRes.add(telefono);
        JLabel img = new JLabel();
        img.setSize(100, 80);
        img.setBounds(150, 40, 100, 80);
        img.setIcon(getIcon2("iconos\\restaurant.png", img));
        infoRes.add(img);


        JPanel editRes = new JPanel(null);
        editRes.setBounds(340, 20, 260, 140);
        editRes.setBackground(paneles);
        add(editRes);
        JLabel titulo2 = new JLabel("Editar Datos");
        titulo2.setForeground(Color.lightGray);
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setFont(new Font("Nirmala UI", 0, 19));
        titulo2.setBounds(20, 5, 260, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        editRes.add(titulo2);
        JButton editar = new JButton("Editar");
        editar.setBackground(this.getBackground());
        editar.setFont(new Font("Nirmala UI", 1, 22));
        editar.setForeground(new Color(50, 226, 178));
        editar.setBounds(40, 60, 180, 50);
        editar.setFocusPainted(false);
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setBorderPainted(false);
        editar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                openDialog();

                reset();
            }
        });
        editRes.add(editar);


        JPanel countUsu = new JPanel(null);
        countUsu.setBounds(630, 20, 230, 140);
        countUsu.setBackground(paneles);
        add(countUsu);
        titulo2 = new JLabel("Contador de usuarios");
        titulo2.setForeground(Color.lightGray);
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setFont(new Font("Nirmala UI", 0, 19));
        titulo2.setBounds(30, 5, 260, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        countUsu.add(titulo2);
        JLabel numero = new JLabel(String.valueOf(usuario.getSize()));
        numero.setForeground(editar.getForeground());
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 20, 160, 120);
        countUsu.add(numero);

        //segunda linea
        JPanel infoclientes = new JPanel(null);
        infoclientes.setBounds(50, 190, 260, 400);
        infoclientes.setBackground(paneles);
        add(infoclientes);
        titulo2 = new JLabel("Contador de clientes");
        titulo2.setForeground(Color.lightGray);
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setFont(new Font("Nirmala UI", 0, 19));
        titulo2.setBounds(30, 5, 260, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo2);
        numero = new JLabel(String.valueOf(cliente.getClientes().size()));
        numero.setForeground(texto);
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 10, 160, 120);
        infoclientes.add(numero);

        titulo2 = new JLabel("Contador de facturas");
        titulo2.setForeground(Color.lightGray);
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setFont(new Font("Nirmala UI", 0, 19));
        titulo2.setBounds(30, 110, 260, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo2);
        numero = new JLabel(String.valueOf(factura.getFacturas().size()));
        numero.setForeground(editar.getForeground());
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 115, 160, 120);
        infoclientes.add(numero);

        titulo2 = new JLabel("Contador de productos");
        titulo2.setForeground(Color.lightGray);
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setFont(new Font("Nirmala UI", 0, 19));
        titulo2.setBounds(30, 220, 260, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo2);
        numero = new JLabel(String.valueOf(producto.getProductos().size()));
        numero.setForeground(texto);
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 225, 160, 120);
        infoclientes.add(numero);

        JPanel grafica = new JPanel(null);
        grafica.setBounds(340, 190, 520, 400);
        grafica.setBackground(paneles);
        add(grafica);
    }

    ImageIcon getIcon2(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    void openDialog() {
        Editar_restaurante c = new Editar_restaurante(usuario,Nuevo,true,log,logdeacciones);
        c.setVisible(true);
    }

    void reset() {
        nombre.setText(Nuevo.restaurante.get(0).getNombre());
        direccion.setText(Nuevo.restaurante.get(0).getDireccion());
        telefono.setText(String.valueOf(Nuevo.restaurante.get(0).getNumero()));

    }
}
