package com.grupo5.Interfaces.Menu.intProductos;

import com.grupo5.Fuentes.Fuentes;
import static com.grupo5.Interfaces.Menu.intUsuario.CRUD_user.usuario;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.HeaderRenderer;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.Render;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Productos.Producto;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CRUD_products1 extends JPanel{

    public static Gestor_Producto producto;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);
    public JTable table;
    JButton eliminar;
    JButton modificar;
    DefaultTableModel model;

    public CRUD_products1(Gestor_Producto product) {
        producto = product;
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        producto.printProductos();

        //TABLA PRODUCTOS
        ArrayList<Producto> data = producto.getProductos();

        Object[] header = new Object[]{"   Id", "   Nombre", "   Descripción",
            "   Costo", "   Precio", "", ""};
        Object matriz[][] = new String[data.size()][8];
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
            matriz[i][2] = data.get(i).getDescription();
            matriz[i][3] = Double.toString(data.get(i).getCost());
            matriz[i][4] = Double.toString(data.get(i).getPrice());
            matriz[i][5] = modificar;
            matriz[i][6] = eliminar;
        }
        model = new DefaultTableModel(matriz, header) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //this.setLayout(null);

        /*table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                System.out.println(table.getValueAt(table.getSelectedRow(), 1).toString());
            }
        });*/
        
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
                            String usuario = (String) table.getValueAt(row, 0);
                            System.out.println(usuario);
                        }
                        if (btn.getName().equals("e")) {

                            usuario.eliminarUsuario((String) table.getValueAt(row, 0));
                            model.removeRow(row);
                            usuario.print_usu();
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

        /*//TABLA INGREDIENTES DE PRODUCTOS
        DefaultTableModel model2 = new DefaultTableModel();
        ArrayList<Object> header2 = new ArrayList<Object>();
        header2.add("Nombre");
        header2.add("Cantidad");
        header2.add("Unidades");

        for (Object columna : header2) {
            model2.addColumn(columna);
        }
        String[][] matriz2 = new String[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).getIngredientes().size(); j++) {
                matriz2[j][0] = data.get(i).getIngredientes().get(j).getName();
                matriz2[j][1] = Integer.toString(data.get(i).getIngredientes().get(j).getQuantity());
                matriz2[j][2] = data.get(i).getIngredientes().get(j).getUnits();
            }
        }
        for (Object[] a : matriz2) {
            model2.addRow(a);
        }
        this.setLayout(null);

        JTable table2 = new JTable();
        table2.setModel(model2);
        table2.setVisible(true);
        JScrollPane pane2 = new JScrollPane(table2);
        pane2.setVisible(true);
        pane2.setBounds(570, 200, 300, 385);
        add(pane2);

    }*/

