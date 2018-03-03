import java.awt.Graphics;

/**
 * Class that represents Lam's face
 *  new
 * @author James Murphy
 * @version 03/09/2017
 */
public class Lam extends Shape {

    /**
     * Constructor that initializes the instance variables
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param color The color of the shape
     * @param filling The filling of the shape
     * @param shapeType The type of shape
     */
    public Lam(int x, int y, int color, int filling, int shapeType) {
        super(x,y,color,filling, shapeType);
    }
    /**
     * Have Lam draw himself
     *
     * @param page The page you wish to draw on
     */
    public void display(Graphics page) {
        myPath = "/images/" + "Lam" + ".jpg";
        img = loadImage(img, myPath);
        page.drawImage(img,x,y,null);
    }
}