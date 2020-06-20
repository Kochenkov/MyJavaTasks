import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherTasks {

    public static void readFromKeypad() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        System.out.println(str + "!");
    }

    public static void readFromFile() throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/vkochenkov/Documents/NotWorkProjects/MyJavaTasks/src/main/resources/text1.txt"));
        //читаем файлы со всех строк
        while (bufferedReader.ready()) {
            System.out.print(bufferedReader.readLine());
        }
    }

    public static void writeFromFileToFile() throws FileNotFoundException, IOException {
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

}
