package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile implements CardStackInterface {

	private final int number;

	private int numberOfFaceUpCards;

    private Stack<Card> cardStack;

	public Pile(int number, List<Card> cards) {
		assert cards.size() > 0;
        this.cardStack = new Stack<Card>();
		this.number = number;
		this.numberOfFaceUpCards = 0;
		this.cardStack.addAll(cards);
		this.flipFirstCard();
	}

	public void push(Card card) {
	    assert(card != null);
		assert this.fitsIn(card);
		this.cardStack.push(card);
		this.numberOfFaceUpCards++;
	}

	public Card pop() {
        assert(this.cardStack.size() > 0);
		this.numberOfFaceUpCards--;
        return this.cardStack.pop();
	}

	private void flipFirstCard() {
		assert !this.cardStack.empty()
		        && this.numberOfFaceUpCards == 0 
		        && !this.cardStack.peek().isFacedUp();
		
		this.cardStack.peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		
		if (this.cardStack.empty()) {
		    return (card.getNumber() == Number.KING);
		}
		else {
		    boolean cardIsNextLower = this.cardStack.peek().isNumberNextTo(card);
		    boolean cardHasDifferentColor = this.cardStack.peek().getColor() != card.getColor();
		    
		    return cardIsNextLower && cardHasDifferentColor;
		}
	}

	public List<Card> peek(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		return new ArrayList<Card>(this.cardStack.subList(this.cardStack.size() - numberOfCards, this.cardStack.size()));
	}

	public void push(List<Card> cards) {
		assert cards != null;
		this.cardStack.addAll(cards);
		this.numberOfFaceUpCards += cards.size();
	}

	public void remove(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		for (int i = 0; i < numberOfCards; i++) {
			this.cardStack.pop();
			numberOfFaceUpCards--;
		}
		if (this.numberOfFaceUpCards == 0 && !this.cardStack.empty()) {
			flipFirstCard();
		}
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public Stack<Card> getCards() {
		return this.cardStack;
	}

	public int getNumber() {
		return this.number;
	}

    public boolean isEmpty() {
        return this.cardStack.empty();
    }

    public Card peek() {
        assert(this.cardStack.size() > 0);        
        return this.cardStack.peek();
    }
}
