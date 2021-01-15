package extraAssignment;

/*
You need to design an application that allows the possibility to calculate the surface and perimeter for multiple types of shape: rectangle, square, circle and triangle.

The tool should allow the possibility to add multiple shapes and calculate the total sum for perimeter and for surface.

Also, the application should make sure that 2 similar shapes couldn’t be added to the drawing tool.
In case 2 similar shapes are added, an appropriate message should be printed to console.

Since you want to be sure that you provide a high quality implementation, unit tests are needed to prove the main functionalities described above, work correctly
(add all types of shapes, add duplicates, add single shape and pairs of shapes).

To deliver the work, just make a zip file and attached it to the answer.

 */

import org.w3c.dom.css.Rect;

import java.util.HashSet;
import java.util.Set;

public class ExtraAssignmentMain {

    public static void main(String[] args) {

        Set<Shape> shapeSet = new HashSet<>();
        Shape[] shapes = new Shape[5];
        shapes[0] = new Square(10.2);
        shapes[1] = new Square(10.20);
        shapes[2] = new Triangle(4,7,20);
        shapes[3] = new Circle(5);
        shapes[4] = new Rectangle(5.1,4.2);

        for ( Shape shape : shapes ){
//            boolean duplicate = shapeSet.add(shape);
            if ( !shapeSet.add(shape) ){
                System.out.println("Duplicate shape");
            }
        }

        for ( Shape shape : shapeSet){
            System.out.println(shape.toString());
        }




    }

}
