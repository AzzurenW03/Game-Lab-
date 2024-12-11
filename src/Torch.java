
public class Torch extends Item {
    public Torch() {
        super("Torch", "A lit torch that illuminates the dark.");
    }

    
    public void use() {
    	Room currentRoom = Game.getCurrentRoom();
        if (currentRoom.getName().equals("Graveyard")) { 
            Game.print("You light the torch, revealing a hidden passage!");
            Room hiddenRoom = new Room("Secret Path");
            currentRoom.addExit('n', hiddenRoom); 
            Game.print("A hidden path to the north has been revealed!");
        } else {
            Game.print("The torch burns, but nothing happens.");
        }
    }
}
