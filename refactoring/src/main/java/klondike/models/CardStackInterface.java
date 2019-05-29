package klondike.models;

public interface CardStackInterface {

    public boolean isEmpty();

    public Card peek();

    public void drop();

    public void push(Card card);
}
