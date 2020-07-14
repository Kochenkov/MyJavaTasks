import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AnotherTasks {

    public static final String str = "";

    public static void readFromHttp() throws IOException {
        String url = "http://google.com";

        HttpURLConnection connection;
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void readFromKeypad() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String str = bufferedReader.readLine();
        //String str = scan.nextLine();
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

    public static int searchFromDataset(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int max=0;
        int i=0;
        while (scan.hasNext()) {
            i = scan.nextInt();
            if (i>max) {
                max=i;
            }
        }
        return max;
    }

    public static int sumFromDataset(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int sum = 0;
        while (scan.hasNext()) {
            sum = sum + scan.nextInt();
        }
        return sum;
    }

    public static String findYearFromDataset(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String st = String.format("%s ddd %s", "rr", "ff", "gg");
        System.out.println(st);

        HashMap<Long, String> mapPeYe = new HashMap<>();
        List<Long> listPeople = new ArrayList<>();

        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] couple = str.split("\t");
            try {
                String peopleS = couple[1].replace(",", "");
                Long peopleL = Long.parseLong(peopleS);
                String year = couple[0];
                mapPeYe.put(peopleL, year);
                listPeople.add(peopleL);
            } catch (Exception ex) {
                System.out.println("1-st line");
            }
        }
        Long pKey = 0L;
        Long maxDif = 0L;
        for (int i=0; i<listPeople.size()-1; i++) {
            Long current = Math.abs(listPeople.get(i) - listPeople.get(i+1));
            if (maxDif<current) {
                maxDif = current;
                pKey = listPeople.get(i+1);
            }
        }
        return mapPeYe.get(pKey);
    }

}
