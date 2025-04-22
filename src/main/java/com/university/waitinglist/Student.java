package main.java.com.university.waitinglist;

public class Student {
    private final String studentId;
    private String firstName;
    private String lastName;
    private Status status;

    public Student(String id, String fname, String lname, Status status) {
        this.studentId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.status = status;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Status getStatus() { return status; }
    
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | Status: %-12s",
                studentId, lastName + ", " + firstName, status);
    }
}