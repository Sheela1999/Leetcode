import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor to initialize the class with k and the initial stream of numbers
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k); // Initialize a min-heap with capacity k
        
        // Add all elements from nums to the heap
        for (int num : nums) {
            add(num);  // Use the add function to maintain the k largest elements
        }
    }

    // Method to add a new value to the stream and return the kth largest element
    public int add(int val) {
        // Add the new value to the heap
        if (minHeap.size() < k) {
            minHeap.offer(val);  // Add directly if the heap is not full
        } else if (val > minHeap.peek()) {
            minHeap.poll();  // Remove the smallest element
            minHeap.offer(val);  // Add the new element
        }

        // The kth largest element is at the root of the min-heap
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));  // return 4
        System.out.println(kthLargest.add(5));  // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9));  // return 8
        System.out.println(kthLargest.add(4));  // return 8
    }
}
