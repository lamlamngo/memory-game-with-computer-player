import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the Computer AI
 * new
 * @author Lam Ngo and Varun Shah
 * @version 03/09/2017
 */
public class ComputerAI {
    private PlayingDeck aDeck; // Deck of cards on the game board
    private Card firstCard; // First card chosen by the computer
    private Card secondCard; // Second card chosen by the computer
    private ArrayList<Card> listOfCard; // List of cards selected by the computer
    private ArrayList<Card> userChoices; // List of cards selected by the user 
    private int firstIndex; // Index of the first card selected by the user 
    private int secondIndex; // Index of the second card seleced by the user
    private int fixedIndex; // Index of a card that has already been selected before
    private int matchCount; // Counts the number of successful matches by the computer
    private int mode; // Difficulty level of the game

    /**
     * Constructor that initializes the Computer AI
     *
     * @param userChoices List of cards selected by the user
     * @param aDeck The deck of cards on the game board
     * @param mode The difficulty level selected by the user 
     */
    public ComputerAI(ArrayList<Card> userChoices, PlayingDeck aDeck, int mode){
        this.aDeck = aDeck;
        listOfCard = new ArrayList<Card>();
        fixedIndex = -1;
        matchCount = 0;
        this.mode = mode;
        this.userChoices = userChoices;
    }

    public void newGame(){
        listOfCard.removeAll(listOfCard);
        userChoices.removeAll(userChoices);
        fixedIndex = -1;
        matchCount = 0;
    }

    /**
     * Executes the computer's selection of cards based on the game's difficulty and the user's
     * prior card selections
     */
    public void getCards() {
        if (mode != 0){
            if (!checkUserChoice()){
                System.out.println("check 1");
                if (!checkListOfCard()){
                    System.out.println("check 2");
                    if (!checkListAndUser()){
                        System.out.println("check 3");
                        firstCard = null;
                        secondCard = null;
                    }
                }
            }
            if (mode == 1){
                if (userChoices.size() == 6){
                    userChoices.removeAll(userChoices);
                }
                if (listOfCard.size() == 6){
                    listOfCard.removeAll(userChoices);
                }
            }
        }
        if (firstCard == null && secondCard == null){
            System.out.println("check 4");
            if (fixedIndex == -1){
                System.out.println("check 5");
                firstIndex = randInt(0, 71);
                secondIndex = randInt(0, 71);
                while (firstIndex == secondIndex || !aDeck.getCard(firstIndex).isDisplay()
                        || !aDeck.getCard(secondIndex).isDisplay()){
                    firstIndex = randInt(0, 71);
                    secondIndex = randInt(0, 71);
                }
                firstCard = aDeck.getCard(firstIndex);
                secondCard = aDeck.getCard(secondIndex);
            }
            else{
                firstCard = aDeck.getCard(fixedIndex);
                secondIndex = randInt(0,71);
                while (secondIndex == fixedIndex || !aDeck.getCard(secondIndex).isDisplay()){
                    secondIndex = randInt(0, 71);
                }
                secondCard = aDeck.getCard(secondIndex);
            }
        }
        listOfCard.add(firstCard);
        listOfCard.add(secondCard);
        firstCard.setSelected();
        secondCard.setSelected();
    }

    /**
     * Checks the list of cards selected by the user for a match
     *
     * @return True if there is a match and False otherwise
     */
    private boolean checkUserChoice(){
        return iteratethroughlist(userChoices);
    }

    /**
     * Checks the list of cards selected by the computer for a match
     *
     * @return True if there is a match and False otherwise
     */
    private boolean checkListOfCard(){
        return iteratethroughlist(listOfCard);
    }

    /**
     * Iternates through a list of selected cards to check if there is a match
     *
     * @param aList List of selected cards
     * @return True if two cards in the list match and False otherwise
     */
    private boolean iteratethroughlist(ArrayList<Card> aList){
        for (int i = 0; i < aList.size(); i++){
            for (int j = 0; j < aList.size(); j++){
                if (i != j){
                    if (aList.get(i).isDisplay() && aList.get(j).isDisplay()){
                        if (aList.get(i) != aList.get(j)){
                            if (isMatch(aList.get(i),aList.get(j))){
                                firstCard = aList.get(i);
                                secondCard = aList.get(j);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check if the currently selected card has been selected previously by the user
     *
     * @return True if the selected card has been chosen previously by the user and
     *         False otherwise
     */
    private boolean checkListAndUser(){
        for (int i = 0; i < userChoices.size();i++){
            if (userChoices.get(i).isDisplay()){
                for (int j = 0; j < listOfCard.size(); j++){
                    if (listOfCard.get(j).isDisplay()){
                        if (userChoices.get(i) != listOfCard.get(j)){
                            if (isMatch(userChoices.get(i),listOfCard.get(j))){
                                firstCard = userChoices.get(i);
                                secondCard = listOfCard.get(j);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the currently selected card has been selected previously by the computer
     *
     * @param aCard The card selected by the computer
     * @return True if the card has been selecetd previously and False otherwise
     */
    public boolean containsCard(Card aCard){
        for (int i = 0; i < listOfCard.size(); i++){
            if (aCard != listOfCard.get(i)){
                if (aCard.isDisplay() && listOfCard.get(i).isDisplay()){
                    if (isMatch(aCard,listOfCard.get(i))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Gets the number of matches by the computer
     *
     * @return matchCount The number of matches made by the computer
     */
    public int getMatchCount(){
        return matchCount;
    }

    /**
     * Checks whether it is the Computer's turn
     * 
     * @return True if it is the Computer's turn and False if it is the user's turn
     */
    public boolean computerTurn(){
        if (isMatch(firstCard,secondCard)){
            JOptionPane.showMessageDialog(null, "Computer got a match. Your turn now, press ok");
            aDeck.decrementCurrent(2);
            firstCard.deSelect();
            secondCard.deSelect();
            firstCard.setNotDisplay();
            secondCard.setNotDisplay();
            firstCard = null;
            secondCard = null;
            if (fixedIndex != -1 && !aDeck.getCard(fixedIndex).isDisplay()){
                fixedIndex = -1;
            }
            matchCount++;
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Computer Failed. Your turn now, press ok");
            firstCard.deSelect();
            secondCard.deSelect();
            if (containsCard(firstCard)){
                fixedIndex = aDeck.indexOf(firstCard);
            }
            else if (containsCard(secondCard)){
                fixedIndex = aDeck.indexOf(secondCard);
            }
            firstCard = null;
            secondCard = null;
            return false;
        }
    }

    /**
     * Generates a random integer within the given limits
     *
     * @param min Lower limit
     * @param max Upper limit
     * @return randomNum The randomly generated integer
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * Calls four functions to test if the shape, color, filling, and number of shapes
     * of the two selected cards are all equal, making it a match
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
     * Checks to see if the selected cards have the same number of shapes
     *
     * @param cardValue1 Number of shapes on the first card
     * @param cardValue2 Number of shapes on the second card
     * @return True if the number of shapes are equal and False otherwise
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
     * Check to see if the selected cards have the same shape
     *
     * @param cardShape1 Shape of the first card
     * @param cardShape2 Shape of the second card
     * @return True if both shapes are equal and False otherwise
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
     * Check to see if the selected cards have the same color
     *
     * @param cardColor1 Color of the first card
     * @param cardColor2 Color of the second card
     * @return True if both colors are the same and False otherwise
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
     * Check to see if the selected cards have the same filling
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