import java.util.*;;

class Data {
    protected float r;

    public void read(float x) {
        r = x;
    }
}

class Area extends Data {
    protected float area;

    public void calculate() {
        area = (float) 3.14 * r * r;
    }

    public void display() {
        System.out.println("Area = " + area);
    }
}

class Volume extends Area {
    protected float volume;

    public void compute() {
        volume = (float) (area * r * 4 / 3);
    }

    public void display() {
        System.out.println("Volume = " + volume);
    }
}

class OverridingSpVol {
    public static void main(String[] args) {
        float x;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the radius:");
        x = sc.nextFloat();
        sc.close();

        Volume a = new Volume();
        a.read(x);
        a.calculate();
        a.compute();
        a.display();
    }
}
