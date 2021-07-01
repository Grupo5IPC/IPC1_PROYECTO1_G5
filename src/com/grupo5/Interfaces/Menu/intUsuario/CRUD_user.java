package com.grupo5.Interfaces.Menu.intUsuario;

import com.grupo5.Usuarios.Gestor_usuario;
import com.grupo5.Usuarios.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class CRUD_user extends JPanel {
    public static Gestor_usuario usuario;

    public CRUD_user(Gestor_usuario user) {
        usuario = user;
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(Color.BLUE);

        usuario.print_usu();


        ArrayList<Usuario> data = usuario.getArray();
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Object> header = new ArrayList<Object>();
        header.add("Usuario");
        header.add("Password");
        header.add("Events");
        for (Object columna : header) {
            model.addColumn(columna);
        }
        String matriz[][]  = new String[data.size()][2];
        for (int i = 0; i<data.size(); i++){
            matriz[i][0] = data.get(i).getUsername();
            matriz[i][1] = data.get(i).getPassword();
            System.out.println(matriz[i][0]);
        }
        for (Object[] a: matriz){
            model.addRow(a);
        }

        JTable table = new JTable();
        table.setModel(model);
        //table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

        JScrollPane pane = new JScrollPane(table);
        add(pane);


    }

}
