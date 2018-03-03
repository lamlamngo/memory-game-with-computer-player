import java.awt.*;
import java.util.ArrayList;

/**
 * Class that executes the Memory game 
 * new
 * @author Lam Ngo and James Murphy
 * @version 03/06/2017
 */
public class MemoryGame{
    private final int PLAYINGNUM = 72; //the default number of cards on deck.
    private final int MATCHNUM = 2;      // 3 is the number of cards needed to make a set.
    private PlayingDeck playingDeck;
    private ArrayList<Card> userChoices;
    private int matchCount;

    /**
     * Constuctor that initalizes the variables that is only called once to main
     * tain the singleton design pattern
     */
    public MemoryGame(){
        matchCount = 0;
        playingDeck = new PlayingDeck(PLAYINGNUM);
        playingDeck.createMemoryDeck();
        playingDeck.shuffle();
        playingDeck.deal(PLAYINGNUM);
        userChoices = new ArrayList<Card>();
    }

    /**
     * Gets the playing deck of cards
     *
     * @return playingDeck The deck of cards
     */
	public PlayingDeck getDeck(){
    	return playingDeck;
	}

	/**
	 * Gets the number of matches
	 *
	 * @return matchCount The number of successful matches
	 */
	public int getMatchCounter(){
		return matchCount;
	}

	/**
	 * Gets the list of cards selected by the user
	 *
	 * @return userChoices The list of choices made by the user
	 */
	public ArrayList<Card> getUserChoices(){
		return userChoices;
	}

	/**
	 * Checks if the game has ended
	 *
	 * @return True if there are no cards on the game board
	 *		   False otherwise
	 */
    public boolean checkEndCondition(){
		return playingDeck.isFieldEmpty();
	}

    /**
     * Replaces all the cards from the playing field with new cards
     */
    public void reDeal(){
    	userChoices.removeAll(userChoices);
        matchCount = 0;
        playingDeck.reset();
        playingDeck.deal(PLAYINGNUM);
    }

    /**
     * Getter method that gets the cards at particular points
     * and check if they form a valid match
     *
     * @param p Point that is clicked by the mouse
     * @return 1 If the selected cards form a valid match
     * 		   0 If the selected cards do not form a valid match
     * 		   2 If 2 cards have not been selected yet
     */
    public int getCards(Point p){
        playingDeck.selectCards(p,MATCHNUM);
        if(playingDeck.enoughSelected(MATCHNUM)){
			userChoices.add(playingDeck.getSelected(0));
			userChoices.add(playingDeck.getSelected(1));
            if (isMatch(playingDeck.getSelected(0), playingDeck.getSelected(1))){
                matchCount++;
                return 1;
            }else{
                return 0;
            }
        }
        return 2;
    }

    /**
     * Checks if 2 cards have been selected, making them removable and flippable
     *
     * @return True if 2 cards have been selected and False otherwise
     */
    public boolean removeandflipable(){
    	return playingDeck.enoughSelected(MATCHNUM);
	}

    /**
     * Removes the selected cards from the playing field
     */
    public void removeSelected(){
        playingDeck.removeSelected(MATCHNUM);
    }

    /**
     * Unselects all the selected cards
     */
    public void deSelectCards(){
        playingDeck.deSelect();
    }

    /**
     * Displays the playing field
     *
     * @param page The Graphics object
     */
    public void display(Graphics page){
        playingDeck.display(page);
    }
    
    /**
	 * Calls four functions to test if the shape, color, filling, and number
	 * for the two selected cards are all equal
	 *
	 * @param cardOne First card selected
	 * @param cardTwo Second card selected
	 * @return True if it is a match and False otherwise
	 */
	public boolean isMatch(Card cardOne, Card cardTwo){
		if(validNum(cardOne.getNumber(),cardTwo.getNumber())
			&&validShape(cardOne.getShape(),cardTwo.getShape())
		    &&validFilling(cardOne.getFilling(),cardTwo.getFilling())
			&&validColor(cardOne.getColor(),cardTwo.getColor()))
		{
			return true;
		}
		return false;
	}

	/**
	 * Check to see if the match has 2 cards that have the same number of shapes 
	 *
	 * @param cardValue1 Number of shapes on the first card
	 * @param cardValue2 Number of shapes on the second card
	 * @return True if the number of shapes are the same and False otherwise
	 */
	 private boolean validNum(int cardValue1,int cardValue2){
		if(cardValue1==cardValue2){
			return true;
		}
		else{
			return false;
		}
	}
	  
	/**
	 * Check to see if the match has 2 cards that have either all the same
	 * or different shapes 
	 * 
	 * @param cardShape1 Shape of the first card
	 * @param cardShape2 Shape of the second card
	 * @return True if all shapes are the same or all are different
	 *		   False otherwise
	 */
	private boolean validShape(String cardShape1,String cardShape2){
		if(cardShape1.equals(cardShape2)){
			return true;
		}
		else{
			return false;
		}
	}
	  
	/**
	 * Check to see if the match has 2 cards that have either all the same
	 * or different colors 
	 * 
	 * @param cardColor1 Color of the first card
	 * @param cardColor2 Color of the second card
	 * @return True if all colors are the same or all different color and False otherwise
	 */
	private boolean validColor(String cardColor1,String cardColor2){
		if(cardColor1.equals(cardColor2)){
			return true;
		}
		else{
			return false;
		}
	}
	  
	/**
	 * Checks if the match has 2 cards that have the same filling
	 * 
	 * @param cardFilling1 Filling of the first card
	 * @param cardFilling2 Filling of the second card
	 * @return True if both the fillings are the same and False otherwise
	 */
	private boolean validFilling(String cardFilling1,String cardFilling2){
		if(cardFilling1.equals(cardFilling2)){
			return true;
		}
		else{
			return false;
		}
	}
}