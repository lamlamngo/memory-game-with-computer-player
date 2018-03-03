import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PlayMemoryGame extends JFrame {
    private MemoryGame myGame;
    private final int FRAME_WIDTH = 850, FRAME_HEIGHT = 700;
    private static CanvasPanel canvasPanel;
    private Container cp;
    private JPanel memoryPanel,loginPanel;
    private JTextField username;
    private CustomButton flipButton,removeButton, quitButton, newGameButton;
    private JLabel turnCounter,timeCounter, login;
    private boolean remove;
    private int turnCount;
    private static final String turn = "Turn: ";
    private Timer timer;
    private int time;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
