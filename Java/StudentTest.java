// import java.util.*;

class Student {
    public int rollNo;
    public String name;
    public String course;
    public int m1, m2, m3;

    public int total() {
        return m1 + m2 + m3;
    }

    public float average() {
        return (float) total() / 3;
    }

    public char grade() {
        if (average() >= 60) {
            return 'A';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + "\n" +
               "Name: " + name + "\n" +
               "Course: " + course + "\n";
    }
}

class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student(); // Create object

        // Set properties
        s1.rollNo = 1;
        s1.name = "Anuyash";
        s1.course = "CSE IoT";
        s1.m1 = 70;
        s1.m2 = 80;
        s1.m3 = 65;

        // Print object using toString method
        System.out.println("Details: " + s1);

        // Print details using toString method
        System.out.println("Total: " + s1.total());

        System.out.println("Average: " + s1.average());

        System.out.println("Grade: " + s1.grade());
    }
}
