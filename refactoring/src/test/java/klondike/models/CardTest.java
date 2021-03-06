package klondike.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import klondike.models.builders.CardBuilder;

public class CardTest {

	@Test
	public void testFlipNotisFacedUp() {
		Card card = new CardBuilder().build();
		card.flip();
		assertTrue(card.isFacedUp());
	}
	
	@Test
	public void testFlipisFacedUp() {
		Card card = new CardBuilder().facedUp().build();
		card.flip();
		assertFalse(card.isFacedUp());
	}

	@Test
	public void testIsNextTo() {
		this.testIsNextTo(Number.TWO , Number.ACE);
		this.testIsNextTo(Number.KING, Number.QUEEN);
	}

	void testIsNextTo(Number firstNumber, Number secondNumber) {
		Card firstCard = new CardBuilder().number(firstNumber).build();
		Card secondCard = new CardBuilder().number(secondNumber).build();
		assertTrue(firstCard.isNumberNextTo(secondCard));
	}
	
	@Test
	public void testIsNotNextTo() {
		this.testIsNotNextTo(Number.ACE, Number.TWO);
		this.testIsNotNextTo(Number.ACE, Number.KING);
	}

	void testIsNotNextTo(Number firstNumber, Number secondNumber) {
		Card firstCard = new CardBuilder().number(firstNumber).build();
		Card secondCard = new CardBuilder().number(secondNumber).build();
		assertFalse(firstCard.isNumberNextTo(secondCard));
	}

}
