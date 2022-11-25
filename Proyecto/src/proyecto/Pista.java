package proyecto;
import java.awt.*;
import java.awt.Graphics;

public class Pista{
    private FigurasPista p1;
    private FigurasPista p2;
    private FigurasPista p3;
    private FigurasPista p4;
    private FigurasPista p5;
    private FigurasPista p6;
    private FigurasPista p7;
    private FigurasPista p8;
    public Pista(){
        p1 = new FigurasPista(0, 0, 75, 40);
        p2 = new FigurasPista(100, 0, 75, 40);
        p3 = new FigurasPista(200, 0, 75, 40);
        p4 = new FigurasPista(350, 0, 75, 40);
        p5 = new FigurasPista(0, 300, 75, 40);
        p6 = new FigurasPista(400, 300, 75, 40);
        p7 = new FigurasPista(800, 300, 75, 40);
        p8 = new FigurasPista(1200, 300, 75, 40);

    }
     
     public void paint(Graphics g){
         p1.paint(g, 1);
         p2.paint(g, 2);
         p3.paint(g, 3);
         p4.paint(g, 4);
         p5.paint(g, 5);
         p6.paint(g, 6);
         p7.paint(g, 7);
         p8.paint(g, 8);
    }
}
