import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file3 = new File("./src/main/resources/dataset_91069.txt");
        System.out.println(AnotherTasks.findYearFromDataset(file3));
        System.out.println(AnotherTasks.str);
    }

}