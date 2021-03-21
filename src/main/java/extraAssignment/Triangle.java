package extraAssignment;


import java.util.Objects;

public class Triangle extends Shape {

    private double area;
    private double perimeter;
    private double side1, side2, side3;


    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.perimeter = this.side1 + this.side2 + this.side3;
        double semi = this.perimeter / 2;
        this.area = Math.sqrt(semi * (semi - this.side1) * (semi - this.side2) * (semi - this.side3));
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
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.area, area) == 0 && Double.compare(triangle.perimeter, perimeter) == 0 && Double.compare(triangle.side1, side1) == 0 && Double.compare(triangle.side2, side2) == 0 && Double.compare(triangle.side3, side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, side1, side2, side3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
