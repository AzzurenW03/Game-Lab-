 import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static ArrayList<Item> inventory = new ArrayList<>();
    private World world;
    private Room currentRoom;

    public Game() {
        world = new World();
        currentRoom = world.getStartingRoom();
    }

    public void runGame() {
        Scanner input = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println(currentRoom);
            System.out.print("What do you want to do? ");
            command = input.nextLine().trim();

            String[] words = command.split(" ");
            switch (words[0]) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    Room nextRoom = currentRoom.getExit(command.charAt(0));
                    if (nextRoom != null) {
                        System.out.println("Moving to: " + nextRoom);
                        currentRoom = nextRoom;
                    } else {
                        System.out.println("You can't go that way.");
                    }
                    break;

                case "x":
                    System.out.println("Thanks for walking through my game!");
                    return; 

                case "take":
                    if (words.length < 2) {
                        System.out.println("Take what?");
                    } else {
                        takeItem(words[1]);
                    }
                    break;

                case "look":
                    if (words.length < 2) {
                        System.out.println("Look at what?");
                    } else {
                        lookAtItem(words[1]);
                    }
                    break;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void takeItem(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(itemName); 
            System.out.println("You took the " + item.getName() + ".");
        } else {
            System.out.println("No such item in this room.");
        }
    }

    private void lookAtItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.println(item.getDescription());
                return;
            }
        }

        
        Item itemInRoom = currentRoom.getItem(itemName);
        if (itemInRoom != null) {
            System.out.println(itemInRoom.getDescription());
        } else {
            System.out.println("There is no such item here.");
        }
    }


    private void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You are carrying nothing.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.runGame(); 
    }
}








