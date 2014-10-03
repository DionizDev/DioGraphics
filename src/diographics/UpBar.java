/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author fran
 */
public class UpBar {
        //Where the GUI is created:
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem, menuItem1;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JPanel panel;

    public UpBar(ActionListener ventana){
        // Creación del panel
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Creación del menú
        menuBar = new JMenuBar();

        // Archivo
        menu = new JMenu("Archivo");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Archivo");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem1 = new JMenuItem("Abrir...", new ImageIcon("folder.gif"));
        menuItem1.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menuItem1.addActionListener(ventana);
        menu.add(menuItem1);
        
        menuItem = new JMenuItem("Otro", new ImageIcon("folder.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem("Otro", new ImageIcon("folder.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Build second menu in the menu bar.
        menu = new JMenu("Edición");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        menuBar.add(menu);
        
        // Añadir menú al panel
        panel.add(menuBar, BorderLayout.NORTH);
        
        
        //Creación del panel de iconos
    }


    public JPanel getPanel(){
        return panel;
    }
    
    //Acordarse de cambiar esto
    public JMenuItem getMenu(){
        return menuItem1;
    }
    
}