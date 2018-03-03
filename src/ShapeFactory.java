/**
 * Shape Factory class that performs the factory design pattern
 * 
 * @author Lam Ngo
 * @version 03/09/2017
 */
public class ShapeFactory {

	/**
	 * Create a shape upon request
	 *
	 * @param type The type of shape (outline or fill)
	 * @param shapeType The type of shape in the card
	 * @param filling The type of filling in the shape
	 * @param color The color of the shape
	 * @return shape with type, shape type, filling and color
	 */
	public Shape createShape(String type, int shapeType, int filling, int color) {
		Shape shape = null;
			if (type.equals("SetShape")){
				if (shapeType == 0){
					shape = new Bean(0,0,color,filling,shapeType);
				}
				else if(shapeType == 1){
					shape = new Diamond(0,0,color,filling,shapeType);
				}
				else if(shapeType == 2){
					shape = new Oval(0,0,color,filling,shapeType);
				}
				//new
				else if(shapeType == 3){
					shape = new James(0,0,color,filling,shapeType);
				}
				else if(shapeType == 4){
					shape = new Varun(0,0,color,filling,shapeType);
				}
				else if(shapeType == 5){
					shape = new Diego(0,0,color,filling,shapeType);
				}
				else if(shapeType == 6){
					shape = new Barr (0,0,color,filling,shapeType);
				}
				else if(shapeType == 7){
					shape = new Lam  (0,0,color,filling,shapeType);
				}
			}
			else if (type.equals("Outline")){
					shape = new Rectangle(0,0,0,0,7);
			}
		return shape;
	}
}