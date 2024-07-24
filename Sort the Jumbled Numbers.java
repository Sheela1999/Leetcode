import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                long mappedA = getMappedValue(mapping, a);
                long mappedB = getMappedValue(mapping, b);
                return Long.compare(mappedA, mappedB);
            }
        });

        int[] sortedArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sortedArray[i] = list.get(i);
        }
        return sortedArray;
    }

    public static long getMappedValue(int[] mapping, int num) {
        String numStr = Integer.toString(num);
        StringBuilder mappedValue = new StringBuilder();

        for (char ch : numStr.toCharArray()) {
            int digit = ch - '0';
            mappedValue.append(mapping[digit]);
        }

        return Long.parseLong(mappedValue.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] mapping = new int[10];
        System.out.println("Enter the mapping array (10 integers):");
        for (int i = 0; i < 10; i++) {
            mapping[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements in the nums array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the nums array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        scanner.close();

        Solution solution = new Solution();
        int[] sortedArray = solution.sortJumbled(mapping, nums);

        System.out.println("Sorted array based on mapped values:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
