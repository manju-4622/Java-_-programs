import java.util.*;
public class MiniHeap.java {
    public static void main(String[] args) {
        // Use PriorityQueue with Integer type
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add elements
        minHeap.add(10);
        minHeap.add(6);
        minHeap.add(20);
        minHeap.add(3);
        
        // Remove and print elements
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}