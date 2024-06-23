class MyStack {
    // Define two queues
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // Always push to queue1
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // The last element of queue1 is the top element of the stack
        int topElement = queue1.remove();

        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    /** Get the top element. */
    public int top() {
        // Similar to pop, but we need to re-add the last element back to queue1
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topElement = queue1.remove();
        queue2.add(topElement);

        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        
        while (true) {
            System.out.println("Choose an operation: push, pop, top, empty, exit");
            String operation = scanner.next();
            
            if (operation.equals("push")) {
                System.out.print("Enter the element to push: ");
                int x = scanner.nextInt();
                myStack.push(x);
                System.out.println("Element " + x + " pushed onto the stack.");
            } else if (operation.equals("pop")) {
                if (!myStack.empty()) {
                    int poppedElement = myStack.pop();
                    System.out.println("Element " + poppedElement + " popped from the stack.");
                } else {
                    System.out.println("Stack is empty.");
                }
            } else if (operation.equals("top")) {
                if (!myStack.empty()) {
                    int topElement = myStack.top();
                    System.out.println("Top element is " + topElement);
                } else {
                    System.out.println("Stack is empty.");
                }
            } else if (operation.equals("empty")) {
                System.out.println("Is stack empty? " + myStack.empty());
            } else if (operation.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid operation. Please choose again.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}