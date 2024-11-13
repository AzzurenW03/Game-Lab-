
public class OldMap extends Item {
    public OldMap() {
        super("Old Map", "An old, crumpled map with hidden rooms marked.");
    }

    
    public void use() {
        Game.print("You study the map and find a secret passage leading to the Basement.");
        
    }
}
