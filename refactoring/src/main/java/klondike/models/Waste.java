package klondike.models;

public class Waste extends CardStack {

    private CardStack cardStack;

@Override
public void push(Card card) {
    assert(card != null);
    assert(card.isFacedUp());
    this.cardStack = new CardStack();
    this.cards.push(card);
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
