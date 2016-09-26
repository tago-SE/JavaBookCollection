import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author fauzianordlund
 */
public class Line extends Shape{
    private double x2;
    private double y2;
    public Line(double x, double y, Color color){
        super(x,y,color);
    }
    public Line(double x, double y, Color color,double x2,double y2){
        super(x,y,color);
        this.x2=x2;
        this.y2=y2;
    }
    public double getX2(){
        return x2;
    }
    public double getY2(){
        return y2;
    }
    public void setX2(){
        this.x2=x2;
    }
     public void setY2(){
        this.y2=y2;
    }
    @Override
    public void paint(GraphicsContext gc) {
       //  gc.setFill(super.getColor());
         gc.setStroke(super.getColor());
         gc.strokeLine(super.getX(), super.getY(), x2, y2);
    }
    @Override
     public void constrain(
            double lineX1, double lineY1, 
            double boxWidth, double boxHeight) {
          if (lineX1 < 0) {
            super.setVelocity(Math.abs(super.getDx()), super.getDy());
        }
          else if(getX2() < 0){
              super.setVelocity(Math.abs(super.getDx()), super.getDy());
          }
          if (lineY1 < 0){
              super.setVelocity(super.getDx(), Math.abs(super.getDy()));
          }
          else if(getY2() < 0){
              super.setVelocity(super.getDx(), Math.abs(super.getDy()));
          }
          if(lineX1 > boxWidth){
              super.setVelocity(-Math.abs(super.getDx()),super.getDy()); 
          }
          else if (getX2() > boxWidth){
              super.setVelocity(-Math.abs(super.getDx()),super.getDy()); 
          }
          if(lineY1 > boxHeight){
              super.setVelocity(super.getDx(),-Math.abs(super.getDy()));
          }
          else  if(getY() > boxHeight){
              super.setVelocity(super.getDx(),-Math.abs(super.getDy()));
          }
         
     }
     
    @Override
     public void move(long elapsedTimeNs) {
        super.setX(super.getX() + (super.getDx()*elapsedTimeNs) /  BILLION);
        super.setY(super.getY() + (super.getDy()*elapsedTimeNs) /  BILLION);
        x2 += super.getDx() * elapsedTimeNs / BILLION;
        y2 += super.getDy() * elapsedTimeNs / BILLION; 
    }

    @Override
    public String toString() {
        String info
                = this.getClass().getName() + ": x=" + super.getX() + ", y=" + super.getY()
                +"x2= "+ x2+ "y2= " + y2 + ", color=" + super.getColor();
        return info;
    }
 
}
