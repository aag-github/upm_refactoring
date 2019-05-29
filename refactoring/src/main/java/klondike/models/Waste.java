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
    assert(this.cardStack.cards.size() > 0);        
    return this.cardStack.cards.peek();
}

public Card pop() {
    return this.cardStack.pop();
}

}
