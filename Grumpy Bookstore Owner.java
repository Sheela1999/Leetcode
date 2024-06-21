public class BookstoreGrumpy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.println("Enter the number of minutes (n):");
        int n = scanner.nextInt();

        int[] customers = new int[n];
        int[] grumpy = new int[n];

        System.out.println("Enter the number of customers for each minute:");
        for (int i = 0; i < n; i++) {
            customers[i] = scanner.nextInt();
        }

        System.out.println("Enter the grumpy status for each minute (0 or 1):");
        for (int i = 0; i < n; i++) {
            grumpy[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of consecutive minutes (minutes):");
        int minutes = scanner.nextInt();

        scanner.close();

        // Calculate maximum satisfied customers
        int result = maxSatisfied(customers, grumpy, minutes);
        System.out.println("The maximum number of satisfied customers is: " + result);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        // Calculate the number of satisfied customers without any secret technique
        int totalSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }

        // Calculate the additional satisfied customers if the secret technique is used
        int additionalSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }

        int maxAdditionalSatisfied = additionalSatisfied;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return totalSatisfied + maxAdditionalSatisfied;
    }
}