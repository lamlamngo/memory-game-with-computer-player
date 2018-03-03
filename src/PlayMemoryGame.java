import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

    public PlayMemoryGame() {
        try {
            // Set cross-platform Java L&F
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        //Login Screen
        loginPanel = new JPanel();
        login = new JLabel("Log In");
        username = new JTextField(3);
    }
    
    
    
    
    
    /**
     * CanvasPanel is the class upon which we actually draw.  It listens
     * for mouse events.
     */
    private class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {
        private static final long serialVersionUID = 0;

        /**
         * Constructor just needs to set up the CanvasPanel as a listener.
         */
        public CanvasPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        /**
         * Paint the whole drawing.
         * if it is in tutorial, printout the tutorial message.
         * @page the Graphics object to draw on
         */
        public void paintComponent(Graphics page) {
            super.paintComponent(page);
            myGame.display(page);
        }

        /**
         * When the mouse is clicked, check to see if setgame can remove card and if the game ends.
         */
        public void mouseClicked(MouseEvent event) {
        }

        //we don't use these.
        public void mousePressed(MouseEvent event) {
            int result = myGame.getCards(event.getPoint());
            if (result == 1){
                remove = true;
                turnUpdate();
            }else if (result == 0){
                turnUpdate();
                remove = false;
            }else{
                remove = false;
                turnCount++;
            }
            repaint();
        }

        public void mouseDragged(MouseEvent event)  { }
        public void mouseReleased(MouseEvent event) { }
        public void mouseEntered(MouseEvent event) { }
        public void mouseExited(MouseEvent event) { }
        public void mouseMoved(MouseEvent event) { }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
