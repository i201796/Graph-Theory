public class Queue {
    private Node[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.queue = new Node[this.capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public void enqueue(Node node) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            this.queue[this.rear] = node;
            this.size++;
        }
    }

    public Node dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            Node temp = this.queue[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return temp;
        }
    }

    public Node peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return this.queue[this.front];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = 0; i < this.size; i++) {
                System.out.print(this.queue[(this.front + i) % this.capacity].getLabel() + " ");
            }
            System.out.println();
        }
    }
}
