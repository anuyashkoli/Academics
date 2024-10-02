import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter your Name: ");
        String name = sc.nextLine();
        System.out.printf("Enter your Gender: ");
        char gender = sc.next().charAt(0);
        System.out.printf("Enter your Age: ");
        int age = sc.nextInt();
        System.out.printf("Enter your Mobile Number: ");
        long mobile = sc.nextLong();
        System.out.printf("Enter your CGPA: ");
        double CGPA = sc.nextDouble();
        sc.close();

        System.out.println("");
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
        System.out.println("Mobile No: "+mobile);
        System.out.println("CGPA: "+CGPA);
    }
}
