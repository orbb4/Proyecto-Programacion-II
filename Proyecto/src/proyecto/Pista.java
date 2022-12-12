package proyecto;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 * 
 * Una pista de apariencia configurable que cuenta con colliders
 */
public class Pista{
    private int x, y, ax, ly;
    private FigurasPista p1;
    private ArrayList<FigurasPista> c1;
    private ArrayList<Rectangle> colliders;
    private int ANCHO_CIRCUITO = 960;
    private int LARGO_CIRCUITO = 700;
    /**
     * El constructor de la pista
     * @param x posición x de la pista
     * @param y posición y de la pista
     * @param ly ancho de las piezas
     */
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
    
    
    /**
     * Obtiene los colliders asociados al tipo de pista pasado como argumento
     * @param tipoPista numero que identifica la pista de la que se obtendran los colliders
     * @return colliders asociados al tipo de pista elegido
     */
    public ArrayList<Rectangle> getColliders(int tipoPista){
        ArrayList<Rectangle> collidersCurvas = new ArrayList();
        float anchoBordeSoleras = (ly/17)*2;
        collidersCurvas.addAll(colliders);
        switch(tipoPista){
            case 0:
                //curva SI:
                collidersCurvas.add(new Rectangle(x, y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //colliders.add(new Rectangle(x+15*(ly/17), y+15*(ly/17),(int)anchoBordeSoleras, (int)anchoBordeSoleras));
               
                //curva II:
                collidersCurvas.add(new Rectangle(x, y+2*ax+2*ly+ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+2*ax+2*ly+ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //colliders.add(new Rectangle(x+15*(ly/17), y,(int)anchoBordeSoleras, (int)anchoBordeSoleras));
 
                
                //curva SD:
                collidersCurvas.add(new Rectangle(x+4*ax+2*ly+ly+15*(ly/17), y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+4*ax+2*ly+ly, y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                
                //curva ID:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+6*ly+ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+6*ly+ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //colliders.add(new Rectangle(x+11*ly, y+6*ly+ly,(int)anchoBordeSoleras, (int)anchoBordeSoleras));
                break;
            case 1:
                //curva 1:
                collidersCurvas.add(new Rectangle(x+3*ly, y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+3*ly+anchoBordeSoleras), y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 2:
                collidersCurvas.add(new Rectangle(x+8*ly+15*(ly/17), y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+8*ly, y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 3:
                collidersCurvas.add(new Rectangle(x, y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+3*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 4:
                collidersCurvas.add(new Rectangle(x+3*ly+15*(ly/17), y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+3*ly, y+3*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 5:
                collidersCurvas.add(new Rectangle(x+8*ly, y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+8*ly+anchoBordeSoleras), y+3*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 6:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+3*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 7:
                collidersCurvas.add(new Rectangle(x+3*ly, y+5*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+3*ly+anchoBordeSoleras), y+5*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 8:
                collidersCurvas.add(new Rectangle(x+8*ly+15*(ly/17), y+5*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+8*ly, y+5*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 9:
                collidersCurvas.add(new Rectangle(x, y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 10:
                collidersCurvas.add(new Rectangle(x+3*ly+15*(ly/17), y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+3*ly, y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 11:
                collidersCurvas.add(new Rectangle(x+8*ly, y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+8*ly+anchoBordeSoleras), y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva 12:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                break;
                
            case 2:
                //curva SI1:
                collidersCurvas.add(new Rectangle(x+5*ly, y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+5*ly+anchoBordeSoleras), y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SI2:
                collidersCurvas.add(new Rectangle(x, y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+3*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SI3:
                collidersCurvas.add(new Rectangle(x+6*ly, y+5*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+6*ly+anchoBordeSoleras), y+5*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SI4:
                collidersCurvas.add(new Rectangle(x, y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SD1:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SD2:
                collidersCurvas.add(new Rectangle(x+5*ly+15*(ly/17), y+3*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+5*ly, y+3*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SD3:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+5*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+5*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva SD4:
                collidersCurvas.add(new Rectangle(x+6*ly+15*(ly/17), y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+6*ly, y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras)); 
                break;
                
            case 3:
                //curva 1:
                collidersCurvas.add(new Rectangle(x, y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva2:
                collidersCurvas.add(new Rectangle(x+3*ly+15*(ly/17), y,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+3*ly, y,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva3:
                collidersCurvas.add(new Rectangle(x+6*ly, y+ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+6*ly+anchoBordeSoleras), y+ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva4:
                collidersCurvas.add(new Rectangle(x+9*ly+15*(ly/17), y+ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+9*ly, y+ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva5:
                collidersCurvas.add(new Rectangle(x+3*ly, y+4*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+3*ly+anchoBordeSoleras), y+4*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva6:
                collidersCurvas.add(new Rectangle(x+6*ly+15*(ly/17), y+4*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+6*ly, y+4*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva7:
                collidersCurvas.add(new Rectangle(x+9*ly, y+4*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+9*ly+anchoBordeSoleras), y+4*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva8:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+4*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+4*ly,(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva9:
                collidersCurvas.add(new Rectangle(x, y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle((int)(x+anchoBordeSoleras), y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                //curva10:
                collidersCurvas.add(new Rectangle(x+11*ly+15*(ly/17), y+8*ly,(int)anchoBordeSoleras, ly));
                collidersCurvas.add(new Rectangle(x+11*ly, y+8*ly+15*(ly/17),(int)(ly-anchoBordeSoleras), (int)anchoBordeSoleras));
                break;
            
            
           
        }
        System.out.println(colliders.size());
        return collidersCurvas;
        
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
