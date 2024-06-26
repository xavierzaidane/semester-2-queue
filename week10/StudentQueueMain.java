package week10;

import java.util.Scanner;

public class StudentQueueMain {
    static void menu() {
        System.out.println("Choose menu:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Check first queue element");
        System.out.println("4. Check last queue element");
        System.out.println("5. Check all queue elements");
        System.out.println("6. Peek by position");
        System.out.println("7. Peek by NIM");
        System.out.println("8. Clear");
        System.out.println("================================");
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter max size: ");
        int max = sc.nextInt();
        AssignmentQueue Q = new AssignmentQueue(max);

        int choose;
        do {
            menu();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter class number: ");
                    int classNumber = sc.nextInt();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();

                    StudentQueue s = new StudentQueue(nim, name, classNumber, gpa);
                    Q.Enqueue(s);
                    break;
                case 2:
                    StudentQueue data = Q.Dequeue();
                    if (data != null) {
                        System.out.println("Data removed: " + data.nim + " " + data.name + " " + data.classNumber + " " + data.gpa);
                    }
                    break;
                case 3:
                    Q.peek();
                    break;
                case 4:
                    Q.peekRear();
                    break;
                case 5:
                    Q.print();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    int position = sc.nextInt();
                    Q.printStudents(position);
                    break;
                case 7:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter NIM: ");
                    nim = sc.nextLine();
                    Q.peekPosition(nim);
                    break;
                case 8:
                    Q.Create();
                    System.out.println("Queue is cleared");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (true); // removed the exit condition
    }
}