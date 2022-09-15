public class Card {

    public int number;
    public int suitNum;
    public String name;
    public String cardName;

    public Card(int pNumber, int pSuitNum) {
        number = pNumber;
        suitNum = pSuitNum;

        if (pSuitNum == 1) {
            name = "clubs";
        }
        if (pSuitNum == 2) {
            name = "spades";
        }
        if (pSuitNum == 3) {
            name = "hearts";
        }
        if (pSuitNum == 4) {
            name = "diamonds";
        }
        if (pNumber == 1) {
            cardName = "ace";
        }
        if (pNumber == 2) {
            cardName = "2";
        }
        if (pNumber == 3) {
            cardName = "3";
        }
        if (pNumber == 4) {
            cardName = "4";
        }
        if (pNumber == 5) {
            cardName = "5";
        }
        if (pNumber == 6) {
            cardName = "6";
        }
        if (pNumber == 7) {
            cardName = "7";
        }
        if (pNumber == 8) {
            cardName = "8";
        }
        if (pNumber == 9) {
            cardName = "9";
        }
        if (pNumber == 10) {
            cardName = "10";
        }
        if (pNumber == 11) {
            cardName = "jack";
        }
        if (pNumber == 12) {
            cardName = "queen";
        }
        if (pNumber == 13) {
            cardName = "king";
        }
    }

    public void printCard() {
        if (number == 1| number == 8){
            System.out.println("This card is an " + cardName + " of " + name + ".");
        }
        if (number == 2| number == 3| number == 4| number == 5| number == 6| number ==7| number == 9| number ==10| number == 11| number == 12| number == 13){
            System.out.println("This card is a " + cardName + " of " + name + ".");
        }
    }
}
