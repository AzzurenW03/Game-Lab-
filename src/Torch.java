
public class Torch extends Item {
    public Torch() {
        super("Torch", "A lit torch that illuminates the dark.");
    }

    
    public void use() {
        Game.print("You light the torch, revealing a hidden passage!");
        Room currentRoom = Game.getCurrentRoom(); 
        Room hiddenRoom = new Room("Secret Path", "You see a hidden path revealed by the light of the torch.");
        currentRoom.addExit('n', hiddenRoom);
        
         

        Game.print("A hidden path to the north has been revealed!");
    }
}
