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

    public static void writeFromFileToFileLikeChars() throws IOException {
        Reader reader = new FileReader("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text1.txt");
        Writer writer = new FileWriter("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text2.txt");

        while (reader.ready()) {
            int c = reader.read();
            System.out.print(c);
            writer.write(c);
        }

        reader.close();
        writer.close();
    }

    public static void writeFromFileToFileLikeBytes() {
        //try with resources
        try (
            InputStream is = new FileInputStream("src/main/java/Main.java");
            OutputStream os = new FileOutputStream("Main2.java")
        ) {
            byte[] buffer = new byte[4098];

            int b = is.read(buffer);
            while (b != -1) {
                os.write(buffer, 0, b);
                b = is.read(buffer);
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }

    //hierarchy

    //for bytes:
        //abstract classes
            //InputStream;
            //OutputStream;
        //realisations examples:
            //FileInputStream;
            //ByteArrayInputStream;

    //for chars:
        //abstract classes
            //Reader;
            //Writer;
        //realisation examples:
            //FileReader;
            //FileWriter;

    //adapters: adapt bytes stream to stream of chars
        //Reader = InputStreamReader(InputStream)
        //Writer = OutputStreamWriter(OutputStream)

    //decorators: add new functionality to reader/writer
        //BufferedReader = BufferedReader(InputStreamReader(InputStream))
        //BufferedWriter = BufferedWriter(OutputStreamWriter(OutputStream))

}
