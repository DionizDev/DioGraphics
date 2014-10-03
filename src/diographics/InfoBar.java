/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author fran
 */
public class InfoBar {
    
    private JPanel panel, panelTab1, panelTab2, panel2;
    private JTabbedPane panelTab;
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
        panel.add(panelTab, layout);
        //panel.add(panel1, layout);
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
        
        panelTab = new JTabbedPane();
        //panelTab.setLayout(layout2);
        panelTab.setPreferredSize(new Dimension(40, 200));
        panelTab.setLocation(10, 10);
        
        
        panelTab1 = new JPanel();
        panelTab1.setLayout(layout2);
        panelTab1.setPreferredSize(new Dimension(40, 200));
        panelTab1.setLocation(10, 10);
        panelTab1.setBorder(titulo);
        
        panelTab2 = new JPanel();
        panelTab2.setLayout(layout2);
        panelTab2.setPreferredSize(new Dimension(40, 200));
        panelTab2.setLocation(10, 10);
        panelTab2.setBorder(titulo);
        
        panel2 = new JPanel();
        panel2.setLayout(layout2);
        panel2.setPreferredSize(new Dimension(40, 60));
        panel2.setLocation(10, 10);
        panel2.setBorder(titulo2);
        
        panelTab.addTab("Absoluto", panelTab1);
        panelTab.addTab("Acumulativo", panelTab2);
       
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public JPanel getAbsolutHistogramPanel(){
        return panelTab1;
    }
    
    public JPanel getAcumHistogramPanel(){
        return panelTab2;
    }
}
