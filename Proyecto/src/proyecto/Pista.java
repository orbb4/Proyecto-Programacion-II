package proyecto;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pista{
    private int x, y, ax, ly;
    private FigurasPista p1;
    private ArrayList<FigurasPista> c1;
    public Pista(int ax, int ly){  
        x=0;
        y=0;
        this.ax=ax;
        this.ly=ly;
        c1 = new ArrayList();
        p1 = new FigurasPista(0, 200, 80, 40);

    }
     
    public void paint(Graphics g, int choice, JPanel panel){
        //pista1(rectangular) con ciclo for:
        if(choice==0){
            y=200;
            x=80;
            int b = 280;
            int c=280;
            int a=80;
            for(int i=0; i<22; ++i){
                if(i<6){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,200);
                    c1.get(i).paint(g, 10, panel);
                    x=x+80;
                }
                if(i>=6 && i<12){
                    c1.add(i, p1);
                    c1.get(i).setXY(a,560);
                    c1.get(i).paint(g, 10, panel);
                    a=a+80;
                    
                }
                if(i>=12 && i<15){
                    c1.add(i, p1);
                    c1.get(i).setXY(600,b);
                    c1.get(i).paint(g, 9, panel);
                    b=b+80;
                }
                if(i>=15 && i<18){
                    c1.add(i, p1);
                    c1.get(i).setXY(0,c);
                    c1.get(i).paint(g, 9, panel);
                    c=c+80;
                    
                }
                if(i==18){
                    c1.add(i, p1);
                    c1.get(i).setXY(0,200);
                    c1.get(i).paint(g, 1, panel);
                }
                if(i==19){
                    c1.add(i, p1);
                    c1.get(i).setXY(560,200);
                    c1.get(i).paint(g, 3, panel);
                }
                if(i==20){
                    c1.add(i, p1);
                    c1.get(i).setXY(0,520);
                    c1.get(i).paint(g, 2, panel);
                }
               if(i==21){
                    c1.add(i, p1);
                    c1.get(i).setXY(600,520);
                    c1.get(i).paint(g, 4, panel);
                }
                
                
                
            }
                //c1.get(i).setXY();
        }
    }
     /*public void paint(Graphics g, int choice,JPanel panel){
         
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
        
    }*/
}
