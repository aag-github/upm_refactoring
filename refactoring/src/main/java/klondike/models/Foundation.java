package klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

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
}
