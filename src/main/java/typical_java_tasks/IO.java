package typical_java_tasks;

import java.io.*;
import java.util.Scanner;

public class IO {

    public static void readFromKeypadWithBufferedReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        System.out.println(str + "!");
    }

    public static void readFromKeypadWithScanner() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str + "!");
    }

    public static void readFromFileWithBufferedReader() throws IOException {
        FileReader fileReader = new FileReader("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //читаем со всех строк и выводим в консоль
        while (bufferedReader.ready()) {
            System.out.print(bufferedReader.readLine());
        }
        fileReader.close();
    }

    public static void readFromFileWithScanner() throws IOException {
        FileReader fileReader = new FileReader("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text1.txt");
        Scanner scan = new Scanner(fileReader);
        //читаем со всех строк и выводим в консоль
        while (scan.hasNext()) {
            System.out.print(scan.nextLine());
        }
        fileReader.close();
    }

    public static void writeFromFileToFile() throws IOException {
        FileReader reader = new FileReader("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text1.txt");
        FileWriter writer = new FileWriter("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text2.txt");

        while (reader.ready()) {
            int c = reader.read();
            System.out.print(c);
            writer.write(c);
        }

        reader.close();
        writer.close();
    }

    //hierarchy

    //bytes:
        //abstract classes
            //InputStream;
            //OutputStream;
        //realisations:
            //FileInputStream;
            //ByteArrayInputStream;

    //chars:
        //abstract classes
            //Reader;
            //Writer;
        //realisations:
            //InputStreamReader; FileReader;
            //OutputStreamWriter; FileWriter;
}
