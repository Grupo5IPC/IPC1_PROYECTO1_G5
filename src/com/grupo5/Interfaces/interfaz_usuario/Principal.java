package com.grupo5.Interfaces.interfaz_usuario;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {
    public JPanel lateralPrincipal;
    public JPanel lateralSecundario;
    public JPanel Principal;
    public Color azul = new Color(54, 105, 233);
    public Color fondo = new Color(30, 38, 51);


    public Principal(){
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setVisible(true);

        //Menu lateral
        lateralPrincipal = new JPanel();
        lateralPrincipal.setSize(60,720);
        lateralPrincipal.setBounds(0,0,60,720);
        lateralPrincipal.setBackground(azul);
        lateralPrincipal.setLayout(new GroupLayout(lateralPrincipal));
        this.add(lateralPrincipal);

        lateralSecundario = new JPanel();
        lateralSecundario.setSize(200,720);
        lateralSecundario.setBounds(60,0,200,720);
        lateralSecundario.setBackground(fondo);
        lateralSecundario.setLayout(new GroupLayout(lateralSecundario));
        this.add(lateralSecundario);





        menuLateral();
        menu();
    }


    void menuLateral(){
        // home
        JLabel home = new JLabel();
        home.setHorizontalAlignment(0);
        home.setForeground(Color.white);
        home.setVerticalAlignment(0);
        home.setSize((int) lateralPrincipal.getSize().getWidth(), 40);
        home.setBounds(0,100,home.getWidth(),40);
        home.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\home.png", home));
        home.setBackground(Color.BLACK);
        lateralPrincipal.add(home);

        // users
        JLabel users = new JLabel();
        users.setHorizontalAlignment(0);
        users.setForeground(Color.white);
        users.setVerticalAlignment(0);
        users.setSize((int) lateralPrincipal.getSize().getWidth(), 40);
        users.setBounds(0,160,home.getWidth(),40);
        users.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\user.png", home));
        users.setBackground(Color.BLACK);
        lateralPrincipal.add(users);

        // clients
        JLabel clients = new JLabel();
        clients.setHorizontalAlignment(0);
        clients.setForeground(Color.white);
        clients.setVerticalAlignment(0);
        clients.setSize((int) lateralPrincipal.getSize().getWidth(), 40);
        clients.setBounds(0,230,home.getWidth(),40);
        clients.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\clients.png", home));
        clients.setBackground(Color.BLACK);
        lateralPrincipal.add(clients);

        // products
        JLabel products = new JLabel();
        products.setHorizontalAlignment(0);
        products.setForeground(Color.white);
        products.setVerticalAlignment(0);
        products.setSize((int) lateralPrincipal.getSize().getWidth(), 40);
        products.setBounds(0,300,home.getWidth(),40);
        products.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\products.png", home));
        products.setBackground(Color.BLACK);
        lateralPrincipal.add(products);

        // invoices
        JLabel invo = new JLabel();
        invo.setHorizontalAlignment(0);
        invo.setForeground(Color.white);
        invo.setVerticalAlignment(0);
        invo.setSize((int) lateralPrincipal.getSize().getWidth(), 40);
        invo.setBounds(0,370,home.getWidth(),40);
        invo.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\invoice.png", home));
        invo.setBackground(Color.BLACK);
        lateralPrincipal.add(invo);

        // exit
        JLabel exit = new JLabel();
        exit.setHorizontalAlignment(0);
        exit.setForeground(Color.white);
        exit.setVerticalAlignment(0);
        exit.setSize((int) lateralPrincipal.getSize().getWidth(), 60);
        exit.setBounds(0,630,home.getWidth(),60);
        exit.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));
        exit.setIcon(getIcon("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\logout.png", home));
        exit.setBackground(Color.BLACK);
            lateralPrincipal.add(exit);

    }
    ImageIcon getIcon(String ruta, @NotNull JLabel label){
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth()-30, label.getHeight()-18, Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }
    ImageIcon getIcon2(String ruta, @NotNull JLabel label){
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    void menu(){

        JPanel botonVer = new JPanel(null);
        botonVer.setBounds(0,100,lateralSecundario.getWidth(), 45);
        botonVer.setBackground(fondo);

        JLabel iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);
        iconVer.setForeground(Color.white);
        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(10,8,30,30);
        iconVer.setIcon(getIcon2("C:\\Users\\ludwi\\IdeaProjects\\IPC1_PROYECTO1_G5\\iconos\\users\\lista.png", iconVer));
        iconVer.setBackground(Color.BLACK);
        botonVer.add(iconVer);

        JLabel txtVer = new JLabel("Lista de Usuarios");

        lateralSecundario.add(botonVer);

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
