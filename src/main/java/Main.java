import java.io.*;

import static algorithms.GreatestCommonDivisor.findDivisor;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("src/main/java/Main.java");
        OutputStream os = new FileOutputStream("Main2.java");

        byte[] arr = new byte[4098];

        int b = is.read(arr);
        while (b != -1) {
            os.write(arr, 0, b);
            b = is.read(arr);
        }
        is.close();
        os.close();

    }
}