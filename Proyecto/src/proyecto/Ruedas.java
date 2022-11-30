package proyecto;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
public class Ruedas {
    // Angulos de las ruedas. En grados.
    private float anguloSI; // superior izquierda
    private float anguloSD; // superior derecha
    private float anguloII; // inferior izquierda
    private float anguloID; // inferior derecha
    
    private Rectangle autoRect;
    // deberia tener como argumento una instancia de auto
    public Ruedas(Rectangle r){
        autoRect = r;
        anguloSI = anguloSD = anguloII = anguloID = 0;
    }

    
/**
 * Este método establece el angulo de las ruedas. 
 * <p>Se puede cambiar el ángulo de múltiples ruedas a la vez. Al hacerlo todas
 * las elegidas quedaran con el mismo ángulo.
 * @param angulo el angulo en grados al que se cambiaran las ruedas seleccionadas
 * @param cambiaSI cuando su valor es true, cambia el angulo de la rueda superior izquierda al del parametro angulo
 * @param cambiaSD cuando su valor es true, cambia el angulo de la rueda superior derecha al del parametro angulo
 * @param cambiaII cuando su valor es true, cambia el angulo de la rueda inferior izquierda al del parametro angulo
 * @param cambiaID cuando su valor es true, cambia el angulo de la rueda inferior derecha al del parametro angulo
 */
    public void setAngulo(float angulo, boolean cambiaSI, boolean cambiaSD, boolean cambiaII, boolean cambiaID){
        if(cambiaSI){
            anguloSI = angulo;
        }
        if(cambiaSD){
            anguloSD = angulo;
        }
        if(cambiaII){
            anguloII = angulo;
        }
        if(cambiaID){
            anguloID = angulo;
        }       
    }
    public float getAngle(){
        return anguloII;
    }
    public void setAutoRect(Rectangle r){
        autoRect = r;
    }
    public void paint(Graphics g){
        int[] size = {12, 25};
        Graphics2D g2d = (Graphics2D)g;        
        AffineTransform tran = g2d.getTransform();
        g2d.setColor(Color.GRAY);   
        Rectangle ruedaSI = new Rectangle(autoRect.x-size[0], autoRect.y+size[0], size[0], size[1]);
        Rectangle ruedaSD = new Rectangle(autoRect.x+autoRect.width, autoRect.y+size[0], size[0], size[1]);
        Rectangle ruedaII = new Rectangle(autoRect.x-size[0], autoRect.y+autoRect.width+size[0], size[0], size[1]);
        Rectangle ruedaID = new Rectangle(autoRect.x+autoRect.width, autoRect.y+autoRect.width+size[0], size[0], size[1]);
        Rectangle[] ruedas = {ruedaSI, ruedaSD, ruedaII, ruedaID};
        float[] angulos = {anguloSI, anguloSD, anguloII, anguloID};
        for(int i = 0; i < 4; i++){
            tran.rotate(Math.toRadians(angulos[i]), ruedas[i].x + ruedas[i].width/2, ruedas[i].y + ruedas[i].height/2);
            g2d.setTransform(tran);
            g2d.draw(ruedas[i]); 
            g2d.fill(ruedas[i]);
            tran.rotate(Math.toRadians(-angulos[i]), ruedas[i].x + ruedas[i].width/2, ruedas[i].y + ruedas[i].height/2);         
        }
        g2d.setTransform(tran);

    }
    
}
