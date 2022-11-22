package proyecto;
import java.awt.*;
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
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(45));
        int[] size = {10, 25};
        g.setColor(Color.GRAY);
        // rueda esquina superior izquierda
        g2d.fillRect(autoRect.x-size[0], autoRect.y+size[0], size[0], size[1]);
        // rueda esquina superior derecha
        g2d.fillRect(autoRect.x+autoRect.width, autoRect.y+size[0], size[0], size[1]);
        // rueda esquina inferior izquierda
        g2d.fillRect(autoRect.x-size[0], autoRect.y+autoRect.width+size[0], size[0], size[1]);
        // rueda esquina inferior derecha
        g2d.fillRect(autoRect.x+autoRect.width, autoRect.y+autoRect.width+size[0], size[0], size[1]);
    }
    
}
