import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        while (true) {
            System.out.println("\n===== LinkedList Data Structure Menu =====");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display elements");
            System.out.println("4. Search element");
            System.out.println("5. Sort elements (A–Z)");
            System.out.println("6. Clear all elements");
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
                    System.out.print("Enter element to add: ");
                    String elementToAdd = input.nextLine().trim();
                    if (elementToAdd.isEmpty()) {
                        System.out.println("Element cannot be empty.");
                        break;
                    }
                    System.out.print("Add to (1) Front or (2) End? ");
                    String pos = input.nextLine();
                    if (pos.equals("1")) {
                        list.addFirst(elementToAdd);
                        System.out.println("'" + elementToAdd + "' added to the front.");
                    } else {
                        list.addLast(elementToAdd);
                        System.out.println("'" + elementToAdd + "' added to the end.");
                    }
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to remove.");
                        break;
                    }
                    System.out.print("Enter element to remove: ");
                    String elementToRemove = input.nextLine();
                    if (list.remove(elementToRemove)) {
                        System.out.println("'" + elementToRemove + "' removed successfully.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("The list is currently empty.");
                    } else {
                        System.out.println("\nCurrent LinkedList elements:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("[" + i + "] " + list.get(i));
                        }
                        System.out.println("Total elements: " + list.size());
                        System.out.println("First: " + list.getFirst() + " | Last: " + list.getLast());
                    }
                    break;

                case 4:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to search.");
                        break;
                    }
                    System.out.print("Enter element to search: ");
                    String elementToSearch = input.nextLine();
                    if (list.contains(elementToSearch)) {
                        System.out.println("'" + elementToSearch + "' found at index " + list.indexOf(elementToSearch) + ".");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 5:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to sort.");
                        break;
                    }
                    Collections.sort(list);
                    System.out.println("Elements sorted alphabetically.");
                    break;

                case 6:
                    if (list.isEmpty()) {
                        System.out.println("The list is already empty.");
                        break;
                    }
                    System.out.print("Are you sure you want to clear the list? (yes/no): ");
                    String confirm = input.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        list.clear();
                        System.out.println("List cleared successfully.");
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
