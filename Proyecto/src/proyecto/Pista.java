package proyecto;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pista{
    private int x, y, ax, ly;
    private FigurasPista p1;
    private ArrayList<FigurasPista> c1;
    public Pista(int x, int y, int ax, int ly){  
        /*x=0;
        y=0;*/
        this.x=x;
        this.y=y;
        this.ax=ax;
        this.ly=ly;
        c1 = new ArrayList();
        p1 = new FigurasPista(0, 0, ax, ly); //p1 = new FigurasPista(0, 0, 80, 40);


    }
    
    public void paint(Graphics g, int choice, JPanel panel){
        //pista1(rectangular) con ciclo for:
        if(choice==0){
            int d=x+2*ly;
            int b= y+2*ly;
            int c=y+2*ly;;
            int a=x+2*ly;
            for(int i=0; i<22; ++i){
                if(i<6){
                    c1.add(i, p1);
                    c1.get(i).setXY(d,y);
                    c1.get(i).paint(g, 10, panel);
                    d=d+ax;
                }
                if(i>=6 && i<12){
                    c1.add(i, p1);
                    c1.get(i).setXY(a,y+3*ax+2*ly+ly);
                    c1.get(i).paint(g, 10, panel);
                    a=a+ax;
                    
                }
                if(i>=12 && i<15){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+6*ax+2*ly+ly,b);
                    c1.get(i).paint(g, 9, panel);
                    b=b+ax;
                }
                if(i>=15 && i<18){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,c);
                    c1.get(i).paint(g, 9, panel);
                    c=c+ax;
                    
                }
                if(i==18){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,y);
                    c1.get(i).paint(g, 1, panel);
                }
                if(i==19){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+6*ax+2*ly,y);
                    c1.get(i).paint(g, 3, panel);
                }
                if(i==20){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,y+3*ax+2*ly);
                    c1.get(i).paint(g, 2, panel);
                }
               if(i==21){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+6*ax+2*ly+ly,y+3*ax+2*ly);
                    c1.get(i).paint(g, 4, panel);
                }
                
            }
        
        }
        if(choice==1){
        
        }
    }
     /*public void paint(Graphics g, int choice,JPanel panel){
         
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
        
    }*/
}
