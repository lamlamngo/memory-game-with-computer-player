import java.awt.*;

/**
 * Class that represents a Diamond shape
 * @author Lam Ngo and Varun Shah
 * @version 03/09/2017
 */
public class Diamond extends Shape {

    /**
     * Constructor that creates the Diamond shape
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param color The color of the Diamond
     * @param filling The filling of the Diamond
     * @param shapeType The type of shape
     */
    public Diamond(int x, int y, int color, int filling, int shapeType) {
        super(x,y,color,filling, shapeType);
    }

    /**
     * Have the Diamond draw itself
     *
     * @param page The page you wish to draw on
     */
    public void display(Graphics page) {
        myPath = "/images/" + getColor() + "_" + getShape() + "_" + getFilling() + ".png";
        img = loadImage(img, myPath);
        page.drawImage(img,x,y,null);
    }
}