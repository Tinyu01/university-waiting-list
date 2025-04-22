package main.java.com.university.waitinglist;

import java.util.HashMap;
import java.util.Scanner;

public class ListManager {
    private final HashMap<String, Student> studentsMap;
    private final Scanner scanner;

    public ListManager() {
        this.studentsMap = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        studentsMap.put(student.getStudentId(), student);
    }

    public void listStudents() {
        if (studentsMap.isEmpty()) {
            System.out.println("\nNo students in the waiting list.");
            return;
        }
        System.out.println("\nCurrent Waiting List:");
        studentsMap.values().forEach(System.out::println);
    }

    public void findStudent(String studentId) {
        Student student = studentsMap.get(studentId);
        if (student != null) {
            System.out.println("\nStudent Found:");
            System.out.println(student);
        } else {
            System.out.println("\nStudent with ID " + studentId + " not found.");
        }
    }

    public void updateStatus(String studentId, Status newStatus) {
        Student student = studentsMap.get(studentId);
        if (student != null) {
            Status oldStatus = student.getStatus();
            student.setStatus(newStatus);
            System.out.printf("\nUpdated %s %s's status from %s to %s\n",
                    student.getFirstName(), student.getLastName(), oldStatus, newStatus);
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    public void removeStudent(String studentId) {
        Student removed = studentsMap.remove(studentId);
        if (removed != null) {
            System.out.println("\nRemoved student:");
            System.out.println(removed);
        } else {
            System.out.println("\nStudent not found.");
        }
    }
}