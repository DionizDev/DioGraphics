/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author fran
 */
public class Desktop extends JDesktopPane{
    
    InternalFrame frame;
    boolean frameActivo;
    
    public Desktop(){
        this.setBackground(Color.gray);
    }
    
    protected void createFrame(String name, BufferedImage imagen, InfoBar infobar) {
        //Crea el internal frame
        frame = new InternalFrame(name, imagen, infobar);
        frame.setVisible(true);
        this.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
        
        frameActivo = false;
    }
    
    protected void crearHistograma(JPanel panel){
        //Crea el histograma
        DrawGraphics draw = new DrawGraphics();
        
    }
    
    public boolean getFrameActivo(){
        return frameActivo;
    }
}
