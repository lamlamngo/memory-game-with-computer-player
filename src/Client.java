import java.util.ArrayList;

/**
 * Created by Administrator on 6/2/2017.
 */
public class Client {
    public static void main(String [] args) {
        PlayingDeck myDeck = new PlayingDeck();
        myDeck.deal(12);
        ArrayList<Card> myCard  = myDeck.getContent();
        myCard.remove(0);
        System.out.println(myCard.size());
        System.out.println(myDeck.fuck());
    }
}
