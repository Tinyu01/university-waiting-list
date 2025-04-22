package main.java.com.university.waitinglist;

import java.util.Scanner;

public class WaitingList {
    public static void main(String[] args) {
        ListManager manager = new ListManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent(manager, scanner);
                    break;
                case 2:
                    manager.listStudents();
                    break;
                case 3:
                    searchStudent(manager, scanner);
                    break;
                case 4:
                    updateStatus(manager, scanner);
                    break;
                case 5:
                    removeStudent(manager, scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nUniversity Waiting List System");
        System.out.println("1. Add Student");
        System.out.println("2. List All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Status");
        System.out.println("5. Remove Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent(ListManager manager, Scanner scanner) {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();
        
        manager.addStudent(new Student(id, fname, lname, Status.UNDER_REVIEW));
        System.out.println("Student added successfully!");
    }

    private static void searchStudent(ListManager manager, Scanner scanner) {
        System.out.print("\nEnter Student ID to search: ");
        String id = scanner.nextLine();
        manager.findStudent(id);
    }

    private static void updateStatus(ListManager manager, Scanner scanner) {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        
        Status newStatus = null;
        while (newStatus == null) {
            System.out.print("Enter new status (ENROLLED/UNDER_REVIEW/REJECTED): ");
            String statusInput = scanner.nextLine().toUpperCase();
            
            try {
                newStatus = Status.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status! Please try again.");
            }
        }
        
        manager.updateStatus(id, newStatus);
    }

    private static void removeStudent(ListManager manager, Scanner scanner) {
        System.out.print("\nEnter Student ID to remove: ");
        String id = scanner.nextLine();
        manager.removeStudent(id);
    }
}