package klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

    private CardStack cardStack;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
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
