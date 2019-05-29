package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile implements CardStackInterface {

	private final int number;

	private int numberOfFaceUpCards;

    private CardStack cardStack;

	public Pile(int number, List<Card> cards) {
		assert cards.size() > 0;
        this.cardStack = new CardStack();
		this.number = number;
		this.numberOfFaceUpCards = 0;
		this.cardStack.cards.addAll(cards);
		this.flipFirstCard();
	}

	public void push(Card card) {
        assert(card != null);
		assert this.fitsIn(card);
		this.cardStack.push(card);
		this.numberOfFaceUpCards++;
	}

	public Card pop() {
		this.numberOfFaceUpCards--;
		return this.cardStack.pop();
	}

	private void flipFirstCard() {
		assert !this.cardStack.cards.empty()
		        && this.numberOfFaceUpCards == 0 
		        && !this.cardStack.cards.peek().isFacedUp();
		
		this.cardStack.cards.peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		
		if (this.cardStack.cards.empty()) {
		    return (card.getNumber() == Number.KING);
		}
		else {
		    boolean cardIsNextLower = this.cardStack.cards.peek().isNumberNextTo(card);
		    boolean cardHasDifferentColor = this.cardStack.cards.peek().getColor() != card.getColor();
		    
		    return cardIsNextLower && cardHasDifferentColor;
		}
	}

	public List<Card> peek(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		return new ArrayList<Card>(this.cardStack.cards.subList(this.cardStack.cards.size() - numberOfCards, this.cardStack.cards.size()));
	}

	public void push(List<Card> cards) {
		assert cards != null;
		this.cardStack.cards.addAll(cards);
		this.numberOfFaceUpCards += cards.size();
	}

	public void remove(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		for (int i = 0; i < numberOfCards; i++) {
			this.cardStack.cards.pop();
			numberOfFaceUpCards--;
		}
		if (this.numberOfFaceUpCards == 0 && !this.cardStack.cards.empty()) {
			flipFirstCard();
		}
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public Stack<Card> getCards() {
		return this.cardStack.cards;
	}

	public int getNumber() {
		return this.number;
	}

    public boolean isEmpty() {
        return this.cardStack.cards.empty();
    }

    public Card peek() {
        return this.cardStack.peek();
    }
}
