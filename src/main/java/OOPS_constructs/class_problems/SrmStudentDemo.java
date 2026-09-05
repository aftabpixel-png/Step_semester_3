public class SrmStudentDemo {
    static class SrmStudent {
        static String collegeName;
        static String academicYear;
        String name;

        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2025-26";
            System.out.println("College info loaded");
        }

        SrmStudent(String name) {
            this.name = name;
            System.out.println("Student record created: " + name);
        }
    }

    public static void main(String[] args) {
        String[] names = { "Ravi", "Meera", "Karthik", "Divya", "Anitha" };

        SrmStudent[] students = new SrmStudent[names.length];
        for (int i = 0; i < names.length; i++) {
            students[i] = new SrmStudent(names[i]);
        }
    }
}