import java.util.HashMap;

public class Room {
    private String name;
    private boolean locked;  
    private Item item;
    private HashMap<String, Item> items;
    private Room east, west, north, south, up, down;
  

    public Room(String name) {
        this.name = name;
        this.locked = false;  
        items = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Game.getRoomDescription(name);
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public void addExit(char direction, Room room) {
        switch (direction) {
            case 'e': east = room; 
            break;
            case 'w': west = room; 
            break;
            case 'n': north = room; 
            break;
            case 's': south = room; 
            break;
            case 'u': up = room; 
            break;
            case 'd': down = room; 
            break;
        }
    }

    public Room getExit(char direction) {
        switch (direction) {
            case 'e': return east;
            case 'w': return west;
            case 'n': return north;
            case 's': return south;
            case 'u': return up;
            case 'd': return down;
            default: return null;
        }
    }

    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public Item getItem(String name) {
        return items.get(name.toLowerCase());
    }

    public void removeItem(String name) {
        items.remove(name.toLowerCase());
    }

    
    public String toString() {
        return getDescription(); 
    }
    
    
}






