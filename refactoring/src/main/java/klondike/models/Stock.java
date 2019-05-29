package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock extends CardStack {

    private CardStack cardStack;    
    
    public Stock() {
        super();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cards);
    }

    public List<Card> pop(int quantity) {
        assert 0 < quantity && quantity <= this.cards.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cards.subList(0, quantity));
        this.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }

    public boolean new_isEmpty() {
        return this.cardStack.isEmpty();
    }

    public Card new_peek() {
        return this.cardStack.peek();
    }

    public Card new_pop() {
        return this.cardStack.pop();
    }

    public void new_push(Card card) {
        this.cardStack.push(card);
    }
}
