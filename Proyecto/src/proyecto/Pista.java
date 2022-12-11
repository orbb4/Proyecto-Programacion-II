package proyecto;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pista{
    private int x, y, ax, ly;
    private FigurasPista p1;
    private ArrayList<FigurasPista> c1;
    private ArrayList<Rectangle> colliders;
    private int ANCHO_CIRCUITO = 960;
    private int LARGO_CIRCUITO = 700;
    public Pista(int x, int y, int ly){  
        int anchoBorde = 20; // qué tan gruesos son los colliders
        /*x=0;
        y=0;*/
        this.x=x;
        this.y=y;
        ax=2*ly;
        this.ly=ly;
        c1 = new ArrayList();
        p1 = new FigurasPista(0, 0, ly); //p1 = new FigurasPista(0, 0, 80, 40);
        colliders = new ArrayList();
        //Límite superior de la pista
        colliders.add(new Rectangle(0, -anchoBorde-50, ANCHO_CIRCUITO, anchoBorde));
        // Límite inferior de la pista
        colliders.add(new Rectangle(-30, LARGO_CIRCUITO+anchoBorde, ANCHO_CIRCUITO, anchoBorde)); 
        // Límite lateral izquierdo de la pista
        colliders.add(new Rectangle(-anchoBorde-30, 0, anchoBorde, LARGO_CIRCUITO)); 
        // Límite lateral derecho de la pista
        colliders.add(new Rectangle(ANCHO_CIRCUITO, 0, anchoBorde, LARGO_CIRCUITO)); 
        
    }
    
    
    
    public ArrayList<Rectangle> getColliders(int tipoPista){
        ArrayList<Rectangle> collidersCurvas = new ArrayList();
        collidersCurvas.addAll(colliders);
        switch(tipoPista){
            case 0:
                
        }
        return colliders;
        
    }
    
    public void paint(Graphics g, int choice, JPanel panel){
        //pista1(rectangular) con ciclo for:
        if(choice==0){
            int d=x+2*ly;
            int b= y+2*ly;
            int c=y+2*ly;;
            int a=x+2*ly;
            for(int i=0; i<18; ++i){
                if(i<4){
                    c1.add(i, p1);
                    c1.get(i).setXY(d,y);
                    c1.get(i).paint(g, 10, panel);
                    d=d+ax;
                }
                if(i>=4 && i<8){
                    c1.add(i, p1);
                    c1.get(i).setXY(a,y+2*ax+2*ly+ly);
                    c1.get(i).paint(g, 10, panel);
                    a=a+ax;
                    
                }
                if(i>=8 && i<10){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+4*ax+2*ly+ly,b);
                    c1.get(i).paint(g, 9, panel);
                    b=b+ax;
                }
                if(i>=10 && i<12){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,c);
                    c1.get(i).paint(g, 9, panel);
                    c=c+ax;
                    
                }
                if(i==12){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,y);
                    c1.get(i).paint(g, 1, panel);
                }
                if(i==13){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+4*ax+2*ly,y);
                    c1.get(i).paint(g, 3, panel);
                }
                if(i==14){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,y+2*ax+2*ly);
                    c1.get(i).paint(g, 2, panel);
                }
               if(i==15){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+4*ax+2*ly+ly,y+2*ax+2*ly);
                    c1.get(i).paint(g, 4, panel);
                }
            }  
        }
        if(choice==1){
            for(int i=0; i<12; ++i){
                if(i==0){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+3*ly,y);
                    c1.get(i).paint(g, 6, panel);
                }
                if(i==1){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+3*ly,y+2*ly);
                   c1.get(i).paint(g, 4, panel);
                   
                }
                if(i==2){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+3*ly);
                   c1.get(i).paint(g, 1, panel);
                }
                if(i==3){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+5*ly);
                   c1.get(i).paint(g, 9, panel);
                
                }
                if(i==4){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+7*ly);
                   c1.get(i).paint(g, 2, panel);
                
                }
                if(i==5){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+3*ly,y+7*ly);
                   c1.get(i).paint(g, 4, panel);
                
                }
                if(i==6){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+3*ly,y+5*ly);
                   c1.get(i).paint(g, 6, panel);
                
                }
                if(i==7){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+8*ly,y+7*ly);
                   c1.get(i).paint(g, 2, panel);
                
                }
                if(i==8){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+11*ly,y+7*ly);
                   c1.get(i).paint(g, 4, panel);
                
                }
                if(i==9){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+11*ly,y+5*ly);
                   c1.get(i).paint(g, 9, panel);
                
                }
                if(i==10){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+10*ly,y+3*ly);
                   c1.get(i).paint(g, 3, panel);
                
                }
                if(i==11){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+8*ly,y+2*ly);
                   c1.get(i).paint(g, 2, panel);
                
                }
            
            }   
        }
        
        if(choice==2){
            for(int i=0; i<10; ++i){
                if(i==0){
                    c1.add(i, p1);
                    c1.get(i).setXY(x+5*ly,y);
                    c1.get(i).paint(g, 13, panel);
                }
                if(i==1){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+6*ly,y+5*ly);
                   c1.get(i).paint(g, 13, panel);
                   
                }
                if(i==2){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+3*ly);
                   c1.get(i).paint(g, 7, panel);
                }
                if(i==3){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+10*ly,y);
                   c1.get(i).paint(g, 8, panel);
                
                }
                if(i==4){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+2*ly,y+3*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==5){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+2*ly,y+8*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==6){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+8*ly,y+5*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==7){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+4*ly,y+8*ly);
                   c1.get(i).paint(g, 12, panel);
                
                }
                if(i==8){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+8*ly,y);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==9){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+7*ly,y);
                   c1.get(i).paint(g, 12, panel);   
                }          
            }   
        }
        
        if(choice==3){
            for(int i=0; i<14; ++i){
                if(i==0){
                    c1.add(i, p1);
                    c1.get(i).setXY(x,y);
                    c1.get(i).paint(g, 14, panel);
                }
                if(i==1){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+3*ly,y+2*ly);
                   c1.get(i).paint(g, 11, panel);
                   
                }
                if(i==2){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+3*ly,y+3*ly);
                   c1.get(i).paint(g, 15, panel);
                }
                if(i==3){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+6*ly,y+ly);
                   c1.get(i).paint(g, 14, panel);
                
                }
                if(i==4){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+9*ly,y+3*ly);
                   c1.get(i).paint(g, 16, panel);
                
                }
                if(i==5){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+11*ly,y+7*ly);
                   c1.get(i).paint(g, 4, panel);
                
                }
                if(i==6){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+2*ly,y+8*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==7){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+4*ly,y+8*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==8){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+6*ly,y+8*ly);
                   c1.get(i).paint(g, 10, panel);
                
                }
                if(i==9){
                   c1.add(i, p1);
                   c1.get(i).setXY(x+8*ly,y+8*ly);
                   c1.get(i).paint(g, 10, panel);   
                }       
                if(i==10){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+7*ly);
                   c1.get(i).paint(g, 2, panel);   
                } 
                if(i==11){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+2*ly);
                   c1.get(i).paint(g, 9, panel);   
                } 
                if(i==12){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+4*ly);
                   c1.get(i).paint(g, 9, panel);   
                } 
                if(i==13){
                   c1.add(i, p1);
                   c1.get(i).setXY(x,y+6*ly);
                   c1.get(i).paint(g, 11, panel);   
                } 
            }   
        }
    }
}
