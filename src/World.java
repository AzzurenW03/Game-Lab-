import java.util.ArrayList; 

public class World {
    private ArrayList<Room> rooms;
    private Room startingRoom;

    public World() {
        rooms = new ArrayList<>();
        startingRoom = buildWorld(); 
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public static Room buildWorld() {
        Room graveyard = new Room("This is the Graveyard.");
        Room grandEntrance = new Room("You're in a dark eerie Entrance Hall and there are two suits of armor on both sides of you.");
        Room closedBluedoor = new Room("The Blue door on the left of you by the creepy suit of armor is locked.");
        Room closedBloodyDoor = new Room("The Bloody door on the right of you by the creepy suit of armor is locked.");
        Room stairs = new Room("You're on stairs.");
        Room creepyHallway = new Room("You're in a long creepy hallway.");
        Room bathroom = new Room("You're in a smelly dirty bathroom with scratch marks on the floor.");
        Room mainBedroom = new Room("You're in a Master bedroom and there's a bloody book on the bed.");
        Room secondBedroom = new Room("You're in the second bedroom and there's an old lady sitting in a chair humming.");
        Room diningRoom = new Room("You're in a dining room with old moldy food on the dinner table with a note beside it.");
        Room livingRoom = new Room("You're in a living room with a radio playing.");
        Room kitchenRoom = new Room("Floor is missing and you can see the basement from there but you would have to jump down.");
        Room basement = new Room("You're in a dark basement with creepy noises.");

        Item ghost = new Item("ghost", "There is a spooky ghost roaming around the graveyard.");
        Item knife = new Item("knife", "There is a bloody knife.");
        Item hand = new Item("hand", "There is a disembodied hand crawling around on its fingers.");
        
        
        Item suitofarmor = new Item("suitofarmor", "A suit of armor stands silently, guarding the entrance.");
        Item oldbook = new Item("oldbook", "An old, dusty book lies on a pedestal.");
        Item flickeringcandle = new Item("candle", "A flickering candle casts eerie shadows on the walls.");
        Combination combination = new Combination("combination", "It's a strange combination lock.");
        graveyard.addItem(combination);
        
        Safe safe = new Safe("safe", "It's an impressive safe!");
        diningRoom.addItem(safe);
        
     
        grandEntrance.addItem(suitofarmor);
        grandEntrance.addItem(oldbook);
        grandEntrance.addItem(flickeringcandle);
        graveyard.addItem(ghost);
        bathroom.addItem(knife);
        creepyHallway.addItem(hand);


     
        graveyard.addExit('e', grandEntrance);
        grandEntrance.addExit('w', graveyard);
        grandEntrance.addExit('n', closedBluedoor);
        closedBluedoor.addExit('e', closedBloodyDoor);
        closedBloodyDoor.addExit('n', stairs);
        stairs.addExit('u', creepyHallway);
        creepyHallway.addExit('w', bathroom);
        bathroom.addExit('e', creepyHallway);
        creepyHallway.addExit('e', mainBedroom);
        mainBedroom.addExit('w', creepyHallway);
        creepyHallway.addExit('u', secondBedroom);
        secondBedroom.addExit('w', creepyHallway);
        creepyHallway.addExit('e', diningRoom);
        diningRoom.addExit('w', creepyHallway);
        creepyHallway.addExit('w', livingRoom);
        livingRoom.addExit('u', kitchenRoom);
        kitchenRoom.addExit('d', basement);

        return graveyard;
    }
}
//Task 6: Update the Game class (Part II)
//Add cases for the commands "use" and "open" to your switch statement. Both will be similar to
//the "take" command you should already have. Once you have the Item, either from the current
//room or the player's inventory, call the appropriate method: use() or open().
//Play your game and make sure you can open the safe and retrieve the diamond.


