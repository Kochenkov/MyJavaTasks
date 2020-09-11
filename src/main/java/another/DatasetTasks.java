package another;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DatasetTasks {

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
