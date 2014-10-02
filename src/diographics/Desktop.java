/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JDesktopPane;

/**
 *
 * @author fran
 */
public class Desktop extends JDesktopPane{
    
    public Desktop(){
        this.setBackground(Color.gray);
    }
    
    protected void createFrame(String name, BufferedImage imagen) {
        InternalFrame frame = new InternalFrame(name, imagen);
        frame.setVisible(true);
        this.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
}
