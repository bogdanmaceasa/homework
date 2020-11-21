package tema2;

public class Fibonacci {

    public static void main(String[] args) {

        int i=1;
        int index = 1;
        int j = 0;
        System.out.println(" Fibonacci ");
        while ( index <25 ){
            j+=i;
            System.out.println(i + " " );
            System.out.println(j + " " );
            i+=j;
            index+=2;

        }


    }



}
