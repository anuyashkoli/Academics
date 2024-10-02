// import java.lang.*;
// import java.util.*;

abstract class Bank {
    abstract float getROI();
}

class SBI extends Bank {
    float getROI() {
        return 5.5f;
    }
}

class PNB extends Bank {
    float getROI() {
        return 9.0f;
    }
}

class AbstractTest {
    public static void main(String[] args) {
        Bank branch;
        branch = new SBI();
        System.out.println("Rate Of Interest is: "+branch.getROI()+" %");

        branch = new PNB();
        System.out.println("Rate Of Interest is: "+branch.getROI()+" %");
    }
}