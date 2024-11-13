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

    Room currentRoom = Game.getCurrentRoom(); 
    
    public static Room buildWorld() {
        
        
        Room graveyard = new Room("Graveyard", "You are standing in a creepy graveyard. Fog is rolling in.");
        Room grandEntrance = new Room("Grand Entrance", "You're in a dark, eerie Entrance Hall with two suits of armor guarding the way.");
        Room blueDoorRoom = new Room("Blue Door Room", "This room is behind the blue door. It's dark and cold with an unsettling feeling.");
        Room stairs = new Room("Stairs", "You are on a spiral staircase that leads upwards.");
        Room creepyHallway = new Room("Creepy Hallway", "You're in a long, narrow hallway with flickering lights.");
        Room bathroom = new Room("Bathroom", "The bathroom smells musty. Scratch marks cover the floor.");
        Room mainBedroom = new Room("Main Bedroom", "You're in the main bedroom. A bloody book lies on the bed.");
        Room diningRoom = new Room("Dining Room", "A grand dining room with dusty chairs and a large table.");
        Room kitchenRoom = new Room("Kitchen Room", "The kitchen is in disarray, with broken plates scattered across the floor.");
        Room basement = new Room("Basement", "You're in a dark, cold basement filled with strange noises.");
        Room lockedRoom = new Room("Locked Room", "A room sealed with a heavy iron door. It’s tightly shut.");
        
        Item ghost = new Item("ghost", "A spooky ghost floats around the graveyard, watching you.");
        Item knife = new Item("knife", "A sharp bloody knife. It seems to have been left behind in haste.");
        Item hand = new Item("hand", "A disembodied hand crawls across the floor.");
        Item key = new Item("key", "A small rusted key. It looks like it might fit a lock.");
        Item oldbook = new Item("oldbook", "An old dusty book. It seems to be from a forgotten time.");
        Item flickeringcandle = new Item("flickeringcandle", "A candle flickers eerily, casting shadows on the walls.");
        
        Item torch = new Torch();
        Item oldMap = new OldMap();
        Item spellbook = new Spellbook();
        
        graveyard.addItem(ghost);
        graveyard.addItem(key);  
        bathroom.addItem(knife);
        creepyHallway.addItem(hand);
        grandEntrance.addItem(oldbook);
        grandEntrance.addItem(flickeringcandle);
        graveyard.addItem(torch);  
        grandEntrance.addItem(oldMap);  
        blueDoorRoom.addItem(spellbook);  
        
        
        blueDoorRoom.lock();  
        lockedRoom.lock();    

        
        graveyard.addExit('e', grandEntrance);
        grandEntrance.addExit('w', graveyard);
        grandEntrance.addExit('n', blueDoorRoom); 
        grandEntrance.addExit('s', lockedRoom);   
        blueDoorRoom.addExit('s', grandEntrance);
        grandEntrance.addExit('n', stairs);
        stairs.addExit('u', creepyHallway);
        creepyHallway.addExit('w', bathroom);
        bathroom.addExit('e', creepyHallway);
        creepyHallway.addExit('e', mainBedroom);
        mainBedroom.addExit('w', creepyHallway);
        creepyHallway.addExit('u', diningRoom);
        diningRoom.addExit('w', creepyHallway);
        creepyHallway.addExit('w', kitchenRoom);
        kitchenRoom.addExit('d', basement);
        
        return graveyard;  
    }
}



//Task 6: Update the Game class (Part II)
//Add cases for the commands "use" and "open" to your switch statement. Both will be similar to
//the "take" command you should already have. Once you have the Item, either from the current
//room or the player's inventory, call the appropriate method: use() or open().
//Play your game and make sure you can open the safe and retrieve the diamond.


