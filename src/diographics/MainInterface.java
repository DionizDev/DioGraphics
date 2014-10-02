/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fran
 */
public final class MainInterface extends JFrame implements ActionListener{
    
    //private JFrame ventana;
    private UpToolBar menu;
    private InfoBar infobar;
    private Desktop desktop;
    
    public MainInterface(String name){
        this.createInterface(name);
    }
    
    // Crea la interfaz principal
    public void createInterface(String name){
        
       // ventana = new JFrame(name);     // Frame principal
        menu = new UpToolBar(this);         // Barra superior
        infobar = new InfoBar();        // Menú derecho
        desktop = new Desktop();        // Escritorio
        
        // Propiedades
        this.setName(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Componentes
        this.getContentPane().add(menu.getPanel(), BorderLayout.PAGE_START);
        this.getContentPane().add(desktop);
        this.getContentPane().add(infobar.getPanel(), BorderLayout.EAST);
        
        
        this.pack();
        this.setVisible(true);
    }
    
    public JFrame getVentana(){
        return this;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        final JFileChooser fc = new JFileChooser();
        BufferedImage imagen=null;
        
        fc.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        fc.setFileFilter(filtroImagen);
        
        if (e.getSource() == menu.getMenu()) {
            int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    imagen = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                desktop.createFrame(file.getName(), imagen);
            }
       }
        
    }

}
