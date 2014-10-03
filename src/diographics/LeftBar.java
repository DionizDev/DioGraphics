/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author fran
 */
public class LeftBar {
    private JPanel panel;
    private Border borde;
    private GridLayout layout;
    private JButton boton1, boton2, boton3;
    
    public LeftBar(){
        borde = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        layout = new GridLayout(20, 1, 5, 5);
        // Creación del panel
        panel = new JPanel();
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(40, 10));
        panel.setBorder(borde);
        
        
        // Creamos los componentes con sus características
        this.setButtons();
        
        // Añadir los componentes al panel
       // panel.add(panelTab, layout);
        //panel.add(panel1, layout);
       // panel.add(panel2, layout);
        
        panel.add(boton1, layout);
        panel.add(boton2, layout);
        panel.add(boton3, layout);
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public void setButtons(){
        
        boton1 = new JButton();
        boton1.setPreferredSize(new Dimension(10, 10));
        boton1.setLocation(0, 0);
        boton1.setBorder(borde);
        
        boton2 = new JButton();
        boton2.setPreferredSize(new Dimension(10, 10));
        boton2.setLocation(0, 0);
        boton2.setBorder(borde);
        
        boton3 = new JButton();
        boton3.setPreferredSize(new Dimension(20, 20));
        boton3.setLocation(0, 0);
        boton3.setBorder(borde);
    }
}
