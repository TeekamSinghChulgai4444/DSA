package LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> printerQueue = new LinkedList<>();

        // 1. Insert Operations
        printerQueue.add("Document_1.pdf");    // Throws exception if full
        printerQueue.offer("Photo_2.png");     // Returns false if full
        printerQueue.offer("Spreadsheet_3.xlsx");
        System.out.println("Current Queue: " + printerQueue);

        // 2. Examine Operations (Look at the front)
        System.out.println("Next up (peek): " + printerQueue.peek());       // Returns null if empty
        System.out.println("Next up (element): " + printerQueue.element()); // Throws exception if empty

        // 3. Remove Operations (Take from the front)
        System.out.println("Printed (poll): " + printerQueue.poll());       // Returns null if empty
        System.out.println("Printed (remove): " + printerQueue.remove());   // Throws exception if empty
        System.out.println("Queue after removals: " + printerQueue);

        // 4. Helper Utilities
        System.out.println("Remaining size: " + printerQueue.size());
        System.out.println("Contains 'Photo_2.png'?: " + printerQueue.contains("Photo_2.png"));
        System.out.println("Is queue empty?: " + printerQueue.isEmpty());

        printerQueue.clear();
        System.out.println("Is empty after clear()?: " + printerQueue.isEmpty());
    }
}