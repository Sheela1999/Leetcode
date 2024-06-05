class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // The first row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // The first element of each row is always 1
            currentRow.add(1);

            // Each element is the sum of the two elements above it
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of each row is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows for Pascal's Triangle:");
        int numRows = scan.nextInt();

        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
        scan.close();
    }
}