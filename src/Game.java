

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    static ArrayList<Item> inventory = new ArrayList<>();
    private static Room currentRoom;
    private static Key key;

    private static Map<String, String> roomDescriptions = new HashMap<>();
    
   public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        populateRoomDescriptions("rooms.txt");
        runGame();
    }
    
    public static void runGame() {
        World world = new World();
        currentRoom = world.getStartingRoom();
        String command;

        do {
            print(currentRoom);
            print(getRoomDescription(currentRoom.getName())); 
            print("What do you want to do? ");
            command = input.nextLine().trim();
            String[] words = command.split(" ", 2); 
            String action = words[0].toLowerCase();  
            String itemName;
            if (words.length > 1) {
                itemName = words[1];
            } else {
                itemName = "";
            }
            switch (action) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    handleMovement(action.charAt(0)); 
                    break;

                case "x":
                    print("Thanks for walking through my game!");
                    break;

                case "take":
                    if (itemName.isEmpty()) {
                        print("Take what?");
                    } else {
                        takeItem(itemName);
                    }
                    break;

                case "look":
                    if (itemName.isEmpty()) {
                        print("Look at what?");
                    } else {
                        lookAtItem(itemName);
                    }
                    break;
               
                case "talk":
                    if (itemName.isEmpty()) {
                        print("Talk to whom?");
                    } else {
                        talkToNPC(itemName);
                    }
                    break;
                case "inventory":
                    showInventory();
                    break;

                case "use":
                    if (itemName.isEmpty()) {
                        print("Use what?");
                    } else {
                        useItem(itemName);
                    }
                    break;

                case "open":
                    if (itemName.isEmpty()) {
                        print("Open what?");
                    } else {
                        openItem(itemName);
                    }
                    break;

                default:
                    print("I don't know what that means.");
            }
        } while (!command.equals("x"));

        input.close();
    }


    private static void handleMovement(char direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            if (nextRoom.isLocked()) {
                print("The " + nextRoom.getName() + " is locked. You can't go there.");
            } else {
                print("Moving to: " + nextRoom.getName());
                currentRoom = nextRoom;
            }
        } else {
            print("You can't go that way.");
        }
    }


    private static void takeItem(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(itemName);
            print("You took the " + item.getName() + ".");
        } else {
            print("No such item in this room.");
        }
    }

    private static void lookAtItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                print(item.getDescription());
                return;
            }
        }
        Item itemInRoom = currentRoom.getItem(itemName);
        if (itemInRoom != null) {
            print(itemInRoom.getDescription());
        } else {
            print("There is no such item here.");
        }
    }

    private static void showInventory() {
        if (inventory.isEmpty()) {
            print("You are carrying nothing.");
        } else {
            print("You are carrying:");
            for (Item item : inventory) {
                print("- " + item.getName());
            }
        }
    }

    private static void useItem(String itemName) {
        Item item = getItemFromInventory(itemName);
        if (item != null) {
            item.use();  
            print("You used the " + item.getName() + ".");
        } else {
            print("You don't have that item.");
        }
    }

    private static void openItem(String itemName) {
        Item item = getItemFromInventory(itemName);
        if (item == null) {
            item = currentRoom.getItem(itemName);
        }
        if (item != null) {
            item.open(); 
            print("You opened the " + item.getName() + ".");
        } else {
            print("No such item to open.");
        }
    }
    
    private static void talkToNPC(String npcName) {
        NPC npc = currentRoom.getNPC(npcName);
        if (npc != null) {
            npc.talk(); 
        } else {
            print("There is no " + npcName + " here to talk to.");
        }
    }

    public static void print(Object obj) {
        System.out.println(obj.toString());
    }

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    public static Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    
    public static void populateRoomDescriptions(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));
            String currentRoomName = null;
            StringBuilder description = new StringBuilder();
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();

                if (line.startsWith("Room: ")) { 
                    if (currentRoomName != null) {
                        
                        roomDescriptions.put(currentRoomName, description.toString());
                    }
                    
                    currentRoomName = line.substring(6).trim();
                    description = new StringBuilder(); 
                } else {
                
                    description.append(line).append("\n");
                }
            }

            if (currentRoomName != null) {
                roomDescriptions.put(currentRoomName, description.toString());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
    }
    
    public static String getRoomDescription(String roomName) {
        return roomDescriptions.getOrDefault(roomName, "You don't see anything special here.");
    }
   
}











