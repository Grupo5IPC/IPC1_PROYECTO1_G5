package com.grupo5.Interfaces.Menu.intCliente;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.*;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.Render;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class CRUD_cliente extends JPanel {
    public static Gestor_cliente cliente;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public JTable table;
    JButton eliminar;
    JButton modificar;
    DefaultTableModel model;

    public Color textoSecundario = new Color(158, 161, 176);

    public CRUD_cliente(Gestor_cliente invoice) {
        cliente = invoice;
        JPanel aux = new JPanel();
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        cliente.printClientes();


        ArrayList<Cliente> data = cliente.getClientes();

        Object[] header = new Object[]{"Id", "Nombre        ", "Direccion         ", "Telefono   ", "   NIT   ", "", ""};
        //modificar

        Object matriz[][] = new Object[data.size()][7];
        modificar = new JButton("Modificar");
        modificar.setName("m");
        modificar.setForeground(textoSecundario);
        modificar.setBorder(null);
        modificar.setBackground(azul);
        modificar.setBounds(0, 0, 30, 30);
        modificar.setIcon(getIcon2("iconos\\update.png", modificar));
        modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modificar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

        eliminar = new JButton("Eliminar");
        eliminar.setName("e");
        eliminar.setForeground(textoSecundario);
        eliminar.setBorder(null);
        eliminar.setBackground(azul);
        eliminar.setBounds(0, 0, 30, 30);
        eliminar.setForeground(textoSecundario);
        eliminar.setIcon(getIcon2("iconos\\delete2.png", modificar));
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));
        for (int i = 0; i < data.size(); i++) {

            matriz[i][0] = Integer.toString(data.get(i).getId());
            matriz[i][1] = data.get(i).getName();
            matriz[i][2] = data.get(i).getAddress();
            matriz[i][3] = Integer.toString(data.get(i).getPhone());
            matriz[i][4] = data.get(i).getNit();
            matriz[i][5] = modificar;
            matriz[i][6] = eliminar;
        }

        model = new DefaultTableModel(matriz, header) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setForeground(textoSecundario);
        table.getTableHeader().setForeground(textoSecundario);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.setDefaultRenderer(Object.class, new Render());
        table.setFocusable(false);
        table.setBackground(azul);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.setRowHeight(50);
        table.setSelectionBackground(texto);
        table.setShowVerticalLines(false);
        table.setBorder(BorderFactory.createEmptyBorder());
        table.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

        table.getTableHeader().setFont(fuente.fuente(fuente.OpensansBold, 0, 17));
        table.getTableHeader().setOpaque(true);

        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
        table.getTableHeader().setBackground(azul);
        table.getTableHeader().setResizingAllowed(false);
        table.setShowHorizontalLines(true);
        table.setGridColor(texto);


        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setBounds(80, 100, 400, 400);
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int col = table.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / table.getRowHeight();
                if (row < table.getRowCount() && row >= 0 && col < table.getColumnCount() && col > 0) {
                    Object valor = table.getValueAt(row, col);
                    if (valor instanceof JButton) {
                        ((JButton) valor).doClick();
                        JButton btn = (JButton) valor;
                        if (btn.getName().equals("m")) {
                            System.out.println("Modificar");
                            String cliente = (String) table.getValueAt(row, 0);
                            System.out.println(cliente);
                        }
                        if (btn.getName().equals("e")) {
                            int idCliente = Integer.parseInt((String) table.getValueAt(row, 0));
                            cliente.eliminarCliente(idCliente);
                            model.removeRow(row);
                            cliente.printClientes();
                            System.out.println("Eliminar");
                        }
                    }
                }
            }
        });
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        pane.setBackground(azul);

        pane.setOpaque(true);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getViewport().setBackground(azul);
        pane.setBounds(150, 100, 600, 400);

        add(pane);


    }

    ImageIcon getIcon2(String ruta, @NotNull JButton label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }


}
