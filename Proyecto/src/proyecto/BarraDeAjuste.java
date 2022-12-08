package proyecto;
import java.awt.*;
import java.awt.geom.Rectangle2D;
public class BarraDeAjuste {

    // Gráficos
    private Rectangle barraRect;
    private Rectangle rectBarritas;
    private int numDeBarritas = 12;
    private int anchoBarritas = 18;
    private int bordesX = 5;
    private int bordesY = 5;   
    private int espacioEntreBarras;   
    // Ajustes
    private String nombreDelAjuste;
    private int barritasEncendidas = numDeBarritas/2; // barra parte con la mitad "encendida"
    private float variableAjustada;
    // Colores!
    // degrade de las barritas
    private Color[] colorBarritas = {new Color(37, 192, 77), new Color(52, 192, 37), new Color(81, 192, 37), new Color(110, 192, 37), new Color(137, 192, 37), new Color(160, 192, 37), new Color(183, 192, 37), new Color(192, 171, 37), new Color(192, 148, 37), new Color(192, 118, 37), new Color(192, 93, 37), new Color(192, 68, 37)};
    private Color cyan = new Color(100, 170, 155);
    private Color rojo = new Color(192, 40, 40);
    /**
     * 
     * @param barraRect el rectángulo asociado a las fronteras de la barra
     * @param nombreDelAjuste nombre que tendrá la configuracion
     * @param variableAjustada la variable que será ajustada por la barra
     */
    public BarraDeAjuste(Rectangle barraRect, String nombreDelAjuste, float variableAjustada){
        
        assert numDeBarritas <= 12: "Numero de Barritas en barra '" +  nombreDelAjuste + " excede el límite (12)";
        this.barraRect = barraRect;
        this.nombreDelAjuste = nombreDelAjuste;
        this.variableAjustada = variableAjustada;
        rectBarritas = new Rectangle(barraRect.x+bordesX*2, barraRect.y+bordesY, anchoBarritas, barraRect.height-bordesY*4);
        espacioEntreBarras = (barraRect.width - 2*bordesX - numDeBarritas*anchoBarritas)/numDeBarritas;
        System.out.println(espacioEntreBarras);
        
    }
    public float getVariableAjustada(){
        System.out.println("encendidas: " + barritasEncendidas + "num barritas:" + numDeBarritas);
        System.out.println("Valor original: " + variableAjustada);
        System.out.println("Ajustando... se obtiene: " + variableAjustada*(barritasEncendidas/numDeBarritas));
        return (float)variableAjustada*((float)barritasEncendidas/(float)numDeBarritas);
    }
    public void aumentaAjuste(){
        barritasEncendidas++;
    }
    public void decrementaAjuste(){
        barritasEncendidas--;
    }
    public void paint(Graphics g){
        
        // Obtenemos posicion x tal que el string a dibujar esté centrado :)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(g2d.getFont().deriveFont(17f));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D strRect = fontMetrics.getStringBounds(nombreDelAjuste, g2d);
        int strRectX = (barraRect.width - (int)strRect.getWidth())/2 + barraRect.x;
        int strRectY = barraRect.y - bordesY*2;  
        g.setColor(cyan);      
        g2d.drawString(nombreDelAjuste, strRectX, strRectY);
        // cuadrados para incrementar/decrementar el valor de ajuste:
        // deberia ser un triangulo apuntando a la izquierda
        g.fillRect( barraRect.x - barraRect.height - espacioEntreBarras*2, barraRect.y, barraRect.height, barraRect.height);     
        // deberia ser un triangulo apuntando a la derecha
        g.setColor(rojo);
        g.fillRect(barraRect.x + espacioEntreBarras*2 + barraRect.width, barraRect.y, barraRect.height, barraRect.height);
        
        // Barra
        g.setColor(Color.WHITE);
        g.fillRect(barraRect.x, barraRect.y, barraRect.width, barraRect.height);
        
        // Barritas
        g.setColor(cyan);
        for(int i = 0; i < numDeBarritas; i++){
            if(i >= barritasEncendidas){
                g.setColor(cyan);
            }else{
                g.setColor(colorBarritas[i]);
            }          
            g.fillRect(rectBarritas.x+ i*(espacioEntreBarras + anchoBarritas), rectBarritas.y+bordesY, rectBarritas.width, rectBarritas.height);
        }
    }
}
