
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
            roomToUnlock.unlock(); 
            Game.print("You used the " + this.getName() + " and unlocked the " + roomToUnlock.getName() + "!");
        } else {
            Game.print("This key doesn't seem to fit anywhere.");
        }
    }
}
