import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A simple program demonstrating HashMap operations in Java.
 *
 * Features:
 * 1. Add key-value pair
 * 2. Remove key
 * 3. Update value
 * 4. Search by key
*/
public class HashMapPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();

        while (true) {
            System.out.println("\n===== HashMap Data Structure Menu =====");
            System.out.println("1. Add key-value pair");
            System.out.println("2. Remove key");
            System.out.println("3. Update value");
            System.out.println("4. Search by key");
            System.out.println("5. Display all entries");
            System.out.println("6. Clear all entries");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1–7): ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1–7).");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = input.nextLine().trim();
                    if (key.isEmpty()) {
                        System.out.println("Key cannot be empty.");
                        break;
                    }
                    if (map.containsKey(key)) {
                        System.out.println("Key already exists. Use the update option instead.");
                        break;
                    }
                    System.out.print("Enter value: ");
                    String value = input.nextLine().trim();
                    map.put(key, value);
                    System.out.println("Pair added: {" + key + " = " + value + "}");
                    break;

                case 2:
                    if (map.isEmpty()) {
                        System.out.println("The map is empty. Nothing to remove.");
                        break;
                    }
                    System.out.print("Enter key to remove: ");
                    String keyToRemove = input.nextLine();
                    if (map.remove(keyToRemove) != null) {
                        System.out.println("Key '" + keyToRemove + "' removed successfully.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 3:
                    if (map.isEmpty()) {
                        System.out.println("The map is empty. Nothing to update.");
                        break;
                    }
                    System.out.print("Enter key to update: ");
                    String keyToUpdate = input.nextLine();
                    if (map.containsKey(keyToUpdate)) {
                        System.out.print("Enter new value: ");
                        String newValue = input.nextLine();
                        map.put(keyToUpdate, newValue);
                        System.out.println("Key '" + keyToUpdate + "' updated to value '" + newValue + "'.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 4:
                    if (map.isEmpty()) {
                        System.out.println("The map is empty. Nothing to search.");
                        break;
                    }
                    System.out.print("Enter key to search: ");
                    String keyToSearch = input.nextLine();
                    if (map.containsKey(keyToSearch)) {
                        System.out.println("Found: {" + keyToSearch + " = " + map.get(keyToSearch) + "}");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 5:
                    if (map.isEmpty()) {
                        System.out.println("The map is currently empty.");
                    } else {
                        System.out.println("\nCurrent HashMap entries:");
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            System.out.println("{" + entry.getKey() + " = " + entry.getValue() + "}");
                        }
                        System.out.println("Total entries: " + map.size());
                    }
                    break;

                case 6:
                    if (map.isEmpty()) {
                        System.out.println("The map is already empty.");
                        break;
                    }
                    System.out.print("Are you sure you want to clear all entries? (yes/no): ");
                    String confirm = input.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        map.clear();
                        System.out.println("All entries cleared successfully.");
                    } else {
                        System.out.println("Clear action canceled.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye.");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
