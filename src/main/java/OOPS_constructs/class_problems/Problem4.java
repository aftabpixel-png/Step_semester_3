package main.java.OOPS_constructs.class_problems;

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid Member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.print("General | Books: " + booksBorrowed);
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.print("Student | Course: " + course
                + " | Books: " + booksBorrowed);
    }

    public String getCourse() {
        return course;
    }
}

public class Problem4 {

    static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {
            StringBuilder line = new StringBuilder();

            // Polymorphic method call
            java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();

            java.io.PrintStream original = System.out;

            System.setOut(new java.io.PrintStream(output));
            member.displayInfo();
            System.setOut(original);

            line.append(output.toString().trim());

            // Safe downcasting
            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;

                line.append(" [Course via downcast: ")
                        .append(student.getCourse())
                        .append("]");
            }

            report.append(line).append(" | ");
        }

        return report.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
                new LibraryMember("LB5", 3),
                new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}
