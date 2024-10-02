// import java.util.*;
// import java.lang.*;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int  b = 0;
        int c;
        try {
            c = a / b;
            System.out.println("The Value of C is: "+c);
        }
        catch (ArithmeticException aE) {
            System.out.println("Denominator should not be zero, try again");
        }
        System.out.println("...");
    }
}
