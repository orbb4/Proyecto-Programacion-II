package proyecto;
import java.awt.*;
import java.awt.geom.Rectangle2D;
/** Una barra que puede ser ajustada para establecer el valor de una variable
 * 
*/
public class BarraDeAjuste {

    // Gráficos
    private Rectangle barraRect;
    private Rectangle rectBarritas;
    Polygon triangulo1 = new Polygon();
    Polygon triangulo2 = new Polygon();
    boolean triangulo1Clicked = false;
    boolean triangulo2Clicked = false;
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
    private Color blanco = new Color(240, 240, 255);
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
        // triangulos dibujados a los lados
        // izquierdo
        triangulo1.addPoint(barraRect.x-barraRect.height/4, barraRect.y);
        triangulo1.addPoint(barraRect.x - barraRect.height, barraRect.y + barraRect.height/2);
        triangulo1.addPoint(barraRect.x-barraRect.height/4, barraRect.y + barraRect.height);
        // derecho
        triangulo2.addPoint(barraRect.x+barraRect.height/4 + barraRect.width, barraRect.y);
        triangulo2.addPoint(barraRect.x + barraRect.height+ barraRect.width, barraRect.y + barraRect.height/2);
        triangulo2.addPoint(barraRect.x+barraRect.height/4+ barraRect.width, barraRect.y + barraRect.height);
        
    }
    /**
     * 
     * @return la variable ajustada segun lo 'llena' que esté la barra
     */
    public float getVariableAjustada(){
        System.out.println("encendidas: " + barritasEncendidas + "num barritas:" + numDeBarritas);
        System.out.println("Valor original: " + variableAjustada);
        float ratio = ((float)barritasEncendidas/(float)numDeBarritas);
        System.out.println("ratio " +ratio);
        System.out.println(variableAjustada*ratio);
        return (float)variableAjustada*ratio;
    }
    public void aumentaAjuste(){
        if(barritasEncendidas < numDeBarritas){
            barritasEncendidas++;
        }      
    }
    public void decrementaAjuste(){
        if(barritasEncendidas > 0){
            barritasEncendidas--;
        }      
    }
    /**
     * Actualiza el estado de la barra. Debería llamarse en cada frame
     * @param mouseCords actuales del mouse 
     * @param clicking true si el usuario actualmente está haciendo click
     * @return variable ajustada segun el nivel de la barra
     */
    public void actualizar(int[] mouseCords, boolean clicking){
        Rectangle mouse = new Rectangle(mouseCords[0], mouseCords[1], 1, 1);
        // revisamos si hay colision con triangulos, colision y click altera
        // las barras, solo colision crea un borde blanco alrededor de ellas
        if((mouseCords[0] <= triangulo1.getBounds2D().getMaxX()) && (mouseCords[1] <= triangulo1.getBounds2D().getMaxY() + triangulo1.getBounds().getHeight()/2) && (mouseCords[0] >= triangulo1.getBounds2D().getMaxX()- triangulo1.getBounds2D().getWidth()) && (mouseCords[1] > triangulo1.getBounds2D().getMaxY() -  triangulo1.getBounds2D().getHeight())){
            triangulo1Clicked=true;
            if(clicking){
                this.decrementaAjuste();
            }
        }else{
            triangulo1Clicked = false;
        }

        if((mouseCords[0] <= triangulo2.getBounds2D().getMaxX()) && (mouseCords[1] <= triangulo2.getBounds2D().getMaxY() + triangulo2.getBounds().getHeight()/2) && (mouseCords[0] >= triangulo2.getBounds2D().getMaxX()- triangulo2.getBounds2D().getWidth()) && (mouseCords[1] > triangulo2.getBounds2D().getMaxY() -  triangulo2.getBounds2D().getHeight())){
            triangulo2Clicked=true;
            if(clicking){
                this.aumentaAjuste();
            }
        }else{
            triangulo2Clicked = false;
        }
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
        // triangluos que incrementan/decrementan el valor de ajuste:
        // Triangulo Izquierdo
        g.fillPolygon(triangulo1);
        if(triangulo1Clicked){
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(Color.WHITE);
            g2d.drawPolygon(triangulo1);
        }
        //Triangulo Derecho
        g.setColor(rojo);
        g.fillPolygon(triangulo2);
        if(triangulo2Clicked){
            g2d.setColor(Color.WHITE);
            g2d.drawPolygon(triangulo2);
        }
        // Barra
        g.setColor(blanco);
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
