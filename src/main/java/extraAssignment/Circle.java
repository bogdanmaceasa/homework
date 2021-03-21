package extraAssignment;


import java.util.Objects;

public class Circle extends Shape {

    private double area;
    private double perimeter;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * this.radius * this.radius;
        this.perimeter = this.radius * 2 * Math.PI;
    }

    @Override
    public void getArea() {
        System.out.println("Area for Triangle is: " + this.area);
    }

    @Override
    public void getPerimeter() {
        System.out.println("Area for Triangle is: " + this.perimeter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.area, area) == 0 && Double.compare(circle.perimeter, perimeter) == 0 && Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", radius=" + radius +
                '}';
    }
}
