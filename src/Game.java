

import java.util.ArrayList; 
import java.util.Scanner;

public class Game {
    static ArrayList<Item> inventory = new ArrayList<>();
    private static Room currentRoom;

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        World world = new World();
        currentRoom = world.getStartingRoom();
        Scanner input = new Scanner(System.in);
        String command; 

        do {
            print(currentRoom);
            print("What do you want to do? ");
            command = input.nextLine().trim();
            String[] words = command.split(" "); 
            switch (words[0].toLowerCase()) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    Room nextRoom = currentRoom.getExit(words[0].charAt(0));
                    if (nextRoom != null) {
                        print("Moving to: " + nextRoom);
                        currentRoom = nextRoom;
                    } else {
                        print("You can't go that way.");
                    }
                    break;

                case "x":
                    print("Thanks for walking through my game!");
                    break;

                case "take":
                    if (words.length < 2) {
                        print("Take what?");
                    } else {
                        takeItem(words[1]);
                    }
                    break;

                case "look":
                    if (words.length < 2) {
                        print("Look at what?");
                    } else {
                        lookAtItem(words[1]);
                    }
                    break;

                case "inventory":
                    showInventory();
                    break;

                case "use":
                    if (words.length < 2) {
                        print("Use what?");
                    } else {
                        useItem(words[1]);
                    }
                    break;

                case "open":
                    if (words.length < 2) {
                        print("Open what?");
                    } else {
                        openItem(words[1]);
                    }
                    break;

                default:
                    print("I don't know what that means.");
            }
        } while (!command.equals("x"));

        input.close();
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
}









