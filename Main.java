import java.util.*;

public class Main {
    public static void main(String[] args) {


        clean implementation of singly linked list
        
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();  
        while (sc.hasNext()) {
            String cmd = sc.next();
            switch (cmd) {
                case "addFirst": {
                    String x = sc.next();
                    list.addFirst(x);
                    System.out.println(list);
                    break;
                }
                case "addLast": {
                    String x = sc.next();
                    list.addLast(x);
                    System.out.println(list);
                    break;
                }
                case "insertAt": {
                    int idx = sc.nextInt();
                    String x = sc.next();
                    list.insertAt(idx, x);
                    System.out.println(list);
                    break;
                }
                case "removeFirst": {
                    System.out.println(list.removeFirst());
                    System.out.println(list);
                    break;
                }
                case "removeLast": {
                    System.out.println(list.removeLast());
                    System.out.println(list);
                    break;
                }
                case "removeAt": {
                    int idx = sc.nextInt();
                    System.out.println(list.removeAt(idx));
                    System.out.println(list);
                    break;
                }
                case "get": {
                    int idx = sc.nextInt();
                    System.out.println(list.get(idx));
                    break;
                }
                case "set": {
                    int idx = sc.nextInt();
                    String x = sc.next();
                    System.out.println(list.set(idx, x));
                    System.out.println(list);
                    break;
                }
                case "indexOf": {
                    String x = sc.next();
                    System.out.println(list.indexOf(x));
                    break;
                }
                case "contains": {
                    String x = sc.next();
                    System.out.println(list.contains(x));
                    break;
                }
                case "size": {
                    System.out.println(list.size());
                    break;
                }
                case "clear": {
                    list.clear();
                    System.out.println(list);
                    break;
                }
                case "quit": return;
                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }
    }
}