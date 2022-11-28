package proyecto;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Pista{
    private FigurasPista p1;
    
    private FigurasPista p2;
    private FigurasPista p3;
    private FigurasPista p4;
    private FigurasPista p5;
    private FigurasPista p6;
    private FigurasPista p7;
    
    private FigurasPista p8;
    
    private FigurasPista p9;
    private FigurasPista p10;
    private FigurasPista p11;
    private FigurasPista p12;
    private FigurasPista p13;
    private FigurasPista p14;
    private FigurasPista p15;
    private FigurasPista p16;
    
    private FigurasPista p17;
    
    private FigurasPista p18;
    private FigurasPista p19;
    private FigurasPista p20;
    private FigurasPista p21;
    private FigurasPista p22;
    private FigurasPista p23;
    
    private FigurasPista p24;
    
    public Pista(){        
        p1 = new FigurasPista(0, 100, 80, 40);
        p2 = new FigurasPista(80, 100, 80, 40);
        p3 = new FigurasPista(160, 100, 80, 40);
        p4 = new FigurasPista(240, 100, 80, 40);
        p5 = new FigurasPista(320, 100, 80, 40);
        p6 = new FigurasPista(400, 100, 80, 40);
        p7 = new FigurasPista(480, 100, 80, 40);
        p8 = new FigurasPista(560, 100, 80, 40);
        p9 = new FigurasPista(560+40, 180, 80, 40);
        p10 = new FigurasPista(560+40, 260, 80, 40);
        p11 = new FigurasPista(560+40, 340, 80, 40);
        p12 = new FigurasPista(0, 180, 80, 40);
        p13 = new FigurasPista(0, 260, 80, 40);
        p14 = new FigurasPista(0, 340, 80, 40);
        p15 = new FigurasPista(0, 420, 80, 40);
        p16 = new FigurasPista(80, 460, 80, 40);
        p17 = new FigurasPista(160, 460, 80, 40);
        p18 = new FigurasPista(240, 460, 80, 40);
        p19 = new FigurasPista(320, 460, 80, 40);
        p20 = new FigurasPista(400, 460, 80, 40);
        p21 = new FigurasPista(480, 460, 80, 40);
        p22 = new FigurasPista(600, 420, 80, 40);
    }
     
     public void paint(Graphics g, JPanel panel){
        //Pista1(rectangular):
        p1.paint(g, 1, panel);
        p2.paint(g, 10, panel);
        p3.paint(g, 10, panel);
        p4.paint(g, 10, panel);
        p5.paint(g, 10, panel);
        p6.paint(g, 10, panel);
        p7.paint(g, 10, panel);
        p8.paint(g, 3, panel);
        p9.paint(g, 9, panel);
        p10.paint(g, 9, panel);
        p11.paint(g, 9, panel);
        p12.paint(g, 9, panel);
        p13.paint(g, 9, panel);
        p14.paint(g, 9, panel);
        p15.paint(g, 2, panel);
        p16.paint(g, 10, panel);
        p17.paint(g, 10, panel);
        p18.paint(g, 10, panel);
        p19.paint(g, 10, panel);
        p20.paint(g, 10, panel);
        p21.paint(g, 10, panel);
        p22.paint(g, 4, panel);
        
        
        
    }
}
