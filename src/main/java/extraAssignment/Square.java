package extraAssignment;


import lombok.ToString;

import java.util.Objects;


public class Square extends Shape {

    private double area;
    private double perimeter;
    private double length;

    public Square(double length) {
        this.length = length;
        this.perimeter = this.length * 4;
        this.area = this.length * this.length;
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
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.area, area) == 0 && Double.compare(square.perimeter, perimeter) == 0 && Double.compare(square.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, length);
    }

    @Override
    public String toString() {
        return "Square{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", length=" + length +
                '}';
    }
}
