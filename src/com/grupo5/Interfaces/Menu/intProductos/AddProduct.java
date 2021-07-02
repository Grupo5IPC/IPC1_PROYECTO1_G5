package com.grupo5.Interfaces.Menu.intProductos;

import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Productos.Gestor_Producto;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddProduct extends JPanel {

    public static Gestor_Producto producto;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public JTable table;
    JButton eliminar;
    JButton modificar;
    DefaultTableModel model;

    public Color textoSecundario = new Color(158, 161, 176);

    public AddProduct(Gestor_Producto product) {
        producto = product;
        JPanel aux = new JPanel();
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        producto.printProductos();
    }

    ImageIcon getIcon2(String ruta, @NotNull JButton label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

}
