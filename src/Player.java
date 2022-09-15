import java.util.ArrayList;

public class Player {

    public String Name;
    public int nameNum;
    public ArrayList<Card> hand;


public Player(int pnameNum){
    nameNum = pnameNum;
    hand = new ArrayList<Card>();

    Name = "Player" + Integer.toString(nameNum);
}

public void printHand () {
    for (int i = 0; i < hand.size(); i++) {
        hand.get(i).printCard();

    }


    }
}
