package klondike.models;

import java.util.Stack;

public class Waste implements CardStackInterface {

    private Stack<Card> cards;

public Waste() {
    this.cards = new Stack<Card>();
}
    
public void push(Card card) {
    assert(card != null);
    assert(card.isFacedUp());
    this.cards.push(card);
}

public boolean isEmpty() {
    return this.cards.empty();
}

public Card peek() {
    assert(this.cards.size() > 0);        
    return this.cards.peek();
}

public void drop() {
    assert(this.cards.size() > 0);
    this.cards.pop();
}

}
