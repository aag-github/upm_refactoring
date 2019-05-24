package klondike.models;

public class Waste extends CardStack {

@Override
public void push(Card card) {
    assert(card.isFacedUp());
    this.cards.push(card);
}

}