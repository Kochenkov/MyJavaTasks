package typical_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TasksAboutInternetConnection {

    public static void getInternetPageFromHttp() throws IOException {
        String url = "http://google.com";

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
}