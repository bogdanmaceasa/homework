package extraHomework1;

public class PublicMethods {


    public static double tempConverter(int a) {

        return ((a - 32) / 1.8);
    }


    public static double inchConverter(float a) {

        return (a * 0.0254);
    }


    public static boolean equalNumbers(int a, int b, int c, int d) {

        return (a == b) && (a == c) && (a == d);
    }


    public static boolean isPosivite(int a) {

        return (a > 0);
    }


    public static float sumNum(int a, int b, int c, int d, int e) {

        return a + b + c + d + e;
    }


    public static boolean increaseDecrease(int a, int b) {

        return (a < b);
    }


    public static int arrayAvg(int[] a, int b) {

        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a[i];
        }

        return sum / b;
    }


    public static boolean checkElement(int[] a, int b, int c) {

        for (int i = 0; i < b; i++) {
            if (a[i] == c)
                return true;
        }

        return false;
    }

    public static int returnIndex(int[] a, int b, int c) {

        int i = 0;
        for (i = 0; i < b; i++) {
            if (a[i] == c)
                break;
        }
        return i;
    }


}



