import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // define starting items
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Apple", "Red fruit", 20, 0.8));
        items.add(new Item("Banana", "Yellow fruit", 40, 0.3));
        items.add(new Item("Carrot", "Orange vegetable", 6, 2));

        // start command loop
        commandLoop(items);
    }

    public static void printHelp() {
        // list available commands
        System.out.println("Commands:");
        System.out.println("1. Display all items");
        System.out.println("2. Add new item");
        System.out.println("3. Edit item");
        System.out.println("4. Delete item");
        System.out.println("5. Quit");
    }

    public static void commandLoop(ArrayList<Item> items) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        printHelp(); // list available commands

        // main command loop
        while (running) {
            System.out.print("> "); // not using println here because we want the scanner to read from the same line

            switch (scanner.nextInt()) {
                case 1: // display all items
                    items.forEach((item) -> {
                        System.out.println(item.toString());
                    });
                    break;
                case 2: // add new item
                    scanner.nextLine(); // consume the trailing newline leftover from the nextInt() call

                    // get fields from user
                    System.out.print("Name> ");
                    String name = scanner.nextLine();
                    System.out.print("Description> ");
                    String description = scanner.nextLine();
                    System.out.print("Quantity> ");
                    int quantity = scanner.nextInt();
                    System.out.print("Price> ");
                    double price = scanner.nextDouble();

                    // validate inputs and add item
                    if (name.isEmpty() || description.isEmpty() || quantity < 0 || price < 0) {
                        System.out.println("One or more of the entered values are invalid.");
                    } else {
                        items.add(new Item(name, description, quantity, price));
                        System.out.println("Item added.");
                    }

                    break;
                case 3: // edit item
                    System.out.println("Not implemented");
                    break;
                case 4: // delete item
                    System.out.println("Not implemented");
                    break;
                case 5: // quit
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Please pick from the following list:");
                    printHelp();
                    break;
            }
        }
    }
}