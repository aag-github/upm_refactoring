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
        assert(card != null);
        this.cardStack.cards.push(card);
    }
}
