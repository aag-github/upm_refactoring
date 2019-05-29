package klondike.models;

import java.util.Stack;

public class Waste implements CardStackInterface {

    private Stack<Card> cardStack;

public Waste() {
    this.cardStack = new Stack<Card>();
}
    
public void push(Card card) {
    assert(card != null);
    assert(card.isFacedUp());
    this.cardStack.push(card);
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

}
