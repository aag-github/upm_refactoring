package klondike.models;

public class Foundation implements CardStackInterface {

    private Suit suit;

    private CardStack cardStack;

    public Foundation(Suit suit) {
        super();
        this.cardStack = new CardStack();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cardStack.cards.size() == Number.values().length;
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
        return this.cardStack.isEmpty();
    }

    public Card peek() {
        return this.cardStack.peek();
    }

    public Card pop() {
        return this.cardStack.pop();
    }

    public void push(Card card) {
        this.cardStack.push(card);
    }
}
