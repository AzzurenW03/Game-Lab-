import java.util.HashMap;

public class Room {
	private  String description;
    private Item item;
	private Room east;
	private Room west;
	private Room Up;
	private Room Down; 
	private Room north;
	private Room south;
	private HashMap<String, Item>items;
 public Room(String d) {
        description = d;
        items = new HashMap<>();
    }
 //This method is given a char parameter (which will be either 'e', 'w', 'n', 's', 'u', or 'd') and returns
 //the appropriate Room variable. If the parameter is not one of the six expected characters, the
 //method must return null
 public Room getExit(char c) {
	 if (c =='e')
		 return east;
	 else if(c == 'w')
		 return west;
	 else if (c =='n')
	 return north; 
	 else if (c =='s') 
		 return south;
	 else if (c =='u')
		 return Up; 
	 else if (c =='d')
		 return Down; 
	 return null; 
	 
 }
 //This method is given two parameters: a Room object and a direction (as a char). The purpose of
 //the method is to update one of the object's Room variables. It uses the given direction to
// determine which variable to update. Update the variable by setting it to the given Room object
 public void addExit(char d, Room R ) {
	if (d == 'e' )
		east = R;
	if(d == 'w')
		west = R;
	if (d == 'n')
		north = R;
	if (d == 's')
		south = R;
	if (d == 'u')
		Up = R;
	if (d == 'd')
		Down = R;
 }
 
// Add a toString method to the Room class. Refer to other examples of toString methods we've
// seen. All this method needs to do is return the room's description.
 
 public String toString() {
	 return description;
 }
 
 public String getDescription() {
     return description;
 }
 public Item getItem(String name) {
	    return items.get(name.toLowerCase()); 
	}

 public void setItem(Item i) {
     item = i;
 }
 
 public void addItem(Item item) {
     items.put(item.getName(), item);
 }
 public Item removeItem(String name) {
     return items.remove(name); 
 }
 
 
} 


