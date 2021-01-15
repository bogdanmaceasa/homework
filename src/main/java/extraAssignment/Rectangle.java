package extraAssignment;

import java.util.Objects;


public class Rectangle extends Shape{

    private double area;
    private double perimeter;
    private double length, height;

    public Rectangle(double length, double height){
        this.length= length;
        this.height= height;
        this.perimeter = (this.length + this.height)*2;
        this.area = this.length*this.height;
    }

    @Override
    public void getArea(){
        System.out.println("Area for Triangle is: " + this.area );
    }
    @Override
    public void getPerimeter(){
        System.out.println("Area for Triangle is: " + this.perimeter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.area, area) == 0 && Double.compare(rectangle.perimeter, perimeter) == 0 && Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, length, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
