
/**
 *
 * @author fauzianordlund
 */

import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
public class World {

    private double width, height; // this worlds width and height

    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this world 
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[3]; // an array of references (change to non-zero size)
        // Create the actual Shape objects (sub types)
        // ....
        // System.out.println("Shapes Created");
        //shapes[1] = new Circle(20,30,Color.PINK,true,5);
        shapes[0] = new Rectangle(30,90,Color.PINK,true,20,30);
        shapes[1] = new Circle(100,20,Color.RED,false,50);
        shapes[1].setVelocity(-90, 30);
        shapes[0].setVelocity(30,450);
        //                   x1 coord, y1 coord, color, x2,y2 coord
        shapes[2] = new Line(90,85,Color.BLUE,45,45);
        shapes[2].setVelocity(-41, 23);
        System.out.println("Shapes Created");
        //shapes[2] = new Circle(5,20,Color.ORANGE,true,5);
        distinguishShapes(shapes);
        
    }
         public void distinguishShapes(Shape[] shapes){
        //FillableShape fs = (FillableShape)shapes[0];    
        int numberOfFillables = 0; 
        for(Shape s : shapes){
             if(s instanceof FillableShape){
                 System.out.println("This is fillable");
                 numberOfFillables++;
                 FillableShape fs = (FillableShape)s;
                 if(fs.isFilled()){
                    // fs.setFilled(false);
                     ((FillableShape) s).setFilled(false);
                 }
                 else{
                     fs.setFilled(true);
                 }
             }
         }
         System.out.println(numberOfFillables);
        
 }
    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
        System.out.println("Dimensions set");
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elpsed time in nanoseconds
     */
    public void move(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        int j = 40;
        int k = 40;
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].move(elapsedTimeNs);
            shapes[i].constrain(shapes[i].getX(), shapes[i].getY(), width, height);
            if(shapes[i] instanceof Circle){
                shapes[i].constrain(shapes[i].getX(),shapes[i].getY(),width,height);
            }
        
        }
        System.out.println(width + ", " + height);
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}
