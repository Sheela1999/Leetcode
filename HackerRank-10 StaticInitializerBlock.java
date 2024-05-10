public class Solution {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        try {
            int breadth = Integer.parseInt(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            if (breadth > 0 && height > 0) {
                int area = breadth * height;
                System.out.println(area);
            } else {
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}