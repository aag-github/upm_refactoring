package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Stock implements CardStackInterface {

    private Stack<Card> cardStack;
    
    public Stock() {
        super();
        this.cardStack = new Stack<Card>();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cardStack.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cardStack);
    }

    public List<Card> pop(int quantity) {
        assert 0 < quantity && quantity <= this.cardStack.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cardStack.subList(0, quantity));
        this.cardStack.removeAll(cardsToReturn);
        return cardsToReturn;
    }

    public boolean isEmpty() {
        return this.cardStack.empty();
    }

    public Card peek() {
        assert(this.cardStack.size() > 0);        
        return this.cardStack.peek();
    }

    public Card pop() {
        assert(this.cardStack.size() > 0);
        return this.cardStack.pop();
    }

    public void push(Card card) {
        assert(card != null);
        this.cardStack.push(card);
    }
}
