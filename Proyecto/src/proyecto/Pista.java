package proyecto;
import java.awt.*;
import java.awt.Graphics;
// auto vector dirección (0,-1)
 abstract class Pista {
     private int a,l; //ancho y largo de la pista
     private int x,y; //ubicación en la pantalla, todos deben tener eso
     public Pista(int x, int y, int l, int a){ //podría ir en el constructor un rectángulo
         this.x=x;
         this.y=y;
         this.a=a;
         this.l=l;
     }
     public void paint(Graphics g, Color colorBorde, Color colorFondo){              
         g.setColor(colorBorde); //se asigna color al borde
         g.drawRect(x, y, a, a);
         g.setColor(colorFondo);//se asigna color al fondo
         g.fillRect(x, y, a, l);
         //g.drawImage(nombreImagen, x, y, this); //dibujar imagen sobre el polígono :0
         
    }
}

class PistaRecta extends Pista{
    //se puede variar entre 2 rectángulos 
    private int[] rect;
    PistaRecta(){
        super(500, 400, 200, 100);
    }
    public void paint(Graphics g){
        super.paint(g, Color.orange, Color.white);
        
    }

}