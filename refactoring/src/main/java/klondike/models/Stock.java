package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock implements CardStackInterface {

    private CardStack cardStack;
    
    public Stock() {
        super();
        this.cardStack = new CardStack();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cardStack.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cardStack.cards);
    }

    public List<Card> pop(int quantity) {
        assert 0 < quantity && quantity <= this.cardStack.cards.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cardStack.cards.subList(0, quantity));
        this.cardStack.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }

    public boolean isEmpty() {
        return this.cardStack.cards.empty();
    }

    public Card peek() {
        assert(this.cardStack.cards.size() > 0);        
        return this.cardStack.cards.peek();
    }

    public Card pop() {
        assert(this.cardStack.cards.size() > 0);
        return this.cardStack.cards.pop();
    }

    public void push(Card card) {
        this.cardStack.push(card);
    }
}
