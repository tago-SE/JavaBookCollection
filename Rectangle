import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author fauzianordlund
 */
public class Rectangle extends FillableShape{
    private double width,height;
    public Rectangle(double x, double y, Color color, boolean filled) {
        super(x, y, color, filled);
    }
    public Rectangle(double x, double y, Color color, boolean filled,double width,double height) {
        super(x, y, color, filled);
        this.width = width;
        this.height = height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }
    @Override
    public void paint(GraphicsContext gc) {
       gc.setFill(super.getColor());
       gc.setStroke(super.getColor());
        if(super.isFilled()){
           gc.fillRect(super.getX(),super.getY(),width,height);
        }
        else{
           gc.strokeRect(super.getX(),super.getY(),width,height);
        }
    }
    @Override
     public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
          if (boxX < 0) {
            super.setVelocity(Math.abs(super.getDx()), super.getDy());
        }
          else if (super.getX() + width > boxWidth) {
            super.setVelocity(-Math.abs(super.getDx()),super.getDy());
        }
          if (boxY < 0){
              super.setVelocity(super.getDx(), Math.abs(super.getDy()));
          }
          else if (super.getY() + height > boxHeight){
              super.setVelocity(super.getDx(), -Math.abs(super.getDy()));
          }
            
     }
        
    
   
}
