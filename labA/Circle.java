
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Alexander Nordlund and Tiago Radaelli
 */
public class Circle extends FillableShape{
    private double diameter;

    public Circle(double x, double y, Color color, boolean filled,double diameter) {
        super(x, y, color, filled);
        this.diameter=diameter;
    }
     public Circle(double x, double y, Color color, boolean filled) {
        super(x, y, color, filled);
    }
     public double getDiameter(){
         return diameter;
     }
     public void setDiameter(double diameter){
         this.diameter=diameter;
     }
    @Override
    public void paint(GraphicsContext gc) {
       gc.setFill(super.getColor());
       gc.setStroke(super.getColor());
        if(super.isFilled()){
           gc.fillOval(super.getX(),super.getY(),diameter/2, diameter/2);
        }
        else{
           gc.strokeOval(super.getX(),super.getY(),diameter/2, diameter/2);
        }
    }
    @Override
    public void constrain(
            double CircleX, double CircleY, 
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        if (CircleX < 0) {
            super.setVelocity(Math.abs(super.getDx()), super.getDy());
        } else if (CircleX + (diameter / 2) > boxWidth) {
            super.setVelocity(-Math.abs(super.getDx()), super.getDy());
        }
        if (CircleY < 0) {
            super.setVelocity(super.getDx(), Math.abs(super.getDy()));
        } else if (CircleY +(diameter / 2)> boxHeight) {
            super.setVelocity(super.getDx(), -Math.abs(super.getDy()));
        }
    }
    
}
