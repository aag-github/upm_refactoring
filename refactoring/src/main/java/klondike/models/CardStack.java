package klondike.models;

import java.util.Stack;

public class CardStack {

    protected Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<Card>();
    }

    public Card peek() {
        assert(this.cards.size() > 0);        
        return this.cards.peek();
    }

    public Card pop() {
        assert(this.cards.size() > 0);
        return this.cards.pop();
    }

    public void push(Card card) {
        assert(card != null);
        this.cards.push(card);
    }

}
