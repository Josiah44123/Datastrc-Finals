import java.util.ArrayList;
import java.util.Scanner;

public class DataStructurePranctice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Simple Data Structure (ArrayList) =====");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display elements");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = input.nextInt();
            input.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String elementToAdd = input.nextLine();
                    list.add(elementToAdd);
                    System.out.println(elementToAdd + " added!");
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    String elementToRemove = input.nextLine();
                    if (list.remove(elementToRemove)) {
                        System.out.println(elementToRemove + " removed!");
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 3:
                    System.out.println("Current elements: " + list);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
