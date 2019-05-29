package klondike.models;

public class WasteTest extends CardStackTest {

	@Override
	protected CardStackInterface createCardStack() {
		return new Waste();
	}
	
}
