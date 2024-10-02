class Circle {
    public double radius ;
    public double area() {
        return Math.PI*radius*radius ;
    }
}

class Cylinder extends Circle {
    public double height; 
    public double volume() {
        return area() * height ;
    }
}

public class CylindricalInheritance {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        c.radius = 9;
        c.height = 18;
        System.out.println("Voulume Of Cylinder: "+c.volume());
    }
}