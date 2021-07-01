package com.grupo5.Interfaces.Menu.intUsuario.Dialogs;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class Confirmacion extends JDialog {
    public Confirmacion(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });
    }
}
