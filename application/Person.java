package application;

public abstract class Person {

	// Data fields for person, name and hand
	private String name;
	private Hand hand;
	
	// Constructors for person
	protected Person() {
		this.name = "Name";
		this.hand = new Hand();
	}
	
	protected Person(String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}
	
	// Getter and setter methods for the persons name
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	// Getter and setter methods for hand
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	 
	public Hand getHand() {
		return this.hand;
	}
	
	
	
	// Method checks if the person has blackjack
	public boolean hasBlackJack() {
		if (this.getHand().calculateTotal() == 21)
			return true;
		else
			return false;
	}
	// Method will prompt the player or dealer to hit or stand
	public abstract void hitOrStand(Deck deck); 
	
}

