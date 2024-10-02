class Cylinder {
    private int radius;
    private int height;

    public Cylinder() { // Non-parameterized Constructor
        radius = height = 1;
    }

    public Cylinder(int r, int h) { // Parameterized Constructor
        radius = r;
        height = h;
    }

    public Cylinder(Cylinder p) { // Copy Constructor
        radius = p.radius;
        height = p.height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int r) {
        radius = r;
    }

    public void setDimensions(int h, int r) {
        height = h;
        radius = r;
    }

    public double lidArea() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double drumArea() {
        return 2 * lidArea() + perimeter() * height;
    }

    public double volume() {
        return lidArea() * height;
    }

    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        c.setHeight(10);
        c.setRadius(7);

        System.out.println("Set parameter by getter and setter Method");
        System.out.println("Height: " + c.getHeight());
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Lid Area: " + c.lidArea());
        System.out.println("Circumference: " + c.perimeter());
        System.out.println("Total Surface Area: " + c.drumArea());
        System.out.println("Volume: " + c.volume());

        System.out.println("\nSet parameter by calling Non-parameterized Constructor");
        Cylinder c1 = new Cylinder();
        System.out.println("Height: " + c1.getHeight());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Lid Area: " + c1.lidArea());
        System.out.println("Circumference: " + c1.perimeter());
        System.out.println("Total Surface Area: " + c1.drumArea());
        System.out.println("Volume: " + c1.volume());

        System.out.println("\nSet parameter by calling Parameterized Constructor");
        Cylinder c2 = new Cylinder(15, 20);
        System.out.println("Height: " + c2.getHeight());
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Lid Area: " + c2.lidArea());
        System.out.println("Circumference: " + c2.perimeter());
        System.out.println("Total Surface Area: " + c2.drumArea());
        System.out.println("Volume: " + c2.volume());

        System.out.println("\nSet parameter by copy constructor");
        Cylinder c3 = new Cylinder(c2);
        System.out.println("Height: " + c3.getHeight());
        System.out.println("Radius: " + c3.getRadius());
        System.out.println("Lid Area: " + c3.lidArea());
        System.out.println("Circumference: " + c3.perimeter());
        System.out.println("Total Surface Area: " + c3.drumArea());
        System.out.println("Volume: " + c3.volume());
    }
}
