package week10;

public class AssignmentQueue {
    int max;
    int front;
    int rear;
    int size;
    StudentQueue[] stdQueue;

    AssignmentQueue(int max) {
        this.max = max;
        Create();
    }

    void Create() {
        stdQueue = new StudentQueue[max];
        size = 0;
        front = rear = -1;
    }

    boolean IsEmpty() {
        return (size == 0);
    }

    boolean IsFull() {
        return (size == max);
    }

    void Enqueue(StudentQueue stdQueue) {
        if (IsFull()) {
            System.out.println("Queue is Full");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            this.stdQueue[rear] = stdQueue;
            size++;
        }
    }

    StudentQueue Dequeue() {
        StudentQueue data = null;
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            data = stdQueue[front];
            front = (front + 1) % max;
            size--;
        }
        return data;
    }

    void print() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(stdQueue[i].nim + " " + stdQueue[i].name + " " + stdQueue[i].classNumber + " " + stdQueue[i].gpa);
                i = (i + 1) % max;
            }
            System.out.println(stdQueue[i].nim + " " + stdQueue[i].name + " " + stdQueue[i].classNumber + " " + stdQueue[i].gpa);
        }
    }

    void peek() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("First student in queue: " + stdQueue[front].nim + " " + stdQueue[front].name + " " + stdQueue[front].classNumber + " " + stdQueue[front].gpa);
        }
    }

    void peekRear() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Last student in queue: " + stdQueue[rear].nim + " " + stdQueue[rear].name + " " + stdQueue[rear].classNumber + " " + stdQueue[rear].gpa);
        }
    }

    void peekPosition(String nim) {
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            int i = front;
            boolean found = false;
            while (i != rear) {
                if (stdQueue[i].nim.equals(nim)) {
                    System.out.println("Student found: " + stdQueue[i].nim + " " + stdQueue[i].name + " " + stdQueue[i].classNumber + " " + stdQueue[i].gpa);
                    found = true;
                    break;
                }
                i = (i + 1) % max;
            }
            if (!found && stdQueue[i].nim.equals(nim)) {
                System.out.println("Student found: " + stdQueue[i].nim + " " + stdQueue[i].name + " " + stdQueue[i].classNumber + " " + stdQueue[i].gpa);
            } else if (!found) {
                System.out.println("Student with NIM " + nim + " not found in the queue.");
            }
        }
    }

    void printStudents(int position) {
        if (IsEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            if (position < 0 || position >= size) {
                System.out.println("Invalid position");
            } else {
                int actualPosition = (front + position) % max;
                System.out.println("Student at position " + position + ": " + stdQueue[actualPosition].nim + " " + stdQueue[actualPosition].name + " " + stdQueue[actualPosition].classNumber + " " + stdQueue[actualPosition].gpa);
            }
        }
    }
}