class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element in arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        // Place elements of arr2 in arr1 according to their order in arr2
        for (int num : arr2) {
            while (map.get(num) > 0) {
                arr1[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        // Collect remaining elements from arr1 that are not in arr2 and sort them
        List<Integer> remainingElements = new ArrayList<>();
        for (int num : map.keySet()) {
            int count = map.get(num);
            while (count > 0) {
                remainingElements.add(num);
                count--;
            }
        }
        Collections.sort(remainingElements);

        // Place the sorted remaining elements into arr1
        for (int num : remainingElements) {
            arr1[index++] = num;
        }

        return arr1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Reading the first array
        System.out.print("Enter the number of elements in arr1: ");
        int n = scan.nextInt();
        int[] number = new int[n];
        System.out.print("Enter the elements of arr1: ");
        for (int i = 0; i < n; i++) {
            number[i] = scan.nextInt();
        }

        // Reading the second array
        System.out.print("Enter the number of elements in arr2: ");
        int n2 = scan.nextInt();
        int[] number2 = new int[n2];
        System.out.print("Enter the elements of arr2: ");
        for (int i = 0; i < n2; i++) {
            number2[i] = scan.nextInt();
        }

        // Sorting arr1 according to arr2
        Solution sol = new Solution();
        int[] result = sol.relativeSortArray(number, number2);

        // Printing the sorted array
        System.out.println("Sorted arr1: " + Arrays.toString(result));
    }
}