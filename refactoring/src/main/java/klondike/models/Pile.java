package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile extends CardStack {

	private final int number;

	private int numberOfFaceUpCards;

	public Pile(int number, List<Card> cards) {
		assert cards.size() > 0;
		this.number = number;
		this.numberOfFaceUpCards = 0;
		this.cards.addAll(cards);
		this.flipFirstCard();
	}

	@Override
	public void push(Card card) {
        assert(card != null);
		assert this.fitsIn(card);
		super.push(card);
		this.numberOfFaceUpCards++;
	}

	@Override
	public Card pop() {
		this.numberOfFaceUpCards--;
		return super.pop();
	}

	private void flipFirstCard() {
		assert !this.cards.empty()
		        && this.numberOfFaceUpCards == 0 
		        && !this.cards.peek().isFacedUp();
		
		this.cards.peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		
		if (this.cards.empty()) {
		    return (card.getNumber() == Number.KING);
		}
		else {
		    boolean cardIsNextLower = this.cards.peek().isNumberNextTo(card);
		    boolean cardHasDifferentColor = this.cards.peek().getColor() != card.getColor();
		    
		    return cardIsNextLower && cardHasDifferentColor;
		}
	}

	public List<Card> peek(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		return new ArrayList<Card>(this.cards.subList(this.cards.size() - numberOfCards, this.cards.size()));
	}

	public void push(List<Card> cards) {
		assert cards != null;
		this.cards.addAll(cards);
		this.numberOfFaceUpCards += cards.size();
	}

	public void remove(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		for (int i = 0; i < numberOfCards; i++) {
			this.cards.pop();
			numberOfFaceUpCards--;
		}
		if (this.numberOfFaceUpCards == 0 && !this.cards.empty()) {
			flipFirstCard();
		}
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public Stack<Card> getCards() {
		return this.cards;
	}

	public int getNumber() {
		return this.number;
	}
}
