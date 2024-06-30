public class ZigzagConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string to convert:");
        String s = scanner.nextLine();

        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();

        System.out.println("Converted string: " + convert(s, numRows));
        scanner.close();
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        // Create an array of StringBuilder objects to hold each row
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Append the character to the current row
            rows[curRow].append(c);

            // Change direction if we're at the first or last row
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row in the current direction
            curRow += goingDown ? 1 : -1;
        }

        // Combine all rows to get the final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}