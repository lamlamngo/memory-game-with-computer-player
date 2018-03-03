import java.awt.Graphics;

/**
 * Class that represents a Rectangle shape
 *
 * @author Lam Ngo
 * @version 03/07/2017
 */
public class Rectangle extends Shape {

    /**
     * Constructor that creates the Rectangle
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param color The color of the Rectangle 
     * @param filling The filling of the Rectangle
     * @param shapeType The type of shape
     */
	public Rectangle(int x, int y, int color, int filling, int shapeType) {
		super(x,y,color,filling, shapeType);
	}

    /**
     * Display the rectangle
     *
     * @param page The Graphics object
     */
	public void display(Graphics page) {
        if (selected){
            img = loadImage(img,"/images/chosen.PNG");
        }
        else {
            img = loadImage(img, "/images/notchosen.PNG");
        }
        page.drawImage(img,x,y,null);
    }
}