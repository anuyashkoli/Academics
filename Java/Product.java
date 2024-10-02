import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        int n1, n2, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Number: ");
        n1 = sc.nextInt();
        System.out.println("Enter the Second Number: ");
        n2 = sc.nextInt();
        sc.close();
        result = n1 * n2;
        System.out.println("Product of "+n1+" and "+n2+" is: "+result);
    }
}
