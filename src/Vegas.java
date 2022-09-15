import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Vegas implements KeyListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public int cardCounter=0;
    public int randomInt;
    public Card[] deck;
    public int deckNumber=0;
    public ArrayList<Player>players = new ArrayList<Player>();
    public int nextCard;
    public int nextPlayer;
    public int playerTurn=0;


    public static void main(String[] args) {
        Vegas myApp = new Vegas();

    }

    public Vegas() {

        deck = new Card[52];
        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 13; i++) {
                deck[cardCounter] = new Card(i, j);
                cardCounter++;
            }
        }

        players.add(new Player( 0));
        players.add(new Player( 1));
        players.add(new Player( 2));
        players.add(new Player( 3));
        run();
    }



    public void run(){
        render();
        Shuffle();
        printDeck();
        setUpGraphics();
        Deal();

    }

    public void Shuffle () {
        for (int i = 0; i < 52; i++){
            randomInt = (int) (Math.random() * 52);
            Card hold = deck[i];
            deck[i] = deck[randomInt];
            deck[randomInt] = hold;
        }
    }

    public void Deal(){
        for(int p=0;p<4;p++) { // 'p' handles the players
            for (int x = 0; x < 2; x++) { // 'x' handles how many cards each player gets
                players.get(p).hand.add(deck[nextCard]);
                nextCard++;
            }
            System.out.println("Player " + players.get(p).nameNum + ": ");
            players.get(p).printHand();
        }

    }
    public void hit(){
        players.get(nextPlayer).hand.add(deck[nextCard]);
        nextCard++;
    }

    public void Stand(){
        nextPlayer++;
    }

    public void printDeck(){
        for (int i = 0; i < 52; i++){
            deck[i].printCard();
        }
    }


    public void setUpGraphics() {
        frame = new JFrame("BlackJack");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("*********");
        canvas.addKeyListener(this);
    }

    public void render(){
    }

    public void keyPressed (KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
        if (keyCode == 72) { // this is "h"
            hit();
            players.get(nextPlayer).printHand();
            System.out.println(players.get(nextPlayer).nameNum + " chose to hit");

            if (nextPlayer < 4) {
                nextPlayer++;
            }
            if (nextPlayer == 4){
                nextPlayer = 0;
            }
        }

        if (keyCode == 83) { //this is "s"
            Stand();
            players.get(nextPlayer).printHand();
                System.out.println("Player " + players.get(nextPlayer).nameNum + " chose to stand");

            }
        }

    public void keyReleased (KeyEvent event) {
    }

    public void keyTyped(KeyEvent event){
    }

}
