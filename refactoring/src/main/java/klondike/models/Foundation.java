package klondike.models;

import java.util.Stack;

public class Foundation implements CardStackInterface {

    private Suit suit;

    private Stack<Card> cardStack;

    public Foundation(Suit suit) {
        super();
        this.cardStack = new Stack<Card>();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cardStack.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;

        boolean cardIsSameSuiteAsPile = card.getSuit() == this.suit;
        boolean cardIsAnAce = (card.getNumber() == Number.AS);
        boolean cardIsNextHigher = !this.isEmpty() && card.isNumberNextTo(this.peek()); 
        return (cardIsSameSuiteAsPile) 
               && (cardIsAnAce || cardIsNextHigher); 
    }

    public Suit getSuit() {
        return this.suit;
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
