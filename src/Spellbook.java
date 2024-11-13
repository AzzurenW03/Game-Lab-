
public class Spellbook extends Item {
    public Spellbook() {
        super("Spellbook", "A dusty book with ancient spells.");
    }

    
    public void use() {
        Game.print("You chant an incantation from the spellbook and the heavy iron door creaks open!");
        
    }
}
