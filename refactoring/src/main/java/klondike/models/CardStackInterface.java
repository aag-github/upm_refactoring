package klondike.models;

public interface CardStackInterface {

    public boolean isEmpty();

    public Card peek();

    public Card pop();

    public void push(Card card);
}
