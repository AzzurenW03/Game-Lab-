
public class Key extends Item {
    private Room roomToUnlock;  

    public Key(String name, String description, Room roomToUnlock) {
        super(name, description);
        this.roomToUnlock = roomToUnlock;
    }

    public Room getRoomToUnlock() {
        return roomToUnlock;
    }

    
    public void use() {
        if (roomToUnlock != null && roomToUnlock.isLocked()) {
            if (Game.getCurrentRoom().getName().equals("Grand Entrance")) {
                roomToUnlock.unlock();
                Game.print("You used the " + getName() + " and unlocked the " + roomToUnlock.getName() + "!");
            } else { 
                Game.print("You must be in an adjacent room to use this key.");
            }
        } else {
            Game.print("This key doesn't seem to fit anywhere.");
        }
    }
    
    }
