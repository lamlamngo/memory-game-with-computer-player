import java.awt.*;

/**
 * Class that represents Varun's face. New
 *
 * @author Lam Ngo
 * @version 03/09/2017
 */
public class Varun extends Shape {

    /**
     * Constructor that initializes the instance variables
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param color The color of the shape
     * @param filling The filling of the shape
     * @param shapeType The type of shape
     */
    public Varun(int x, int y, int color, int filling, int shapeType) {
        super(x,y,color,filling, shapeType);
    }
    
    /**
     * Have Varun draw himself
     *
     * @param page The page you wish to draw on
     */
    public void display(Graphics page) {
        myPath = "/images/" + "Varun" + ".jpeg";
        img = loadImage(img, myPath);
        page.drawImage(img,x,y,null);
    }
}