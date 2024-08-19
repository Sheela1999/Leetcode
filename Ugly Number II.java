public class UglyNumber {
    
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0; // Base case
        
        // Min-Heap to keep track of the smallest ugly number
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        // Initial ugly number
        heap.add(1L);
        seen.add(1L);
        
        long ugly = 1;
        
        for (int i = 0; i < n; i++) {
            ugly = heap.poll(); // Extract the smallest ugly number
            if (!seen.contains(ugly * 2)) {
                heap.add(ugly * 2);
                seen.add(ugly * 2);
            }
            if (!seen.contains(ugly * 3)) {
                heap.add(ugly * 3);
                seen.add(ugly * 3);
            }
            if (!seen.contains(ugly * 5)) {
                heap.add(ugly * 5);
                seen.add(ugly * 5);
            }
        }
        
        return (int) ugly; // nth ugly number
    }
}	