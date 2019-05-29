package klondike.models;

public class Waste implements CardStackInterface {

    private CardStack cardStack;

public Waste() {
    this.cardStack = new CardStack();
}
    
public void push(Card card) {
    assert(card != null);
    assert(card.isFacedUp());
    this.cardStack.cards.push(card);
}

public boolean isEmpty() {
    return this.cardStack.cards.empty();
}

public Card peek() {
    return this.cardStack.peek();
}

public Card pop() {
    return this.cardStack.pop();
}

}
