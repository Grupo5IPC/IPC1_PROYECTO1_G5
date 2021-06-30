package com.grupo5.Interfaces.Menu;

import com.grupo5.Fuentes.Fuentes;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Principal extends JFrame {
    public JPanel user;
    public JPanel lateralSecundario;
    public JPanel Principal;
    public JPanel superior;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);


    public Principal() {
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        setUndecorated(true);
        this.setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            }
        });


        //Menu lateral
        user = new JPanel();
        user.setSize(200, 180);
        user.setBounds(0, 0, 200, 180);
        user.setBackground(fondo);
        lateralSecundario = new JPanel();
        lateralSecundario.setSize(200, 720);
        lateralSecundario.setBounds(0, 0, 200, 720);
        lateralSecundario.setBackground(fondo);
        lateralSecundario.setLayout(new GroupLayout(lateralSecundario));
        this.add(lateralSecundario);
        user.setLayout(null);
        lateralSecundario.add(user);

        Principal = new JPanel();
        Principal.setSize(900, 720);
        Principal.setBounds(180, 0, 900, 720);
        Principal.setBackground(azul);
        Principal.setLayout(new GroupLayout(Principal));
        this.add(Principal);
        setUser();
        setSuperior();
        menu();
    }


    void setUser() {

        JLabel profile = new JLabel();
        profile.setHorizontalAlignment(0);
        profile.setForeground(Color.white);

        profile.setSize(100, 100);
        profile.setBounds(40, 20, 110, 110);
        profile.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\profile.png", profile));

        user.add(profile);

        // users
        JLabel users = new JLabel("Darwin Arevalo");
        users.setHorizontalAlignment(0);
        users.setForeground(Color.white);
        users.setVerticalAlignment(0);
        users.setSize(180, 30);
        users.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        users.setForeground(texto);
        users.setBounds(0, 140, 180, 20);

        user.add(users);


    }

    ImageIcon getIcon(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth() - 30, label.getHeight() - 18, Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    ImageIcon getIcon2(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    void menu() {
        //boton listar usuarios
        Fuentes fuente = new Fuentes();
        JPanel botonVer = new JPanel(null);
        botonVer.setBounds(0, 200, lateralSecundario.getWidth(), 45);
        botonVer.setBackground(fondo);
        // botonVer.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        JLabel iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\user.png", iconVer));

        botonVer.add(iconVer);

        JLabel txtVer = new JLabel("Usuarios");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonVer.add(txtVer);

        lateralSecundario.add(botonVer);

        //boton listar clientes

        JPanel botonclient = new JPanel(null);
        botonclient.setBounds(0, 245, lateralSecundario.getWidth(), 45);
        botonclient.setBackground(fondo);
        // botonclient.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\clients.png", iconVer));

        botonclient.add(iconVer);

        txtVer = new JLabel("Clientes");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonclient.add(txtVer);

        lateralSecundario.add(botonclient);

        //boton listar product

        JPanel botonproduct = new JPanel(null);
        botonproduct.setBounds(0, 290, lateralSecundario.getWidth(), 45);
        botonproduct.setBackground(fondo);
        //botonproduct.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\products.png", iconVer));

        botonproduct.add(iconVer);

        txtVer = new JLabel("Productos   ");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonproduct.add(txtVer);

        lateralSecundario.add(botonproduct);

        //boton listar invoice

        JPanel botoninvoice = new JPanel(null);
        botoninvoice.setBounds(0, 335, lateralSecundario.getWidth(), 45);
        botoninvoice.setBackground(fondo);
        //botoninvoice.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\invoice.png", iconVer));

        botoninvoice.add(iconVer);

        txtVer = new JLabel("Facturas");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botoninvoice.add(txtVer);

        lateralSecundario.add(botoninvoice);
        //boton listar invoice

        JPanel botonexit = new JPanel(null);
        botonexit.setBounds(0, 675, lateralSecundario.getWidth(), 45);
        botonexit.setBackground(fondo);
        //botonexit.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\logout.png", iconVer));

        botonexit.add(iconVer);

        txtVer = new JLabel("Salir");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonexit.add(txtVer);

        lateralSecundario.add(botonexit);


    }

    void setSuperior() {
        superior = new JPanel(null);
        superior.setBounds(0, 0,900, 100 );
        superior.setBackground(Principal.getBackground());
        superior.setForeground(textoSecundario);
        Principal.add(superior);
        JLabel txtTitle = new JLabel("Usuarios");
        txtTitle.setBounds(60, 30, 200, 40);
        txtTitle.setForeground(textoSecundario);
        txtTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
        superior.add(txtTitle);

        JLabel exit = new JLabel("x");
        exit.setBounds(875, 0, 200, 40);
        exit.setForeground(textoSecundario);
        exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

        });
        superior.add(exit);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Principal();
            }
        });
    }
}
