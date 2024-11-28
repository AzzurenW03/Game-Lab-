import java.util.ArrayList;

public class World {
    private ArrayList<Room> rooms;
    private Room startingRoom;
    private Key key;

    public World() {
        rooms = new ArrayList<>();
        startingRoom = buildWorld();  
    }

    public Room getStartingRoom() {
        return startingRoom;
    }
    

    Room currentRoom = Game.getCurrentRoom(); 
    
    public static Room buildWorld() {
        
        
    	Room graveyard = new Room("Graveyard");
        Room grandEntrance = new Room("Grand Entrance");
        Room blueDoorRoom = new Room("Blue Door Room");
        Room stairs = new Room("Stairs");
        Room creepyHallway = new Room("Creepy Hallway");
        Room bathroom = new Room("Bathroom");
        Room mainBedroom = new Room("Main Bedroom");
        Room diningRoom = new Room("Dining Room");
        Room kitchenRoom = new Room("Kitchen Room");
        Room basement = new Room("Basement");
        Room lockedRoom = new Room("Locked Room");
        
        Key key = new Key("key", "A small rusted key. It looks like it might fit a lock.", blueDoorRoom);
        
        Item ghost = new Item("ghost", "A spooky ghost floats around the graveyard, watching you.");
        Item knife = new Item("knife", "A sharp bloody knife. It seems to have been left behind in haste.");
        Item hand = new Item("hand", "A disembodied hand crawls across the floor.");
        Item oldbook = new Item("oldbook", "An old dusty book. It seems to be from a forgotten time.");
        Item flickeringcandle = new Item("flickeringcandle", "A candle flickers eerily, casting shadows on the walls.");
        
        Combination combination = new Combination("combination", "It's a strange combination lock.");
        kitchenRoom.addItem(combination);
        
        Safe safe = new Safe("safe", "It's an impressive safe!");
        diningRoom.addItem(safe);
        
        Item torch = new Torch();
        Item oldMap = new OldMap();
        Item spellbook = new Spellbook();
        
        NPC puppy = new NPC("Puppy", "Bark, Bark. I can talk as well");
        blueDoorRoom.addNPC(puppy);
        Ghost ghostNPC = new Ghost();
        graveyard.addNPC(ghostNPC);
        
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
        blueDoorRoom.addExit('s', grandEntrance);   
        grandEntrance.addExit('s', lockedRoom);    
        lockedRoom.addExit('n', grandEntrance);     
        stairs.addExit('u', creepyHallway);         
        creepyHallway.addExit('d', stairs);         
        creepyHallway.addExit('w', bathroom);       
        bathroom.addExit('e', creepyHallway);       
        creepyHallway.addExit('e', mainBedroom);    
        mainBedroom.addExit('w', creepyHallway);    
        creepyHallway.addExit('u', diningRoom);     
        diningRoom.addExit('d', creepyHallway);     
        creepyHallway.addExit('s', kitchenRoom);    
        kitchenRoom.addExit('n', creepyHallway);    
        kitchenRoom.addExit('d', basement);         
        basement.addExit('u', kitchenRoom);        
   

        
        
        
        return graveyard;  
    }
}



//Task 6: Update the Game class (Part II)
//Add cases for the commands "use" and "open" to your switch statement. Both will be similar to
//the "take" command you should already have. Once you have the Item, either from the current
//room or the player's inventory, call the appropriate method: use() or open().
//Play your game and make sure you can open the safe and retrieve the diamond.


