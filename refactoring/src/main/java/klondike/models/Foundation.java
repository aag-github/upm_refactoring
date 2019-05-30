package klondike.models;

import java.util.Stack;

public class Foundation implements CardStackInterface {

    private Suit suit;

    private Stack<Card> cards;

    public Foundation(Suit suit) {
        super();
        this.cards = new Stack<Card>();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;

        boolean cardIsSameSuiteAsPile = card.getSuit() == this.suit;
        boolean cardIsAnAce = (card.getNumber() == Number.ACE);
        boolean cardIsNextHigher = !this.isEmpty() && card.isNumberNextTo(this.peek()); 
        return (cardIsSameSuiteAsPile) 
               && (cardIsAnAce || cardIsNextHigher); 
    }

    public Suit getSuit() {
        return this.suit;
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
