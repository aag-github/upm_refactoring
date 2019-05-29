package klondike.models;

import java.util.Stack;

public class CardStack {

    protected Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<Card>();
    }

    public void push(Card card) {
        assert(card != null);
        this.cards.push(card);
    }

}
