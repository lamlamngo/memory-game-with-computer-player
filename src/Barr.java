import java.awt.Graphics;

/**
 * Class that represents Prof. Barr's face
 * @author James Murphy
 */
public class Barr extends Shape {

    /**
     * Constructor that initializes the instance variables
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param color The color of the shape
     * @param filling The filling of the shape
     * @param shapeType The type of shape
     */
    public Barr(int x, int y, int color, int filling, int shapeType) {
        super(x,y,color,filling, shapeType);
    }
    /**
     * Have Prof. Barr draw herself
     *
     * @param page The page you wish to draw on
     */
    public void display(Graphics page) {
        myPath = "\\images\\" + "barr" + ".jpg";
        img = loadImage(img, myPath);
        page.drawImage(img,x,y,null);
    }
}