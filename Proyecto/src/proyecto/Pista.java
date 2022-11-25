package proyecto;
import java.awt.*;
import java.awt.Graphics;

public class Pista{
    private FigurasPista p1;
    private FigurasPista p2;
    private FigurasPista p3;
    private FigurasPista p4;
    public Pista(){
        p1 = new FigurasPista(300, 50, 150, 80);
        p2 = new FigurasPista(600, 400, 150, 80);
        p3 = new FigurasPista(300, 400, 150, 80);
        p4 = new FigurasPista(600, 50, 150, 80);
    }
     
     public void paint(Graphics g){
         p1.paint(g, 1);
         p2.paint(g, 2);
         p3.paint(g, 3);
         p4.paint(g, 4);
    }
}
