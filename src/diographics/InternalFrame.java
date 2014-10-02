/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diographics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author fran
 */
public class InternalFrame extends JInternalFrame{
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public InternalFrame(String name, BufferedImage imagen) {
        super(name + "     (Imagen " + (++openFrameCount) + ")",
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...
        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        
        this.setSize(300, 300);
        
        JLabel label = new JLabel();
        label.setSize(500, 500);
        label.setIcon(new ImageIcon(imagen));
        this.add(label);
        
        this.crearHistograma(imagen);
    }
    
    public void crearHistograma(BufferedImage imagen){
        Color colorAuxiliar;
        
        int histogramaReturn[]=new int[256];
        //Recorremos la imagen
        for( int i = 0; i < imagen.getWidth(); i++ ){
            for( int j = 0; j < imagen.getHeight(); j++ ){
                //Obtenemos color del píxel actual
                colorAuxiliar=new Color(imagen.getRGB(i, j));
                
                histogramaReturn[colorAuxiliar.getAlpha()]+=1;
            }
        }
    }
}
