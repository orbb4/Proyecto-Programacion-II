package proyecto;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pista{
    private int x, y, ax, ly;
    private FigurasPista p1;
    private ArrayList<FigurasPista> c1;
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
    private FigurasPista p25;
    private FigurasPista p26;
    private FigurasPista p27;
    public Pista(int x, int y, int ax, int ly){  
        this.x=x;
        this.y=y;
        this.ax=ax;
        this.ly=ly;
        c1 = new ArrayList();
        /*p1 = new FigurasPista(x, y, ax, ly);
        p2 = new FigurasPista(x, y, ax, ly);
        p3 = new FigurasPista(x, y, ax, ly);
        p4 = new FigurasPista(x, y, 80, 40);
        p5 = new FigurasPista(x, y, 80, 40);
        p6 = new FigurasPista(x, y, 80, 40);
        p7 = new FigurasPista(x, y, 80, 40);
        p8 = new FigurasPista(x, 100, 80, 40);
        p9 = new FigurasPista(x, 180, 80, 40);
        p10 = new FigurasPista(x, 260, 80, 40);*/
        
        p1 = new FigurasPista(0, 200, 80, 40);
        p2 = new FigurasPista(80, 200, 80, 40);
        p3 = new FigurasPista(160, 200, 80, 40);
        p4 = new FigurasPista(240, 200, 80, 40);
        p5 = new FigurasPista(320, 200, 80, 40);
        p6 = new FigurasPista(400, 200, 80, 40);
        p7 = new FigurasPista(480, 200, 80, 40);
        p8 = new FigurasPista(560, 200, 80, 40);
        p9 = new FigurasPista(560+40, 280, 80, 40);
        p10 = new FigurasPista(560+40, 360, 80, 40);
        p11 = new FigurasPista(560+40, 440, 80, 40);
        p12 = new FigurasPista(0, 280, 80, 40);
        p13 = new FigurasPista(0, 360, 80, 40);
        p14 = new FigurasPista(0, 440, 80, 40);
        p15 = new FigurasPista(0, 520, 80, 40);
        p16 = new FigurasPista(80, 560, 80, 40);
        p17 = new FigurasPista(160, 560, 80, 40);
        p18 = new FigurasPista(240, 560, 80, 40);
        p19 = new FigurasPista(320, 560, 80, 40);
        p20 = new FigurasPista(400, 560, 80, 40);
        p21 = new FigurasPista(480, 560, 80, 40);
        p22 = new FigurasPista(600, 520, 80, 40);
        
        p23 = new FigurasPista(160, 200-40, 80, 40);
        p24 = new FigurasPista(160, 200-120, 80, 40);
        
        p25 = new FigurasPista(160+160+40, 200-40, 80, 40);
        p26 = new FigurasPista(480-40, 200, 80, 40);
        p27 = new FigurasPista(520, 200, 80, 40);
    }
     
     public void paint(Graphics g, int choice, JPanel panel){
         //pista1(rectangular) con ciclo for:
         if(choice==0){
             for(int i=0; i<6; ++i){
                 //c1.get(i). setXY();
             
             }
         }
        //Pista1(rectangular):
        if(choice==1){
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
        if(choice==2){
            p1.paint(g, 1, panel);
            p2.paint(g, 10, panel);
            p23.paint(g, 4, panel);
            //p4.paint(g, 4, panel);
            p24.paint(g, 6, panel);
            p25.paint(g, 2, panel);
            //p3.paint(g, 10, panel);
            p26.paint(g, 10, panel);
            p27.paint(g, 3, panel);
            p9.paint(g, 9, panel);
            p10.paint(g, 9, panel);
            p11.paint(g, 9, panel);
            //p32.paint(g, 9, panel); //12
            //p33.paint(g, 9, panel); //13
            //p34.paint(g, 9, panel); //14
            p15.paint(g, 2, panel);
            p16.paint(g, 10, panel);
            p17.paint(g, 5, panel);
            p21.paint(g, 10, panel);
            //p4.paint(g, 6, panel);
            p22.paint(g, 4, panel);
            
        }
        
    }
}
