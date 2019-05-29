package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Stock implements CardStackInterface {

    private Stack<Card> cards;
    
    public Stock() {
        super();
        this.cards = new Stack<Card>();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cards);
    }

    public List<Card> pop(int quantity) {
        assert quantity > 0 && quantity <= this.cards.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cards.subList(0, quantity));
        this.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }

    public boolean isEmpty() {
        return this.cards.empty();
    }

    public Card peek() {
        assert(this.cards.size() > 0);        
        return this.cards.peek();
    }

    public Card pop() {
        assert(this.cards.size() > 0);
        return this.cards.pop();
    }

    public void push(Card card) {
        assert(card != null);
        this.cards.push(card);
    }
}
