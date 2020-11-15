package tema1;


public class ArrayIsSquare {

    public static void main(String[] args) {

        int[][] biArray = {{1, 2, 4}, {1, 1, 5}, {1, 2, 3}};

        if (PublicMethods.isSquare(biArray))
            System.out.println("the array is square");
        else System.out.println("the array is not square");


    }


}
