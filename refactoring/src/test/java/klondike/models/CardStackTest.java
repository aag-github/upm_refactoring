package klondike.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klondike.models.builders.CardBuilder;

public abstract class CardStackTest {

	protected abstract CardStack createCardStack();
	
	protected List<Card> getCards(){
		List<Card> cards = new ArrayList<Card>();
		cards.add(new CardBuilder().build());
		cards.add(new CardBuilder().build());
		for(Card card : cards) {
		    card.flip();
		}
		return cards;
	}
	
	@Test
	public void testEmptyWithEmpty() {
		CardStack cardStack = this.createCardStack();
		assertTrue(cardStack.isEmpty());
	}
	
	@Test
	public void testEmptyWithNotEmpty() {
		CardStack cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		assertFalse(cardStack.isEmpty());
	}

	@Test
	public void testPushWithEmpty() {
		CardStack cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), cardStack.peek());
	}
	
	@Test
	public void testPushWithNotEmpty() {
		CardStack cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		cardStack.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), cardStack.peek());
	}

	@Test
	public void testPopEmpty() {
		CardStack cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), cardStack.pop());
		assertTrue(cardStack.isEmpty());
	}
	
	@Test
	public void testPopNotEmpty() {
		CardStack cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		cardStack.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), cardStack.pop());
		assertEquals(this.getCards().get(0), cardStack.peek());
	}
}
