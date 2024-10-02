public class NestedCatch {
    public static void main(String[] args) {
        int array [] = {30, 20, 10, 40, 0} ;
        
        try {
            int c = array [4] / array [0] ;
            System.out.println("The value of c: "+c);
            try {
                System.out.println(array[5]);
            }
            catch (ArrayIndexOutOfBoundsException eX) {
                System.out.println("Index is Invalid");
            }
        } catch(ArithmeticException aE) {
            System.out.println("Denominator should not be zero, try again...");
        }

        System.out.println("....");
    }
}
