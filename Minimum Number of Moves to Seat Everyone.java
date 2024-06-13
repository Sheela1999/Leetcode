class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int minMoves = 0;

        for(int i = 0; i < seats.length; i++){
            minMoves += Math.abs(seats[i] - students[i]);
        }
        return minMoves;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] noOfSeats = new int[n];
        int[] noOfStudents = new int[n];

        for(int i = 0; i < n; i++){
            noOfSeats[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++){
            noOfStudents[i] = scan.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.minMovesToSeat(noOfSeats, noOfStudents);
        System.out.println(result);

        scan.close();
    }
}

Explanation:
Sorting:

First, we sort both the seats and students arrays. This ensures that we pair each student with the closest available seat.
Example:
For seats = [3, 1, 5], sorting gives [1, 3, 5].
For students = [2, 7, 4], sorting gives [2, 4, 7].
Calculating Moves:

We then iterate through the sorted arrays and calculate the total number of moves required by taking the absolute difference between the positions of each paired seat and student.
Example:
After sorting: seats = [1, 3, 5] and students = [2, 4, 7].
Pair each student to each seat: (1, 2), (3, 4), (5, 7).
Moves:
First student moves from 2 to 1: |2 - 1| = 1
Second student moves from 4 to 3: |4 - 3| = 1
Third student moves from 7 to 5: |7 - 5| = 2
Total moves: 1 + 1 + 2 = 4.