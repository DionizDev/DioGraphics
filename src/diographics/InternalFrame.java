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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 *
 * @author fran
 */
public class InternalFrame extends JInternalFrame{
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    InfoBar infobar;
    BufferedImage image;

    public InternalFrame(String name, BufferedImage imagen, InfoBar inf) {
        super(name + "     (Imagen " + (++openFrameCount) + ")",
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        
        this.image = imagen;
        this.infobar = inf;
        
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...
        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        
        this.setSize(300, 300);
        
        JLabel label = new JLabel();
        label.setSize(500, 500);
        label.setIcon(new ImageIcon(image));
        this.add(label);
        
        // Listado de Listener para los internalFrame
        InternalFrameListener listener = new InternalFrameListener() {
              public void internalFrameActivated(InternalFrameEvent e) {
                crearHistograma();
                //Poner métodos de actualizar InfoBar
                dumpInfo("Activated", e);
              }

              public void internalFrameClosed(InternalFrameEvent e) {
                dumpInfo("Closed", e);
              }

              public void internalFrameClosing(InternalFrameEvent e) {
                dumpInfo("Closing", e);
              }

              public void internalFrameDeactivated(InternalFrameEvent e) {
                dumpInfo("Deactivated", e);
              }

              public void internalFrameDeiconified(InternalFrameEvent e) {
                dumpInfo("Deiconified", e);
              }

              public void internalFrameIconified(InternalFrameEvent e) {
                dumpInfo("Iconified", e);
              }

              public void internalFrameOpened(InternalFrameEvent e) {
                dumpInfo("Opened", e);
              }

              private void dumpInfo(String s, InternalFrameEvent e) {
                System.out.println("Source: " + e.getInternalFrame().getName()
                    + " : " + s);
              }
        };
        
        //Añado los listener en el internalFrame
        this.addInternalFrameListener(listener);
        //this.crearHistograma();
    }
    
    public void crearHistograma(){
        Color colorAuxiliar;
        
        int histogramaAbsoluto[][]=new int[5][256];
        int histogramaAcumulativo[][]=new int[5][256];
        //Recorremos la imagen
        for( int i = 0; i < image.getWidth(); i++ ){
            for( int j = 0; j < image.getHeight(); j++ ){
                //Obtenemos color del píxel actual
                colorAuxiliar=new Color(image.getRGB(i, j));
                
                int red = colorAuxiliar.getRed();
                int green = colorAuxiliar.getGreen();
                int blue = colorAuxiliar.getBlue();
                
                int gray = (int)((0.222 * red) + (0.707 * green) + (0.071 * blue));
                
               // histogramaAbsoluto[0][colorAuxiliar.getRed()]+=1;
              //  histogramaAbsoluto[1][colorAuxiliar.getGreen()]+=1;
               // histogramaAbsoluto[2][colorAuxiliar.getBlue()]+=1;
                
                //Sumamos al histograma absoluto en la posicion del gris
                histogramaAbsoluto[3][gray]+=1;
                
            }
        }
        
        //Establecemos el histograma acumulado
        for(int i=0; i<histogramaAbsoluto[3].length; i++){
            if(i==0){
                histogramaAcumulativo[3][i] = histogramaAbsoluto[3][i];
            }
            else{
                histogramaAcumulativo[3][i] =  histogramaAbsoluto[3][i] + histogramaAcumulativo[3][i-1];
            }
        }
        
        //Dibujamos el histograma
        DrawGraphics draw = new DrawGraphics();
        draw.dibujarHistograma(histogramaAbsoluto[3], infobar.getAbsolutHistogramPanel(), Color.BLUE);
        draw.dibujarHistograma(histogramaAcumulativo[3], infobar.getAcumHistogramPanel(), Color.RED);
    }

}
