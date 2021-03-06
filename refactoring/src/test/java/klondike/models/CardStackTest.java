package klondike.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klondike.models.builders.CardBuilder;

public abstract class CardStackTest {

	protected abstract CardStackInterface createCardStack();
	
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
	    CardStackInterface cardStack = this.createCardStack();
		assertTrue(cardStack.isEmpty());
	}
	
	@Test
	public void testEmptyWithNotEmpty() {
	    CardStackInterface cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		assertFalse(cardStack.isEmpty());
	}

	@Test
	public void testPushWithEmpty() {
	    CardStackInterface cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), cardStack.peek());
	}
	
	@Test
	public void testPushWithNotEmpty() {
	    CardStackInterface cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		cardStack.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), cardStack.peek());
	}

	@Test
	public void testPopEmpty() {
	    CardStackInterface cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		cardStack.drop();
		assertTrue(cardStack.isEmpty());
	}
	
	@Test
	public void testPopNotEmpty() {
	    CardStackInterface cardStack = this.createCardStack();
		cardStack.push(this.getCards().get(0));
		cardStack.push(this.getCards().get(1));
		cardStack.drop();
		assertEquals(this.getCards().get(0), cardStack.peek());
	}

	@Test(expected = AssertionError.class)
	public void testPopOnEmptyStack() {
	    CardStackInterface cardStack = this.createCardStack();
	    cardStack.drop();
	}
	
    @Test(expected = AssertionError.class)
    public void testPeekOnEmptyStack() {
        CardStackInterface cardStack = this.createCardStack();
        cardStack.peek();
    }

    @Test(expected = AssertionError.class)
    public void testPushWithNullCard() {
        CardStackInterface cardStack = this.createCardStack();
        cardStack.push(null);
    }

}
