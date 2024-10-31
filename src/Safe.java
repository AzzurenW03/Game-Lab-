
public class Safe extends Item {
	public Safe(String name, String desc) {
		super(name, desc);
	}

	public void open() {
	    Item combination = Game.getItemFromInventory("Secret Code");
	    if (combination != null) {
	        Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
	        Item diamond = new Item("Diamond", "A sparkling diamond.");
	        Game.inventory.add(diamond);
	    } else { 
	        Game.print("The safe is locked and you don't have the combination.");
	    }
	}
}
	
