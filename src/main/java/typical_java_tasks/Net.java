package typical_java_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class Net {

    public static void getInternetPageFromHttp() throws IOException {
        String url = "http://java-course.ru:80/network.txt";

        HttpURLConnection connection;
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());

            //отобразить веб-страницу
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void getRequestWithSocket() throws IOException {
        // Открываем сокет для доступа к компьютеру
        // по адресу "java-course.ru" (порт 80)
        Socket s = new Socket("java-course.ru", 80);

        // Открываем поток для чтения из сокета (информация будет
        // посылаться нам с удаленного компьютера
        InputStream in = s.getInputStream();
        // Открываем поток для записи в сокет (информация будет
        // посылаться от нас на удаленный компьютер
        OutputStream out = s.getOutputStream();

        // Готовим строчку с данными для запроса к серверу
        // Можно пока игнорировать смысл этого запроса
        String str = "GET /network.txt HTTP/1.1\r\n" +
                "Host:java-course.ru\r\n\r\n";

        // Превращаем их в массив байт для передачи
        // Мы же используем поток, а он работает с байтами
        byte buf[] = str.getBytes();
        // Пишем в поток вывода
        out.write(buf);

        // И читаем результат в буфер
        int size;
        byte buf_out[] = new byte[1024];
        while ((size = in.read(buf_out)) != -1) {
            System.out.print(new String(buf_out, 0, size));
        }
        s.close();
    }
}