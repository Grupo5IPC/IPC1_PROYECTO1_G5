package com.grupo5.Interfaces.Menu;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Gestor_restaurante;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    public static Gestor_restaurante Nuevo;
    public static Gestor_usuario usuario;
    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;

    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);
    public Color paneles = new Color(37, 42, 64);

    public Dashboard(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes, Gestor_restaurante nuev) {
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

    }

    void setPaneles() {
        Fuentes fuente = new Fuentes();
        JPanel infoRes = new JPanel(null);
        infoRes.setBounds(50, 20, 260, 140);
        infoRes.setBackground(paneles);
        add(infoRes);

        JLabel titulo = new JLabel(Nuevo.restaurante.get(0).getNombre());
        titulo.setForeground(Color.lightGray);
        titulo.setFont(new Font("Nirmala UI", 0, 14));
        titulo.setBounds(20, 5, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        infoRes.add(titulo);
        JLabel direccion = new JLabel(Nuevo.restaurante.get(0).getDireccion());
        direccion.setForeground(titulo.getForeground());
        direccion.setFont(titulo.getFont());
        direccion.setBounds(20, 40, 140, 30);
        infoRes.add(direccion);
        JLabel telefono = new JLabel(String.valueOf( Nuevo.restaurante.get(0).getNumero()));
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
        titulo = new JLabel("Editar Datos");
        titulo.setForeground(Color.lightGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Nirmala UI", 0, 19));
        titulo.setBounds(20, 5, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        editRes.add(titulo);
        JButton editar = new JButton("Editar");
        editar.setBackground(this.getBackground());
        editar.setFont(new Font("Nirmala UI", 1, 22));
        editar.setForeground(new Color(50, 226, 178));
        editar.setBounds(40, 60, 180, 50);
        editar.setFocusPainted(false);
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setBorderPainted(false);
        editRes.add(editar);


        JPanel countUsu = new JPanel(null);
        countUsu.setBounds(630, 20, 230, 140);
        countUsu.setBackground(paneles);
        add(countUsu);
        titulo = new JLabel("Contador de usuarios");
        titulo.setForeground(Color.lightGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Nirmala UI", 0, 19));
        titulo.setBounds(30, 5, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        countUsu.add(titulo);
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
        titulo = new JLabel("Contador de clientes");
        titulo.setForeground(Color.lightGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Nirmala UI", 0, 19));
        titulo.setBounds(30, 5, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo);
        numero = new JLabel(String.valueOf(cliente.getClientes().size()));
        numero.setForeground(texto);
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 10, 160, 120);
        infoclientes.add(numero);

        titulo = new JLabel("Contador de facturas");
        titulo.setForeground(Color.lightGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Nirmala UI", 0, 19));
        titulo.setBounds(30, 110, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo);
        numero = new JLabel(String.valueOf(factura.getFacturas().size()));
        numero.setForeground(editar.getForeground());
        numero.setFont(new Font("Nirmala UI", 1, 50));
        numero.setBounds(90, 115, 160, 120);
        infoclientes.add(numero);

        titulo = new JLabel("Contador de productos");
        titulo.setForeground(Color.lightGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Nirmala UI", 0, 19));
        titulo.setBounds(30, 220, 260, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        infoclientes.add(titulo);
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
}
