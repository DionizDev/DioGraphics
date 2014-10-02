/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author fran
 */
public class InfoBar {
    
    private JPanel panel, panel1, panel2;
    private JButton boton;
    private Border borde;
    private GridLayout layout;
    
    public InfoBar(){
        borde = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        layout = new GridLayout(2, 1, 10, 10);
        // Creación del panel
        panel = new JPanel();
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(300, 40));
        panel.setBorder(borde);
        
        // Creamos los componentes con sus características
        this.setPanels();
        
        // Añadir los componentes al panel
        panel.add(panel1, layout);
        panel.add(panel2, layout);
        
    }
    
    public final void setPanels(){
        
        // Creación del titulo con el borde
        TitledBorder titulo, titulo2;
        titulo = BorderFactory.createTitledBorder("Histograma");
        titulo.setTitleJustification(TitledBorder.LEFT);
        titulo.setTitleColor(Color.gray);
        
        titulo2 = BorderFactory.createTitledBorder("Propiedades");
        titulo2.setTitleColor(Color.gray);
        
        BorderLayout layout2 = new BorderLayout();
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(layout2);
        panel2.setLayout(layout2);
        panel1.setPreferredSize(new Dimension(40, 200));
        panel2.setPreferredSize(new Dimension(40, 60));
        panel1.setLocation(10, 10);
        panel1.setBorder(titulo);
        panel2.setBorder(titulo2);
        
       
    }
    
    public JPanel getPanel(){
        return panel;
    }
}
