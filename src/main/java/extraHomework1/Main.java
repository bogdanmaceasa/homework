package extraHomework1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//1. Write a Java program to convert temperature from Fahrenheit to Celsius degree.
//            Test Data
//            Input a degree in Fahrenheit: 212
//            Expected Output:
//            212.0 degree Fahrenheit is equal to 100.0 in Celsius
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("input the desired temperature in Farenheit");
//        int temp = sc.nextInt();
//        System.out.println(temp + " degree Fahrenheit is equal to " +PublicClasses.tempConverter(temp) + " in Celsius");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//2. Write a Java program that reads a number in inches, converts it to meters.
//              Note: One inch is 0.0254 meter.
//              Test Data
//            Input a value for inch: 1000
//            Expected Output :
//                1000.0 inch is 25.4 meters
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("input the desired size in inch");
//        float temp = sc.nextFloat();
//        System.out.println(temp + " inch is " +PublicClasses.inchConverter(temp) + " meters");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 3. Write a Java program that accepts four integer from the user and prints equal if all four are equal, and not equal otherwise.
//       Sample Output:
//            Input first number: 25
//            Input second number: 37
//            Input third number: 45
//            Input fourth number: 23
//            Numbers are not equal!
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input first number: ");
//        int a = sc.nextInt();
//        System.out.println("Input second number: ");
//        int b = sc.nextInt();
//        System.out.println("Input third number: ");
//        int c = sc.nextInt();
//        System.out.println("Input fourth number: ");
//        int d = sc.nextInt();
//        if (PublicClasses.equalNumbers(a,b,c,d))
//            System.out.println(" Numbers are equal!");
//        else System.out.println(" Numbers are not equal!");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 4. Write a Java program to get a number from the user and print whether it is positive or negative.
//        Test Data
//        Input number: 35
//        Expected Output :
//        Number is positive
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input number: ");
//        int a = sc.nextInt();
//        if (PublicClasses.isPosivite(a))
//            System.out.println(" Number is positive ");
//        else System.out.println(" Number is negative ");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 5. Write a program in Java to input 5 numbers from keyboard and find their sum and average.
//        Test Data
//        Input the 5 numbers : 1 2 3 4 5
//        Expected Output :
//
//        Input the 5 numbers :
//        1
//        2
//        3
//        4
//        5
//        The sum of 5 no is : 15
//        The Average is : 3.0
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input the 5 numbers : ");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int d = sc.nextInt();
//        int e = sc.nextInt();
//        int cast = (int)PublicMethods.sumNum(a,b,c,d,e);
//        System.out.println("The sum of 5 numbers is : " + cast);
//        System.out.println("The Average is : " + (PublicMethods.sumNum(a,b,c,d,e)/5));


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 6. Write a program that accepts three numbers from the user and prints "increasing" if the numbers are in increasing order,
//    "decreasing" if the numbers are in decreasing order, and "Neither increasing or decreasing order" otherwise.
//
//    Test Data
//    Input first number: 1524
//    Input second number: 2345
//    Input third number: 3321
//    Expected Output :
//
//    Increasing order
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input first number: ");
//        int a = sc.nextInt();
//        System.out.println("Input second number: ");
//        int b = sc.nextInt();
//        System.out.println("Input third number: ");
//        int c = sc.nextInt();
//        if (PublicMethods.increaseDecrease(a,b)){
//            if (PublicMethods.increaseDecrease(b,c))
//                System.out.println("Increasing order");
//            else System.out.println("Neither increasing or decreasing order");
//        }
//        else if (PublicMethods.increaseDecrease(b,c))
//            System.out.println("Neither increasing or decreasing order");
//        else   System.out.println("Decreasing order");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//         7. Write a Java program to calculate the average value of array elements.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input the length of the array: ");
//        int a = sc.nextInt();
//        int[] array = new int[a];
//        for (int j=0;j<a;j++){
//            System.out.println("Input the desired value in the array: ");
//            array[j] = sc.nextInt();
//        }
//        System.out.println("Average of the elements of the array is: " + PublicMethods.arrayAvg(array, a));


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        8. Write a Java program to test if an array contains a specific value.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input the length of the array: ");
//        int a = sc.nextInt();
//        int[] array = new int[a];
//
//        for (int j=0;j<a;j++){
//            System.out.println("Input the desired value in the array: ");
//            array[j] = sc.nextInt();
//        }
//        System.out.println("Input the element to check against the array: ");
//        int b = sc.nextInt();
//        if (PublicMethods.checkElement(array,a,b))
//            System.out.println("Element is in the array");
//        else System.out.println("Element is not in the array");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        9. Write a Java program to find the index of an array element.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("Input the length of the array: ");
//        int a = sc.nextInt();
//        int[] array = new int[a];
//
//        for (int j=0;j<a;j++){
//            System.out.println("Input the desired value in the array: ");
//            array[j] = sc.nextInt();
//        }
//        System.out.println("Input the element to check the position in the array: ");
//        int b = sc.nextInt();
//        System.out.println("The position of the element is: " + PublicMethods.returnIndex(array,a,b));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        10. Write a Java program to remove a specific element from an array.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Input the length of the array: ");
        int a = sc.nextInt();
        int[] array = new int[a];

        for (int j=0;j<a;j++){
            System.out.println("Input the desired value in the array: ");
            array[j] = sc.nextInt();
        }
        System.out.println("Input the element to remove from the array: ");
        int b = sc.nextInt();
        for (int i= PublicMethods.returnIndex(array,a,b); i<a-1; i++){
            array[i]=array[i+1];
        }
        System.out.println("The new array elements are: ");
        for (int j=0;j<a-1;j++)
            System.out.println(array[j]);



    }

}
