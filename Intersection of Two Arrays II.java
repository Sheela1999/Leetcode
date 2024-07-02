public class ArrayIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first array
        System.out.println("Enter the number of elements in nums1:");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter the elements of nums1:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        // Read the second array
        System.out.println("Enter the number of elements in nums2:");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter the elements of nums2:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        // Find the intersection
        int[] result = intersect(nums1, nums2);

        // Print the result
        System.out.println("Intersection of the arrays:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // Use a HashMap to store the frequency of each element in nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Use a List to collect the intersection elements
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert the List to an array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}