package proyecto;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class Ruedas {
    /*
    private int distanciaRuedasY; // distancia entre las ruedas eje y
    private int distanciaRuedasX; // distancia entre las ruedas eje x
*/
    private Rectangle autoRect;
    // deberia tener como argumento una instancia de auto
    public Ruedas(Rectangle r/*, int distanciaRuedasY, int distanciaRuedasX*/){
        autoRect = r;
        /*
        this.distanciaRuedasY = distanciaRuedasY;
        this.distanciaRuedasX = distanciaRuedasX;
*/
    }
    public void paint(Graphics g){
        int[] size = {10, 25};
        Graphics2D g2d = (Graphics2D)g;        
        AffineTransform tran = g2d.getTransform();
        AffineTransform originalTran  =  g2d.getTransform();
        g2d.setColor(Color.GRAY);   
        // rueda esquina superior izquierda
        Rectangle ruedaSI = new Rectangle(autoRect.x-size[0], autoRect.y+size[0], size[0], size[1]);
        tran.rotate(Math.toRadians(10), autoRect.x-size[0], autoRect.y+size[0]);
        g2d.setTransform(tran);
        g2d.draw(ruedaSI);
        g2d.fill(ruedaSI);
        /*
        g.setColor(Color.GRAY);       
        // rueda esquina superior derecha
        g2d.fillRect(autoRect.x+autoRect.width, autoRect.y+size[0], size[0], size[1]);
        // rueda esquina inferior izquierda
        g2d.fillRect(autoRect.x-size[0], autoRect.y+autoRect.width+size[0], size[0], size[1]);
        // rueda esquina inferior derecha
        g2d.fillRect(autoRect.x+autoRect.width, autoRect.y+autoRect.width+size[0], size[0], size[1]);
*/
    }
    
}
