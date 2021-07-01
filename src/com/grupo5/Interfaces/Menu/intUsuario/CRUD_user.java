package com.grupo5.Interfaces.Menu.intUsuario;

import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.*;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.Render;
import com.grupo5.Usuarios.Gestor_usuario;
import com.grupo5.Usuarios.Usuario;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class CRUD_user extends JPanel {
    public static Gestor_usuario usuario;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);

    public CRUD_user(Gestor_usuario user) {
        usuario = user;
        JPanel aux = new JPanel();
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        usuario.print_usu();


        ArrayList<Usuario> data = usuario.getArray();

        Object [] header = new Object[]{"Usuario", "Password", "", ""};



        Object matriz[][]  = new Object[data.size()][4];
        JLabel modificar = new JLabel("Modificar");
        modificar.setForeground(textoSecundario);
        modificar.setBounds(0,0,30,30);
        modificar.setIcon(getIcon2("iconos\\update.png",modificar));
        modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel eliminar = new JLabel("Eliminar");

        eliminar.setBounds(0,0,30,30);
        eliminar.setForeground(textoSecundario);
        eliminar.setIcon(getIcon2("iconos\\delete2.png",modificar));
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        for (int i = 0; i<data.size(); i++){

            matriz[i][0] = data.get(i).getUsername();
            matriz[i][1] = data.get(i).getPassword();
            matriz[i][2] = modificar;
            matriz[i][3] = eliminar;

        }

        DefaultTableModel model = new DefaultTableModel(matriz, header){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setForeground(textoSecundario);
        table.getTableHeader().setForeground(textoSecundario);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.setDefaultRenderer(Object.class,new Render());
        table.setFocusable(false);
        table.setBackground(azul);
        table.setIntercellSpacing(new Dimension(0,1));
        table.setRowHeight(50);
       table.setSelectionBackground(texto);
        table.setShowVerticalLines(false);
        table.setBorder(BorderFactory.createEmptyBorder());


        table.getTableHeader().setFont(fuente.fuente(fuente.OpensansBold, 0,17));
        table.getTableHeader().setOpaque(true);

       table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
       table.getTableHeader().setBackground(azul);
       table.getTableHeader().setResizingAllowed(false);
       table.setGridColor(azul);

        UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));

        //table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setBounds(80,100,400,400);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        pane.setBackground(azul);

        pane.setOpaque(true);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getViewport().setBackground(azul);
        pane.setBounds(150,100,600,400);

        add(pane);


    }
    ImageIcon getIcon2(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

}
