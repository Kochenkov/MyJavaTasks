import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(findFibBad(40));
    }

    //0 1 1 2 3 5 6


    public static int findFibBad(int number) {
        if (number==0) {
            return 0;
        } else if (number==1) {
            return 1;
        } else {
            return (findFibBad(number-1) + findFibBad(number-2));
        }
    }
}