public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Pushes element x to the back of the queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of the queue and returns it.
    public int pop() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2 to reverse order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Returns the element at the front of the queue.
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2 to reverse order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue myQueue = new MyQueue();

        while (true) {
            System.out.println("Enter operation: push x, pop, peek, empty, or exit");
            String operation = scanner.nextLine();

            if (operation.startsWith("push")) {
                int value = Integer.parseInt(operation.split(" ")[1]);
                myQueue.push(value);
                System.out.println("Pushed " + value);
            } else if (operation.equals("pop")) {
                int value = myQueue.pop();
                System.out.println("Popped " + value);
            } else if (operation.equals("peek")) {
                int value = myQueue.peek();
                System.out.println("Front of the queue: " + value);
            } else if (operation.equals("empty")) {
                boolean isEmpty = myQueue.empty();
                System.out.println("Queue is empty: " + isEmpty);
            } else if (operation.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }

        scanner.close();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */