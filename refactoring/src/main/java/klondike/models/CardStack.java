package klondike.models;

import java.util.Stack;

public abstract class CardStack {

    protected Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<Card>();
    }

    public boolean isEmpty() {
        return this.cards.empty();
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
        this.cards.push(card);
    }

}
