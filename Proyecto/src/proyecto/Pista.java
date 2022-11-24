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
     public void paint(Graphics g){
        /* g.setColor(colorBorde); //se asigna color al borde
         g.drawRect(x, y, a, a);
         g.setColor(colorFondo);//se asigna color al fondo
         g.fillRect(x, y, a, l);
         //g.drawImage(nombreImagen, x, y, this); //dibujar imagen sobre el polígono :0*/
         
    }
}

class PistaRecta extends Pista{
    //se puede variar entre 2 rectángulos 
    private int[] rect;
    PistaRecta(){
        super(500, 400, 200, 100);
    }
    public void paint(Graphics g){
        //super.paint(g, Color.orange, Color.white);
        
    }

}
class PistaConDobleOpcion extends Pista{
    PistaConDobleOpcion(){
        super(500, 400, 200, 100);
        this.setLayout(null);
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(600, 400, 50, 100);
        /*cómo dibjar un triángulo:
        se utilizan dos vectores de la forma int [] nombre;, ejemplo
               int [] vx1 = {a, b, c};
               int [] vy1 = {d, e, f};
        donde: 
                (a,d) es el pimer punto
                (b,e) es el segundo punto
                (c,f) es el tercer punto
        */
        g.setColor(Color.RED);
        int [] vx1 = {625, 650, 600};
        int [] vy1 = {350, 400, 400};
        g.fillPolygon (vx1, vy1, 3);
        
        g.setColor(Color.RED);
        int [] vx2 = {600, 625, 575};
        int [] vy2 = {400, 350, 350};
        g.fillPolygon (vx2, vy2, 3);
        
        g.setColor(Color.RED);
        int [] vx3 = {650, 675, 625};
        int [] vy3 = {400, 350, 350};
        g.fillPolygon (vx3, vy3, 3);
        
        g.setColor(Color.RED);
        int [] vx4 = {600, 625, 575};
        int [] vy4 = {300, 350, 350};
        g.fillPolygon (vx4, vy4, 3);
        
        g.setColor(Color.RED);
        int [] vx5 = {650, 675, 625};
        int [] vy5 = {300, 350, 350};
        g.fillPolygon (vx5, vy5, 3);
        
        g.setColor(Color.RED);
        int [] vx6 = {575, 600, 550};
        int [] vy6 = {350, 300, 300};
        g.fillPolygon (vx6, vy6, 3);
        
        g.setColor(Color.RED);
        int [] vx7 = {675, 700, 650};
        int [] vy7 = {350, 300, 300};
        g.fillPolygon (vx7, vy7, 3);
        
        g.setColor(Color.RED);
        g.fillRect(550, 200, 50, 100);
        
        g.setColor(Color.RED);
        g.fillRect(550, 200, 50, 100);
        
        g.setColor(Color.RED);
        g.fillRect(650, 200, 50, 100);
    }

    private void setLayout(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
        g.setColor(Color.RED);
        g.fillRect(600, 400, 50, 100);
cómo dibjar un triángulo:
            se utilizan dos vectores de la forma int [] nombre;, ejemplo
               int [] vx1 = {a, b, c};
               int [] vy1 = {d, e, f};
        donde: 
                (a,d) es el pimer punto
                (b,e) es el segundo punto
                (c,f) es el tercer punto
        
        g.setColor(Color.RED);
        int [] vx1 = {625, 650, 600};
        int [] vy1 = {350, 400, 400};
        g.fillPolygon (vx1, vy1, 3);
        
        g.setColor(Color.RED);
        int [] vx2 = {600, 625, 575};
        int [] vy2 = {400, 350, 350};
        g.fillPolygon (vx2, vy2, 3);
        
        g.setColor(Color.RED);
        int [] vx3 = {650, 675, 625};
        int [] vy3 = {400, 350, 350};
        g.fillPolygon (vx3, vy3, 3);
        
        g.setColor(Color.RED);
        int [] vx4 = {600, 625, 575};
        int [] vy4 = {300, 350, 350};
        g.fillPolygon (vx4, vy4, 3);
        
        g.setColor(Color.RED);
        int [] vx5 = {650, 675, 625};
        int [] vy5 = {300, 350, 350};
        g.fillPolygon (vx5, vy5, 3);
        
        g.setColor(Color.RED);
        int [] vx6 = {575, 600, 550};
        int [] vy6 = {350, 300, 300};
        g.fillPolygon (vx6, vy6, 3);
        
        g.setColor(Color.RED);
        int [] vx7 = {675, 700, 650};
        int [] vy7 = {350, 300, 300};
        g.fillPolygon (vx7, vy7, 3);
        
        g.setColor(Color.RED);
        g.fillRect(550, 200, 50, 100);
        
        g.setColor(Color.RED);
        g.fillRect(550, 200, 50, 100);
        
        g.setColor(Color.RED);
        g.fillRect(650, 200, 50, 100);
        
        /*intento de dibujar un rombo :)
        g.setColor(Color.MAGENTA);
        int[] vx1 = {600,625,675,650};
        int[] vx2 = {400,350,350,400};
        g.fillPolygon(vx1, vx2, 4);*/
        
        /*//intento de dibujar pista con forma: "Y"
        g.setColor(Color.MAGENTA);
        int[] vx1 = {600, 600, 575, 550, 550, 600, 600, 625, 650, 650, 700, 700, 650, 650};
        int[] vx2 = {300, 400, 350, 300, 200, 200, 300, 350, 300, 200, 200, 300, 400, 300};
        g.fillPolygon(vx1, vx2, 14); 
         //sale mal :( */
        
       
        /*sale bien, media curva
        g.setColor(Color.MAGENTA);
        int[] vx1 = {600, 550, 550, 575, 600, 625, 600};
        int[] vx2 = {200, 200, 300, 350, 400, 350, 300};
        g.fillPolygon(vx1, vx2, 7);*/
        
        /*dibuja lo mismo que el polígono anterior pero con un punto menos
        g.setColor(Color.MAGENTA);
        int[] vx1 = {600, 550, 550, 600, 625, 600};
        int[] vx2 = {200, 200, 300, 400, 350, 300};
        g.fillPolygon(vx1, vx2, 6);
      
        
      
        
        
    }
}
*/